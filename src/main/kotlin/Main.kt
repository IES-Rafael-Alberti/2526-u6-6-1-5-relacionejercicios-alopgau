package ej6_1
fun main() {
    println("Unidad 6 — Ejercicios 6.1 a 6.5")
    println("Implementa cada ejercicio en su paquete y documenta en docs/ejercicios/6.x.md")

    // Ejemplo Login

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

