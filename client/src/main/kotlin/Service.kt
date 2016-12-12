import java.io.IOException
import java.net.ServerSocket

/**
 * Created by djordje on 08.11.16.
 */
class Service constructor(val port: Int) {

    private var isStopped: Boolean = true
    val serverSocket = ServerSocket(port)
    // logger

    @Synchronized fun start() {
        if(!isStopped) {
            return
        }
        isStopped = false

        Thread(Sockets()).start()
    }

    /*@Synchronized fun stop() {
        isStopped = true
        if (!serverSocket.isClosed) serverSocket.close()
    }*/

    private inner class Sockets : Runnable {
        override fun run() {
            while (!isStopped) {
                try {
                    val clientSocket = serverSocket.accept()
                    //clientSocket.soTimeout = 100000
                    Thread(Client(clientSocket)).start()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}