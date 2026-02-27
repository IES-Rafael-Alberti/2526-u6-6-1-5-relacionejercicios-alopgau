package es.ies.ejercicios.u6.ej65.ocp

import es.ies.ejercicios.u6.ej64.Resumible

enum class FormatoInformeV0 {
    CSV,
    MARKDOWN,
    // TODO (ejercicio): cuando quieras añadir otro formato, v0 te obliga a modificar este enum y el `when`.
}

/**
 * v0 (viola OCP): para añadir un nuevo formato hay que modificar este `when`.
 */
class GeneradorInformeV0 {
    fun generar(formato: FormatoInformeV0, titulo: String, items: List<Resumible>): String =
        when (formato) {
            FormatoInformeV0.CSV -> generarCsv(titulo, items)
            FormatoInformeV0.MARKDOWN -> generarMarkdown(titulo, items)
        }

    private fun generarCsv(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("titulo,$titulo")
            appendLine("item")
            for (item in items) appendLine(item.resumen().replace(",", ";"))
        }

    private fun generarMarkdown(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("# $titulo")
            for (item in items) appendLine("- ${item.resumen()}")
        }
}

fun main() {
    val items = listOf<Resumible>(
        object : Resumible {
            override fun resumen(): String = "Elemento A"
        },
        object : Resumible {
            override fun resumen(): String = "Elemento B"
        },
    )

    val generador = GeneradorInformeV0()
    println(generador.generar(FormatoInformeV0.MARKDOWN, "Demo OCP", items))
}

