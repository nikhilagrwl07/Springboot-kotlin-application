package rc.SpringBootKotlinDemo.globalControllerAdvice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import rc.SpringBootKotlinDemo.exception.HotelNotFoundException
import java.lang.Exception
import java.util.*

@ControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(HotelNotFoundException::class)
    fun hotelNotFoundExceptionHandlerExceptionHandler(ex: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.message!!, Date().toInstant())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse)
    }
}