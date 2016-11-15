package resp_handlers

import ReqHandler
import data.ProfileData
import util.createHTTPHeader
import java.io.OutputStream

/**
 * Created by djordje on 10.11.16.
 */
class ProfileHandler : ReqHandler {
    override fun handleRequest(output: OutputStream) {

        output.use {
            try {
                val header = createHTTPHeader(200)
                val writer = it.writer()
                writer.write(header)
                writer.flush()
                val profilePageData = ProfileData(false)
                writer.write(profilePageData.getData().toString())
                writer.flush()
            } catch (e: Exception) {
                println("Profile")
            }
        }
    }
}