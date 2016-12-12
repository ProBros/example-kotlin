package util

import java.io.ByteArrayOutputStream
import java.io.InputStream

/**
 * Created by djordje on 09.11.16.
 */
class Util {
}

fun createHTTPHeader(returnCode: Int): String {
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

fun splitHTTPRequest(fullRoute : String) : String {
    val routeParts = fullRoute.split(' ')

    if (routeParts.get(1) == null) {
        throw Exception("Route is not correct.")
    }
    return routeParts.get(1)
}

fun readWholeLine(inputStream: InputStream): String {
    var byteArrayOutputStream = ByteArrayOutputStream()
    val input = inputStream
    var char = input.read()
    var isCR = false
    while (char != '\n'.toInt() && char != -1) {
        if (isCR) {
            isCR = false
            byteArrayOutputStream.write('\r'.toInt())
        }
        if (char == '\r'.toInt()) {
            isCR = true
        } else {
            byteArrayOutputStream.write(char)
        }
        char = input.read()
    }
    val result = byteArrayOutputStream.toString("UTF-8")
    //byteArrayOutputStream.flush()
    //byteArrayOutputStream.close()
    //byteArrayOutputStream.reset()
    return result

}

fun InputStream.readLine() : String {
    var byteArrayOutputStream = ByteArrayOutputStream()
    var char = read()
    var isCR = false
    while (char != '\n'.toInt() && char != -1) {
        if (isCR) {
            isCR = false
            byteArrayOutputStream.write('\r'.toInt())
        }
        if (char == '\r'.toInt()) {
            isCR = true
        } else {
            byteArrayOutputStream.write(char)
        }
        char = read()
    }
    val result = byteArrayOutputStream.toString("UTF-8")
    //byteArrayOutputStream.flush()
    //byteArrayOutputStream.close()
    //byteArrayOutputStream.reset()
    return result
}