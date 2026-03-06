package es.ies.ejercicios.u6.ej65
import ej6_1.es.ies.ejercicios.u6.ej65.dip.ControladorInformesNuevo
import ej6_1.es.ies.ejercicios.u6.ej65.isp.BuscadorPersonasV0
import ej6_1.es.ies.ejercicios.u6.ej65.isp.RepositorioMemoriaV0
import ej6_1.es.ies.ejercicios.u6.ej65.lsp.RepositorioPersonasNuevo
import ej6_1.es.ies.ejercicios.u6.ej65.lsp.cliente
import ej6_1.es.ies.ejercicios.u6.ej65.ocp.nuevo.Csv
import ej6_1.es.ies.ejercicios.u6.ej65.ocp.nuevo.HTML
import ej6_1.es.ies.ejercicios.u6.ej65.ocp.nuevo.Markdown
import ej6_1.es.ies.ejercicios.u6.ej65.srp.App
import es.ies.ejercicios.u6.ej64.Alumno
import es.ies.ejercicios.u6.ej64.Persona

/**
 * Ejercicio 6.5 — Principios SOLID (RA7.d,e,f,g).
 *
 * Punto de partida: revisa los subpaquetes `srp`, `ocp`, `lsp`, `isp`, `dip`.
 *
 * TODO: Aplica SOLID mediante refactors con sentido y documenta en `docs/ejercicios/6.5.md`.
 */
object Ej65

fun main() {
    println("Ejercicio 6.5 (plantilla)")
    println("- Revisa `docs/ejercicios/6.5.md` para tareas SRP/OCP/LSP/ISP/DIP")
    println("- Ejecuta los mains de cada subpaquete para ver el punto de partida (v0)")
    println("\nSRP\n")
    val items = listOf(
        Persona(" Ana ", 20),
        Alumno("Luis", 19, "1DAM"),
        Persona("Marta", 18)
    )
    val srp = App()
    srp.ejecutar()
    println("\nOCP\n")
    println(HTML().generar("OCP Nuevo",items))
    println(Markdown().generar("OCP Nuevo",items))
    println(Csv().generar("OCP Nuevo",items))
    println("\nLSP\n")
    cliente(RepositorioPersonasNuevo())
    println("\nISP\n")
    val repo = RepositorioMemoriaV0()
    repo.guardar(Persona("Ana", 20))

    println("\nDIP\n")
    val buscador = BuscadorPersonasV0(repo)
    println("Buscar Ana -> ${buscador.buscar("Ana")?.resumen()}")
    val controller = ControladorInformesNuevo(Csv())
    controller.imprimirListado(
        listOf(
            Persona("Ana", 20),
            Persona("Luis", 19),
        ),
    )
}
