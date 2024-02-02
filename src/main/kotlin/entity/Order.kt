package org.example.entity

import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    val orderId: Long? = null,

    @Column(name = "customer_id")
    val customerId: Long,

    @Column(name = "order_date")
    val orderDate: Date
)
