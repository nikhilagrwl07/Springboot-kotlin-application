package rc.SpringBootKotlinDemo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbSeeder(val hotelRepository: HotelRepository) : CommandLineRunner {

    override
    fun run(vararg args: String?) {
        this.hotelRepository.deleteAll()

        val ibis = Hotel("ibis", 3, 30)
        val marriot = Hotel("marriot", 5, 100)
        val oneStart = Hotel(classification = 1, nbRooms = 50, name = "oneStartHotel")

        val hotels = mutableListOf<Hotel>()
        hotels.add(ibis)
        hotels.add(marriot)
        hotels.add(oneStart)

        hotelRepository.saveAll(hotels)

        println("--- Hotels saved in H2 database-------")
    }
}