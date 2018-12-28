package rc.SpringBootKotlinDemo.globalControllerAdvice

import java.time.Instant

data class ErrorResponse(val errorCode: Int, val message: String, val dateTime: Instant)