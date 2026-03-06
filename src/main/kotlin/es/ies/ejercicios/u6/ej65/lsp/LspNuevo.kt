package ej6_1.es.ies.ejercicios.u6.ej65.lsp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * Contrato: un repositorio que permite guardar y buscar personas.
 */
open class RepositorioPersonasNuevo {
    private val map = mutableMapOf<String, Persona>()

    open fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    open fun buscar(nombre: String): Persona? = map[nombre]
}

interface Lector {
    fun <K,V> leer(datos: Map<K,V>)
}

class RepositorioSoloLecturaNuevo : Lector {
    override fun <K,V> leer(datos: Map<K,V>) = println(datos)
    }


fun cliente(repo: RepositorioPersonasNuevo) {
    repo.guardar(Persona("Ana", 20))
    println("Buscar Ana -> ${repo.buscar("Ana")?.resumen()}")
}

fun main() {
    cliente(RepositorioPersonasNuevo())
}

