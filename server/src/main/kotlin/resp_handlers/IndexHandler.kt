package resp_handlers

import java.io.OutputStream
import ReqHandler
import data.IndexData
import util.createHTTPHeader

/**
 * Created by djordje on 08.11.16.
 */
class IndexHandler : ReqHandler {
    override fun handleRequest(output: OutputStream)  {

        output.use {
            try {
                val header = createHTTPHeader(200)
                val writer = it.writer()
                writer.write(header)
                val indexPageData = IndexData("ASD")
                writer.write(indexPageData.getData().toString())
                writer.flush()
            } catch (e : Exception) {
                println("Socket closed 2")
            }
        }
    }
}