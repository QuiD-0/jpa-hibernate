package com.quid.jpahibernate.annotations

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.Immutable
import org.hibernate.annotations.Subselect
import org.hibernate.annotations.Synchronize

@Entity
@Immutable
@Subselect(
    """
    select
        i.id as itemId,
        i.name as itemName,
        count(b.id) as numberOfBids
    from
        Item i
    left join
        Bid b on b.itemId = i.id
    group by
        i.id, i.name
    """
)
@Synchronize("Item", "Bid")
data class ItemBidSummary(
    @Id
    val itemId: Long,
    val itemName: String,
    val numberOfBids: Long
) {
}