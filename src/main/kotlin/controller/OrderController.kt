package org.example.controller

import org.example.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders")
class OrderController @Autowired constructor(private val orderService: OrderService) {

    @GetMapping("/customer-order-count")
    fun getCustomerOrderCount(): List<Pair<Long, Long>> {
        return orderService.getCustomerOrderCount()
    }
}
