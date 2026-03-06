package ej6_1.es.ies.ejercicios.u6.ej65.dip

import ej6_1.es.ies.ejercicios.u6.ej65.ocp.nuevo.Informe
import ej6_1.es.ies.ejercicios.u6.ej65.ocp.nuevo.Csv
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.Resumible


class ControladorInformesNuevo(private val generador: Informe) {


    fun imprimirListado(items: List<Resumible>) {
        val salida = generador.generar("Listado DIP", items)
        println(salida)
    }
}

fun main() {
    val controller = ControladorInformesNuevo(Csv())
    controller.imprimirListado(
        listOf(
            Persona("Ana", 20),
            Persona("Luis", 19),
        ),
    )
}

