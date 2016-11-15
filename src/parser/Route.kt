package parser

import util.splitHTTPRequest
/**
 * Created by djordje on 09.11.16.
 */
class Route {

    var route: String

    constructor(route: String) {
        this.route = route
    }

    fun parseRoute(): String {

        if("".equals(route)) {
            throw Exception("Route is empty")
        }

        val actualRoute = splitHTTPRequest(route)

        return actualRoute
    }



}




enum class HTTP {
    GET,
    POST,
    PUT,
    DELETE,
    HEAD
}
