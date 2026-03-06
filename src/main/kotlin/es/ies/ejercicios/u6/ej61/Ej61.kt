package es.ies.ejercicios.u6.ej61


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
        super.pedirCredenciales()
        println("Introduce tu contraseña")
        readln()
        while (!codigoValido) {
            println("Introduce el codigo numérico de 6 digitos que hemos enviado al correo asociado a tu usuario")
            val codigo = readln()
            if (codigo.length == 6 && codigo.all { it.isDigit() }) codigoValido = true else println("El código introducido no es válido")
        }
    }
}
// Ejemplo Login
fun main() {

val loginInvitado : Login = Login()
println("Login Básico")
println()
loginInvitado.pedirCredenciales()
val loginConCuenta : Login = LoginConCuenta()
println("Login con contraseña")
println()
loginConCuenta.pedirCredenciales()
val login2FA : Login = LoginConCuenta2FA()
println("Login con contraseña + 2FA")
println()
login2FA.pedirCredenciales()

// Ejemplo reproductorAudio
var reproductorAudio : ReproductorAudio = MP3("Sony", "Surround")
println("MP3\n")
reproductorAudio.reproducirAudio()
reproductorAudio = Timbre()
println("Timbre\n")
reproductorAudio.reproducirAudio()
println("Movil\n")
reproductorAudio = Movil("iPhone","7","Spotify")
reproductorAudio.reproducirAudio()

}



/**
 * Ejercicio 6.1 — Tipos de herencia, clases y subclases (RA7.a).
 *
 * TODO: Implementa aquí las clases del ejercicio.
 * Recomendación: crea subpaquetes (p. ej. `especializacion`, `extension`, etc.)
 * y añade un `main` de ejemplo que muestre polimorfismo.
 */
object Ej61
