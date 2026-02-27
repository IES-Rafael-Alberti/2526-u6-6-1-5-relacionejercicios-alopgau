package es.ies.ejercicios.u6.ej62.v0

fun main() {
    val generator = ReportGeneratorV0()
    val lines = listOf("Primera línea", "Segunda línea", "Tercera línea")

    println("[v0] Generando CSV...")
    println(generator.generate(ReportFormatV0.CSV, title = "Informe", lines = lines))

    println("[v0] Generando Markdown...")
    println(generator.generate(ReportFormatV0.MARKDOWN, title = "Informe", lines = lines))
}

