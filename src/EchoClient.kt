import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

fun main() {
    Socket("localhost", 6000).use {socket ->
        socket.soTimeout = 5000

        val echoes = BufferedReader(InputStreamReader(socket.getInputStream()))
        val stringToEcho = PrintWriter(socket.getOutputStream(), true)

        var echoString: String
        var response: String

        do {
            print("Enter string to be echoed: ")
            echoString = readLine().toString()
            stringToEcho.println(echoString)
            if (echoString != "exit") {
                response = echoes.readLine()
                println(response)
            }
        } while (echoString != "exit")
    }
}