package es.ies.ejercicios.u6.ej65.lsp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * Contrato: un repositorio que permite guardar y buscar personas.
 */
open class RepositorioPersonasV0 {
    private val map = mutableMapOf<String, Persona>()

    open fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    open fun buscar(nombre: String): Persona? = map[nombre]
}

/**
 * v0 (posible violación de LSP): una subclase rompe el contrato esperado de "guardar".
 * El código cliente que acepta [RepositorioPersonasV0] puede fallar al sustituirlo por esta subclase.
 */
class RepositorioSoloLecturaV0 : RepositorioPersonasV0() {
    override fun guardar(persona: Persona) {
        throw UnsupportedOperationException("Repositorio en modo solo lectura")
    }
}

fun cliente(repo: RepositorioPersonasV0) {
    repo.guardar(Persona("Ana", 20))
    println("Buscar Ana -> ${repo.buscar("Ana")?.resumen()}")
}

fun main() {
    println("[LSP:v0] Repositorio normal (ok)")
    cliente(RepositorioPersonasV0())

    println("\n[LSP:v0] Repositorio solo lectura (rompe sustitución)")
    try {
        cliente(RepositorioSoloLecturaV0())
    } catch (e: Exception) {
        println("ERROR: ${e::class.simpleName}: ${e.message}")
    }
}

