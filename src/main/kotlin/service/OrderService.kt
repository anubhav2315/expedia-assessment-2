package org.example.service

import org.example.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService @Autowired constructor(private val orderRepository: OrderRepository) {

    @Transactional(readOnly = true)
    fun getCustomerOrderCount(): List<Pair<Long, Long>> {
        val results = orderRepository.findCustomerOrderCount()
        return results.map { it[0] as Long to it[1] as Long }
    }
}
