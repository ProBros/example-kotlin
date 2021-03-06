import org.junit.Assert.*
import org.junit.Test
import parser.Route
import util.splitHTTPRequest

/**
 * Created by djordje on 09.11.16.
 */
class RouteParserTest {

    @Test(expected = Exception::class) fun testEmptyRoute() {
        Route("").parseRoute()
    }

    @Test fun testRoute() {
        val expectedResult = "/index"
        val result = Route("lorem /index ipsum").parseRoute()

        assertEquals(expectedResult, result)
    }

    @Test(expected = Exception::class) fun testRouteHasAtLeast2Parts() {
        splitHTTPRequest("assssssssssssdsad")
    }
}