package rc.SpringBootKotlinDemo.exception

import java.lang.RuntimeException

class HotelNotFoundException : RuntimeException(){
    override val message: String?
        get() = "Hotel not found"
}