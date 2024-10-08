package com.quid.jpahibernate.transaction.fetch

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Entity
class Orders{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null

    @JoinColumn(name = "order_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val items: MutableList<LineItem> = mutableListOf()

    fun addItem(lineItem: LineItem) {
        items.add(lineItem)
        lineItem.order = this
    }
}

@Entity
class LineItem(
    val name: String,
    val quantity: Int,
    val price: Double,
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
    @ManyToOne(fetch = FetchType.LAZY)
    var order: Orders? = null
}

interface OrderRepository : JpaRepository<Orders, Long> {
    @Query("SELECT o FROM Orders o JOIN FETCH o.items WHERE o.id = :orderId")
    fun findByIdWithJoin(orderId: Long): Orders?
}

@Service
class NPlusOne(
    private val orderRepository: OrderRepository,
) {
    @Transactional
    fun saveOrder(orders: Orders): Orders = orderRepository.save(orders)

    @Transactional(readOnly = true)
    fun findOrder(orderId: Long): List<Orders> = orderRepository.findAll().toList()

    @Transactional(readOnly = true)
    fun findOrderWithJoinFetch(orderId: Long): Orders? = orderRepository.findByIdWithJoin(orderId)
}