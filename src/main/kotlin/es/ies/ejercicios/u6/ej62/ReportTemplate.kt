package es.ies.ejercicios.u6.ej62

/**
 * Plantilla (para el alumnado): usa clase abstracta + "Template Method".
 *
 * Objetivo didáctico:
 * - Forzar herencia/implementación: `abstract` + miembro `abstract`.
 * - Bloquear sobrescritura del algoritmo: método `final` (o no-`open`).
 */
abstract class ReportTemplate {
    final fun generate(title: String, lines: List<String>): String = buildString {
        appendLine(header("$title"))
        lines.forEach { appendLine(formatLine(it))
        }
        appendLine(footer())}

    protected open fun header(title: String): String = "$title"

    protected abstract fun formatLine(line: String): String

    protected open fun footer(): String = "Autor: Antonio"

}
