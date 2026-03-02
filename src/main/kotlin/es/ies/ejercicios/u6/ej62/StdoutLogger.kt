package es.ies.ejercicios.u6.ej62

open class BaseLogger : Logger {
    override fun log(message: String) {
        println("$message")
    }
}

class StdoutLogger : BaseLogger() {
    final override fun log(message: String) {
        println("> $message")
    }
}
