package org.example.repository

import org.example.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrderRepository : JpaRepository<Order, Long> {

    @Query("SELECT o.customerId, COUNT(o) FROM Order o GROUP BY o.customerId ORDER BY COUNT(o) DESC")
    fun findCustomerOrderCount(): List<Array<Any>>
}
