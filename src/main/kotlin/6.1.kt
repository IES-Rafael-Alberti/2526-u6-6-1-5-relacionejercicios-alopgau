package ej6_1

// Especificación

interface ReproductorAudio {
    fun reproducirAudio(): Unit
}
class MP3(val marca: String, val modelo: String) : ReproductorAudio {
    override fun reproducirAudio() = println("Mi MP3 $marca $modelo hace sonar mis canciones favoritas")
}
class Timbre() : ReproductorAudio {
    override fun reproducirAudio() = println("El timbre hace ding dong")
}
class Movil(val marca: String, val modelo: String, val plataformaDeAudio: String): ReproductorAudio {
    override fun reproducirAudio() = println("Escucho música en mi $marca $modelo a través de $plataformaDeAudio")
}

// Extensión

open class Login() {
    open fun pedirCredenciales() {
        println("Introduce tu nombre de usuario")
        readln()
    }
}
class LoginConCuenta : Login() {
    override fun pedirCredenciales() {
        super.pedirCredenciales()
        println("Introduce tu contraseña")
        readln()
    }
}
class LoginConCuenta2FA : Login() {
    override fun pedirCredenciales() {
        var codigoValido = false
      val usuario = super.pedirCredenciales()
        println("Introduce tu contraseña")
        readln()
        while (!codigoValido) {
        println("Introduce el codigo numérico de 6 digitos que hemos enviado al correo asociado a tu usuario ($usuario)")
        val codigo = readln()
        if (codigo.length == 6 && codigo.all { it.isDigit() }) codigoValido = true else println("El código introducido no es válido")
        }
    }
}