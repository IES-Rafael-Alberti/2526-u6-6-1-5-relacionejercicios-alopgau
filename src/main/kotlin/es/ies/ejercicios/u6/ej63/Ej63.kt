package es.ies.ejercicios.u6.ej63

/**
 * Ejercicio 6.3 — Incidencia de constructores en la herencia (RA7.c).
 *
 * Punto de partida: revisa `Figuras.kt` y completa lo indicado en `docs/ejercicios/6.3.md`.
 */
object Ej63

fun main() {
    println("Ejercicio 6.3 (plantilla)")
    println("- Completa la jerarquía y los constructores en `es.ies.ejercicios.u6.ej63`")
    println("- Añade logs en init/constructores para ver el orden de inicialización")
    println("- Actualiza este main para instanciar usando distintos constructores")
    println("\nFigura\n")
    Figura("Amarillo","Figura 1")
    Figura("Amarillo")
    println("\nRectangulo\n")
    Rectangulo("Azul","Rectangulo 1",3,4)
    Rectangulo(3,4)
    Rectangulo(3)
    println("\nCirculo\n")
    Circulo("verde","circulo-1",3)
    Circulo(3)
    println("\nTriángulo\n")
    Triangulo(3,5)
    Triangulo(2)
}
