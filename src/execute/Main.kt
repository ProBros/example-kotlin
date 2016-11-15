fun main(args: Array<String>) {

    try {

        val service = Service(8080)

        service.start()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


