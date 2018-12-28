package rc.SpringBootKotlinDemo.integrationTest

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HotelIntIntegrationTest{

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun getAllHotels_returnAllHotelDetails(){
        //arrange

        //act
        val allHotels = restTemplate.getForEntity("/hotels/all", List::class.java)

        //assert
        assertNotNull(allHotels)
        assertEquals(allHotels.statusCode, HttpStatus.OK)
        assertEquals(allHotels.body!!.size, 3)
    }

    @Test
    fun getHotelByName(){
        //arrange
        val name:String = "ibis"

        //act
        val hotelsByName = restTemplate.getForEntity("/hotels/{name}", List::class.java, name)

        //assert
        assertNotNull(hotelsByName)
        assertEquals(hotelsByName.statusCode,HttpStatus.OK)
        assertEquals(hotelsByName.body!!.size, 1)
    }

}