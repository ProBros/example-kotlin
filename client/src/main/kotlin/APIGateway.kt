import parser.Route
import util.createHTTPHeader
import util.splitHTTPRequest
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.util.*

/**
 * Created by djordje on 08.11.16.
 */
class APIGateway private constructor(){

    private object Holder { val INSTANCE = APIGateway() }

    companion object {
        val instance: APIGateway by lazy { Holder.INSTANCE }
    }

    fun makeResponse(route: String, output: OutputStream): String {
        if(handlerMap().get(route) != null) {
            handlerMap().get(route)!!.build().handleRequest(output)
        } else {
            output.buffered().use {
                try {
                    val header = createHTTPHeader(404)
                    var writer = it.writer()
                    writer.write(header)
                    writer.write("404 Not found!")
                    writer.flush()
                    return "404 Not found!"
                } catch (e : Exception) {
                    println("4040040404")
                }
            }
        }
        return route
    }

    fun handlerMap() : HashMap<String, ReqHandlerBuilder> {
        val handlers = HashMap<String, ReqHandlerBuilder>()
        handlers.put(IndexHandlerBuilder().getRoute(), IndexHandlerBuilder())
        handlers.put(ProfileHandlerBuilder().getRoute(), ProfileHandlerBuilder())
        return handlers
    }

}