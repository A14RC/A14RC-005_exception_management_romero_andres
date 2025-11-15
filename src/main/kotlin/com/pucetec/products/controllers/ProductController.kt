package com.pucetec.products.controllers

import com.pucetec.products.models.entities.Product
import com.pucetec.products.repositories.ProductRepository
import com.pucetec.products.services.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/products"])
class ProductController (
    private val productService: ProductService,
){

    @PostMapping
    fun save(@RequestBody product: Product): Product {
        return productService.save(product)
    }
}