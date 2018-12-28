package rc.SpringBootKotlinDemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController{

    @Autowired
    lateinit var hotelService: HotelService

    @GetMapping("/all")
    fun all(): MutableIterable<Hotel> = this.hotelService.getAllHotels()


    @GetMapping("/{name}")
    fun findHotelByName(@PathVariable(value = "name") name: String?): List<Hotel> = hotelService.findHotelByName(name)


    @PostMapping("/checkIn")
    fun checkIn(@RequestBody checkInRequest : CheckInRequest):Hotel = this.hotelService.checkInGuets(checkInRequest)
}
