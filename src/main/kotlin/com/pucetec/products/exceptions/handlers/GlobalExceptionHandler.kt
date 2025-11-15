package com.pucetec.products.exceptions.handlers

import com.pucetec.products.exceptions.ProductAlreadyExistsException
import com.pucetec.products.exceptions.StockOutOfRangeException
import com.pucetec.products.exceptions.ProductNotFoundException
import com.pucetec.products.models.responses.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * Manejador de excepciones
 * Traducir excepciones hacia codigos http]
 */

@RestControllerAdvice
class GlobalExceptionHandler {

    //Convertir un error de tipo StockOutOfRangeException -> Http BAD REQUEST -> 400
    @ExceptionHandler(StockOutOfRangeException::class)
    fun handlerStockOutOfRangeException(
        ex: StockOutOfRangeException
    ): ResponseEntity<ErrorResponse>{
        return ResponseEntity(
            ErrorResponse(ex.message),
            HttpStatus.BAD_REQUEST
        )
    }

    //Convertir ProductNotFoundException -> Http NOT FOUND -> 404
    @ExceptionHandler(ProductNotFoundException::class)
    fun handlerProductNotFoundException(
        ex: ProductNotFoundException
    ): ResponseEntity<ErrorResponse>{
        return ResponseEntity(
            ErrorResponse(ex.message),
            HttpStatus.NOT_FOUND
        )
    }


    @ExceptionHandler(ProductAlreadyExistsException::class)
    fun handlerProductAlreadyExistsException(
        ex: ProductAlreadyExistsException
    ): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(ex.message),
            HttpStatus.BAD_REQUEST
        )
    }


}





/**
 * 200 -> OK
 *
 * 400 -> Bad Request
 *
 * 404 -> Not Found
 *
 * 403 -> Forbidden
 *
 * 401 -> Unauthorized
 *
 * 5xx -> I fucked up -> Error del sistema SIN CAPTURAS (EVITAR A TODA COSTA)
 * SI PASA ESTO EN EL EXAMEN SON PUNTOS MENOS
 */