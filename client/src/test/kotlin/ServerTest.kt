import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import parser.Route
import java.io.*
import java.net.Socket

/**
 * Created by djordje on 10.11.16.
 */
class ServerTest {

    companion object {
        private val port = 8080
        private val url = "localhost"

        @JvmStatic @BeforeClass fun beforeClass() {
            main(arrayOf())
        }
    }

    @Test fun isConnected() {
        val socket : Socket = Socket(url, port)
        Thread(Client(socket)).start()
        val result = socket.isConnected
        assertEquals(true, result)
    }

    @Test fun isConnectedMultiple() {
        val socket : Socket = Socket(url, port)
        val socket2 : Socket = Socket(url, port)
        Thread(Client(socket)).start()
        Thread(Client(socket2)).start()
        val result = socket.isConnected
        val result2 = socket2.isConnected
        assertEquals(true, result)
        assertEquals(true, result2)
    }

    @Test fun responseIndexPage() {
        val socket : Socket = Socket(url, port)
        val actualRoute = Route("loremipsum /index loremipsum").parseRoute()
        val result = "/index"
        var route: String = ""
        Thread(Client(socket)).start()
        val input = BufferedReader(InputStreamReader(socket.inputStream))
        input.use {
            route = APIGateway.instance.makeResponse(actualRoute, socket.outputStream)
        }
        assertEquals(result, route)
    }

    @Test fun responseProfilePage() {
        val socket : Socket = Socket(url, port)
        val actualRoute = Route("loremipsum /profile loremipsum").parseRoute()
        val result = "/profile"
        var route: String = ""
        Thread(Client(socket)).start()
        val input = BufferedReader(InputStreamReader(socket.inputStream))
        input.use {
            route = APIGateway.instance.makeResponse(actualRoute, socket.outputStream)
        }
        assertEquals(result, route)
    }

}