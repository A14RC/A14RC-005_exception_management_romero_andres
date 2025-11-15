package com.pucetec.products.services

import com.pucetec.products.exceptions.ProductAlreadyExistsException
import com.pucetec.products.exceptions.StockOutOfRangeException
import com.pucetec.products.exceptions.ProductNotFoundException
import com.pucetec.products.models.entities.Product
import com.pucetec.products.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun save(product: Product): Product {
        if (product.stock >= 10) {
            throw StockOutOfRangeException("Stock out of range")
        }

        if (productRepository.findByName(product.name) != null) {
            throw ProductAlreadyExistsException("Product already exists")
        }

        return productRepository.save(product)
    }


    fun findById(id: Long): Product {
        return productRepository.findById(id)
            .orElseThrow { ProductNotFoundException("Product not found") }
    }
}
