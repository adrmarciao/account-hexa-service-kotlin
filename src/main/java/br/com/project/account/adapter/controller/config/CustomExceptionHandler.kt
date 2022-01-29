package br.com.project.account.adapter.controller.config

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest


@RestControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(Error::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleAllExceptions(ex: Exception, request: WebRequest?): ErrorResponse {
        val details: MutableList<String> = ArrayList()
        ex.cause?.message?.let { details.add(it) }
        return ErrorResponse("Server Error", details)
    }

}

data class ErrorResponse(val msg: String, val details: List<String>)