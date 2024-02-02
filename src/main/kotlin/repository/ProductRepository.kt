package org.example.repository

import org.springframework.data.jpa.repository.Query


// Question 1
interface ProductRepository {

    //@Query("SELECT  product_id, name,  price FROM Product p WHERE p.price > 50")
    //fun findProducts(): Collection<Product?>?
}