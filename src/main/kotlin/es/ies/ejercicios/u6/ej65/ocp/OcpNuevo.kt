package ej6_1.es.ies.ejercicios.u6.ej65.ocp.nuevo

import es.ies.ejercicios.u6.ej64.Resumible

enum class FormatoInformeV0 {
    CSV,
    MARKDOWN,
    // TODO (ejercicio): cuando quieras añadir otro formato, v0 te obliga a modificar este enum y el `when`.
}

/**
 * v0 (viola OCP): para añadir un nuevo formato hay que modificar este `when`.
 */
abstract class Informe {
    final fun generar(titulo: String,items: List<Resumible>) = buildString {
        appendLine(cabecera(titulo))
        items.forEach { appendLine(lineas(it.resumen())) }
    }
    abstract fun cabecera(titulo: String) : String
    abstract fun lineas(contenido: String) : String
    }

    class Csv(): Informe() {
        final override fun cabecera(titulo: String) = "titulo,$titulo"
        final override fun lineas(contenido: String) = "$contenido"

    }
    class Markdown(): Informe() {
        final override fun cabecera(titulo: String) = "# $titulo"
        final override fun lineas(contenido: String) = "- $contenido"
    }
    class HTML(): Informe() {
        final override fun cabecera(titulo: String) = "<h1>$titulo</h1>"
        final override fun lineas(contenido: String) = "<p>$contenido<p>"
    }

fun main() {
    val items = listOf<Resumible>(
        object : Resumible {
            override fun resumen(): String = "Elemento A"
        },
        object : Resumible {
            override fun resumen(): String = "Elemento B"
        }
    )
    println(HTML().generar("OCP Nuevo",items))
    println(Markdown().generar("OCP Nuevo",items))
    println(Csv().generar("OCP Nuevo",items))


}

