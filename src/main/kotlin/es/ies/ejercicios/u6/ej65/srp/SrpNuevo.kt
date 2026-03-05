package ej6_1.es.ies.ejercicios.u6.ej65.srp
import es.ies.ejercicios.u6.ej64.Alumno
import es.ies.ejercicios.u6.ej64.InformeMarkdown
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.PlantillaInforme
import es.ies.ejercicios.u6.ej64.Resumible

class App() {
    var estado: Estado = Estado.APAGADO
    val gestorMensajesApp = MensajesApp(Consola())
    val registrador = Registrador()
    val generador = Generador()

    private fun cambiarAEstado(estado: Estado) {
        this.estado = estado
        gestorMensajesApp.leerEstado(this.estado)
    }

    fun ejecutar() {
        val items = preparar()
        registrarPersonas(items)
        val resultado = generarInforme(items)
        mostrarResultado(resultado)
        finalizarEjecucion()
    }

    private fun preparar(): List<Persona> {
        cambiarAEstado(Estado.PREPARANDO)
        val items = listOf(
            Persona(" Ana ", 20),
            Alumno("Luis", 19, "1DAM"),
            Persona("Marta", 18)
        )
        return items
    }

    private fun registrarPersonas(items: List<Persona>) {
        cambiarAEstado(Estado.REGISTRANDO)
        items.forEach { registrador.registrar(it) }
    }

    private fun generarInforme(items: List<Resumible>): String {
        cambiarAEstado(Estado.GENERANDO)
        return generador.generar(InformeMarkdown(), items)
    }

    private fun mostrarResultado(salida: String) {
        cambiarAEstado(Estado.FINALIZANDO)
        gestorMensajesApp.mostrarInfo(salida)

    }

    private fun finalizarEjecucion() {
        cambiarAEstado(Estado.APAGADO)
    }

    interface Mensajes {
        fun escribir(msg: String)
    }

    class Consola : Mensajes {
        override fun escribir(msg: String) = println(msg)
    }

    class MensajesApp(private val io: Mensajes) {
        fun leerEstado(estado: Estado) {
            when (estado) {
                Estado.PREPARANDO -> io.escribir("[SRP:Nuevo] Preparando datos...")
                Estado.REGISTRANDO -> io.escribir("[SRP:Nuevo] Registrando personas...")
                Estado.GENERANDO -> io.escribir("[SRP:Nuevo] Generando informe Markdown...")
                Estado.FINALIZANDO -> io.escribir("[SRP:Nuevo] Resultado:")
                Estado.APAGADO -> io.escribir("[SRP:Nuevo] Fin de la ejecución")
            }

        }

        fun mostrarInfo(info: String) = io.escribir(info)

    }

    enum class Estado {
        PREPARANDO, REGISTRANDO, GENERANDO, FINALIZANDO, APAGADO
    }

    class Registrador {
        private val registro: MutableMap<String, Persona>

        constructor() {
            registro = mutableMapOf()
        }

        constructor(origen: MutableMap<String, Persona>) {
            registro = origen
        }

        fun registrar(persona: Persona) = registro.put(persona.nombre, persona)
    }

    class Generador() {
        fun generar(informe: PlantillaInforme, items: List<Resumible>) = informe.generar("Listado", items)
    }
}
