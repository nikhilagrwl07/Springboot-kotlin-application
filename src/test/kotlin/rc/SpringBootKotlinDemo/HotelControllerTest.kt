package rc.SpringBootKotlinDemo

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(HotelController::class)
class HotelControllerTest{

    @Autowired
    lateinit var mockmvc: MockMvc

    @MockBean
    lateinit var hotelService:HotelService

    lateinit var allHotels:List<Hotel>
    lateinit var ibisHotel:List<Hotel>

    @Before
    fun createAllValues(){

        allHotels = listOf(
                Hotel("ibis", 3, 30),
                Hotel("marriot", 5, 100),
                Hotel(classification = 1, nbRooms = 50, name = "oneStartHotel")
                )

        ibisHotel = listOf(
                Hotel("ibis", 3, 30)
        )
    }

    @Test
    fun  getAllHotels_returnAllHotelDetails() {

        //arrange
        given(hotelService.getAllHotels()).willReturn(allHotels.toMutableList())

        //act and assert
        mockmvc.perform(MockMvcRequestBuilders.get("/hotels/all"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.[0].name").value("ibis"))
                .andExpect(jsonPath("$.[0].classification").value(3))
                .andExpect(jsonPath("$.[0].nbRooms").value(30))
    }

    @Test
    fun getHotelByName(){
        //arrange
        val name:String = "ibis"
        given(hotelService.findHotelByName(anyString())).willReturn(ibisHotel.toMutableList())

        //act and assert
        mockmvc.perform(MockMvcRequestBuilders.get("/hotels/ibis"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.[0].name").value("ibis"))
                .andExpect(jsonPath("$.[0].classification").value(3))
                .andExpect(jsonPath("$.[0].nbRooms").value(30))
    }


}