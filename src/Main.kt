import java.net.HttpURLConnection
import java.net.URI

fun main() {
    val r = httpGet("https://jsonplaceholder.typicode.com/posts")
    println(r)
}

fun httpGet(urlString: String): String {
    val url = URI.create(urlString)
    val connection = url.openConnection() as HttpURLConnection
    val response: String

    try {
        connection.requestMethod = "GET"
        connection.connectTimeout = 1000
        connection.readTimeout = 1000
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android)")
        response = connection.inputStream.bufferedReader().use{it.readText()}
    }finally {
        connection.disconnect()
    }

    return response
}