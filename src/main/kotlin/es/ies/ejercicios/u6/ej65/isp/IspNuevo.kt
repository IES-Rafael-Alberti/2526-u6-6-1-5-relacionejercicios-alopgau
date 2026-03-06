package ej6_1.es.ies.ejercicios.u6.ej65.isp

import es.ies.ejercicios.u6.ej64.Persona


interface RepositorioPersonasCompletoV0 {
    fun guardar(persona: Persona)
    fun exportarCsv(): String
    fun borrarTodo()
}
interface Buscador {
    fun buscar(nombre: String): Persona?

}

class RepositorioMemoriaV0 : RepositorioPersonasCompletoV0, Buscador {
    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }
    final override fun buscar(nombre: String): Persona? = map[nombre]


    override fun exportarCsv(): String =
        buildString {
            appendLine("nombre,edad")
            for (p in map.values) appendLine("${p.nombre},${p.edad}")
        }

    override fun borrarTodo() {
        map.clear()
    }
}

/**
 * Cliente que solo necesita buscar, pero depende de una interfaz con demasiadas cosas.
 */
class BuscadorPersonasV0(private val repo: RepositorioMemoriaV0): Buscador {
    override fun buscar(nombre: String): Persona? = repo.buscar(nombre)
}

fun main() {
    val repo = RepositorioMemoriaV0()
    repo.guardar(Persona("Ana", 20))

    val buscador = BuscadorPersonasV0(repo)
    println("Buscar Ana -> ${buscador.buscar("Ana")?.resumen()}")
}

