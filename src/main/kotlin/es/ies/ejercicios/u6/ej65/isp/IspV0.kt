package es.ies.ejercicios.u6.ej65.isp

import es.ies.ejercicios.u6.ej64.Persona

/**
 * v0 (viola ISP): interfaz "gorda" que fuerza a implementar métodos que algunos clientes no necesitan.
 */
interface RepositorioPersonasCompletoV0 {
    fun guardar(persona: Persona)
    fun buscar(nombre: String): Persona?
    fun exportarCsv(): String
    fun borrarTodo()
}

class RepositorioMemoriaV0 : RepositorioPersonasCompletoV0 {
    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }

    override fun buscar(nombre: String): Persona? = map[nombre]

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
class BuscadorPersonasV0(private val repo: RepositorioPersonasCompletoV0) {
    fun buscar(nombre: String): Persona? = repo.buscar(nombre)
}

fun main() {
    val repo = RepositorioMemoriaV0()
    repo.guardar(Persona("Ana", 20))

    val buscador = BuscadorPersonasV0(repo)
    println("Buscar Ana -> ${buscador.buscar("Ana")?.resumen()}")
}

