package resp_handlers

import ReqHandler
import data.ProfileData
import java.io.OutputStream

/**
 * Created by djordje on 10.11.16.
 */
class ProfileHandler : ReqHandler {
    override fun handleRequest(output: OutputStream) {

        output.writer(Charsets.UTF_8).use {
            try {
                val header = createHeader(200)
                it.write(header)
                it.flush()
                val profilePageData = ProfileData(false)
                it.write(profilePageData.getData().toString())
                it.flush()
            } catch (e: Exception) {
                println("Profile")
            }
        }
    }
}