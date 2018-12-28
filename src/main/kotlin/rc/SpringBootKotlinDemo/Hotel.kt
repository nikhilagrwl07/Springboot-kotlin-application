package rc.SpringBootKotlinDemo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.*
import javax.persistence.Id

@Entity
data class Hotel(val name: String, val classification: Int, val nbRooms: Int) { // inline constructor as primary constructor

    @Id
    @GeneratedValue(strategy = AUTO)
    var id: Long = 0

    var nbFreeRooms: Int = this.nbRooms


    fun checkIn(nbGuests: Int) {
        if (nbFreeRooms > nbGuests)
            nbFreeRooms -= nbGuests
    }

    fun checkOut(nbGuests: Int) {
        nbFreeRooms += nbGuests
    }
}


