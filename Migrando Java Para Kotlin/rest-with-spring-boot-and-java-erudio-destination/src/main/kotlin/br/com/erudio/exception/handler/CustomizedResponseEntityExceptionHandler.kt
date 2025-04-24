package br.com.erudio.exception.handler

import br.com.erudio.exception.ExceptionResponse
import br.com.erudio.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @org.springframework.web.bind.annotation.ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(ex: java.lang.Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse: ExceptionResponse =
            ExceptionResponse(
                Date(),
                ex.message!!,
                request.getDescription(false)
            )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException::class)
    fun handleBadRequestExceptions(ex: java.lang.Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse: ExceptionResponse =
            ExceptionResponse(
                Date(),
                ex.message!!,
                request.getDescription(false)
            )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}
