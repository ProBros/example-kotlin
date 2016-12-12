package resp_handlers

import java.io.OutputStream
import ReqHandler
import data.IndexData

/**
 * Created by djordje on 08.11.16.
 */
class IndexHandler : ReqHandler {
    override fun handleRequest(output: OutputStream)  {

        output.writer(Charsets.UTF_8).use {
            try {
                val header = createHeader(200)
                it.write(header)
                val indexPageData = IndexData("ASD")
                it.write(indexPageData.getData().toString())
                it.flush()
            } catch (e : Exception) {
                println("Socket closed 2")
            }
        }
    }
}