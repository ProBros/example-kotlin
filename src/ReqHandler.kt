import resp_handlers.IndexHandler
import resp_handlers.ProfileHandler
import java.io.OutputStream
import javax.xml.ws.Response

/**
 * Created by djordje on 08.11.16.
 */
interface ReqHandler {

    fun handleRequest(output: OutputStream)
}

interface ReqHandlerBuilder {
    fun build(): ReqHandler
    fun getRoute(): String
}

class IndexHandlerBuilder : ReqHandlerBuilder {
    override fun getRoute(): String {
        return "/index"
    }

    override fun build(): ReqHandler {
        return IndexHandler()
    }

}

class ProfileHandlerBuilder : ReqHandlerBuilder{
    override fun build(): ReqHandler {
        return ProfileHandler()
    }

    override fun getRoute(): String {
        return "/profile"
    }

}