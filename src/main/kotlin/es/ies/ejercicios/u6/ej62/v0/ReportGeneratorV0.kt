package es.ies.ejercicios.u6.ej62.v0

/**
 * Versión base (v0): NO usa clase abstracta.
 *
 * Problema: al añadir un nuevo formato, tiende a crecer el `when` y se mezclan decisiones
 * (formato, cabeceras, pie, etc.) en una única clase.
 */
class ReportGeneratorV0 {
    fun generate(format: ReportFormatV0, title: String, lines: List<String>): String =
        when (format) {
            ReportFormatV0.CSV -> generateCsv(title, lines)
            ReportFormatV0.MARKDOWN -> generateMarkdown(title, lines)
        }

    private fun generateCsv(title: String, lines: List<String>): String =
        buildString {
            appendLine("title,$title")
            appendLine("line")
            for (line in lines) appendLine(line)
        }

    private fun generateMarkdown(title: String, lines: List<String>): String =
        buildString {
            appendLine("# $title")
            for (line in lines) appendLine("- $line")
        }
}

