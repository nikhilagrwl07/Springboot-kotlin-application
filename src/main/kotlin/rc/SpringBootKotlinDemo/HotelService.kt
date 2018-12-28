package rc.SpringBootKotlinDemo

import org.springframework.stereotype.Service
import rc.SpringBootKotlinDemo.exception.HotelNotFoundException
import java.lang.IllegalArgumentException

@Service
class HotelService(val hotelRepository: HotelRepository) {

    fun getAllHotels(): MutableIterable<Hotel> = hotelRepository.findAll()


    fun findHotelByName(hotelName: String?): List<Hotel> {

        when {
            hotelName != null -> {
                val hotelByName = hotelRepository.findByName(hotelName)

                when {
                    hotelByName.isEmpty() -> throw HotelNotFoundException()
                    else -> return hotelByName
                }
            }
        }
        throw IllegalArgumentException()
    }

    fun checkInGuets(checkInRequest: CheckInRequest): Hotel {
        val hotelByName = this.hotelRepository.findByName(checkInRequest.hotelName).get(0)
        hotelByName.checkIn(checkInRequest.nbGuest)
        return hotelRepository.save(hotelByName)
    }


}