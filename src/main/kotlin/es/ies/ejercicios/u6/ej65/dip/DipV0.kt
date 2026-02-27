package es.ies.ejercicios.u6.ej65.dip

import es.ies.ejercicios.u6.ej64.InformeCsv
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.Resumible

/**
 * v0 (viola DIP): un módulo de alto nivel depende de un detalle concreto: [InformeCsv].
 * El ejercicio consiste en introducir una abstracción e inyectar dependencias.
 */
class ControladorInformesV0 {
    private val generador = InformeCsv() // detalle concreto

    fun imprimirListado(items: List<Resumible>) {
        val salida = generador.generar("Listado DIP", items)
        println(salida)
    }
}

fun main() {
    val controller = ControladorInformesV0()
    controller.imprimirListado(
        listOf(
            Persona("Ana", 20),
            Persona("Luis", 19),
        ),
    )
}

