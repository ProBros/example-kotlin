import parser.Route
import util.readLine
import util.readWholeLine
import java.net.Socket

/**
 * Created by djordje on 08.11.16.
 */
class Client(val clientSocket: Socket) : Runnable{
    override fun run() {
        try {
            val input = clientSocket.inputStream
            input.use {
                val inLine = Route(input.bufferedReader().readLine()).parseRoute()

                // created this method readWholeLine(InputStream), it returns the proper string but the outputstreams don't work after it executes,
                // I think that it doesn't clean "buf" field of the output stream, I tried flushing it, closing it, resetting it but it didn't help :(
                //val inLine = Route(readWholeLine(it)).parseRoute()
                //val inLine = Route(it.readLine()).parseRoute()
                APIGateway.instance.makeResponse(inLine, clientSocket.outputStream)
            }
        } catch (e : Exception) {
            println("Socket closed")
        } finally {
            clientSocket.close()
        }
    }

}