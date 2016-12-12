package resp_handlers

/**
 * Created by djordje on 12.12.16.
 */


fun createHeader(returnCode: Int): String {
    return StringBuilder().apply {
        append("HTTP/1.1 ")
        when (returnCode) {
            200 -> append("200 OK")
            400 -> append("400 Bad Request")
            else -> append("404 Not Found")
        }
        append("\r\n")
        append("Connection: close\r\n")
        if (returnCode == 200) append("Content-Type: text/plain\r\n")
        append("\r\n")
    }.toString()
}