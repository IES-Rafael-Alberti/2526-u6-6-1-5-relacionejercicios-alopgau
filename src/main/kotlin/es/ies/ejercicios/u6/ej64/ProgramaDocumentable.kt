package es.ies.ejercicios.u6.ej64

// Este fichero contiene ejemplos de:
// - herencia (6.1)
// - clase abstracta e interfaces (6.2)
// - constructores e init en herencia (6.3)
//
// Tu tarea (6.4) es:
// - Entender el código y su relación entre clases e interfaces.
// - Mejorar la documentación KDoc donde sea necesario.
// - Añadir comentarios solo cuando aporten valor.
// - Eliminar comentarios innecesarios o redundantes.

/**
 * Representa un elemento que puede generar un resumen en texto.
 */
interface Resumible {
    /**
     * Da el resumen del elemento
     * @return El resumen del elemento
     */
    fun resumen(): String
}

/**
 * Plantilla para generar un informe en distintos formatos.
 *
 * Relación con el resto del ejercicio:
 * - [Persona] y [Alumno] implementan [Resumible] y se pueden incluir como elementos del informe.
 *
 * Nota: el método [generar] está bloqueado (no es `open`) para forzar un flujo común
 * y permitir que las subclases solo personalicen las partes variables.
 */

/**
 * Clase abstracta `PlantillaInforme` (Template Method)
 * usada para generar informes a partir de texto resumido.
 */
abstract class PlantillaInforme : Resumible {
    /**
     * Genera informes concatenando las distintas partes del texto resumido
     * @param titulo String a modo de titulo del informe
     * @param items Lista de items a resumir
     * @return sb Informe generado
     */
    fun generar(titulo: String, items: List<Resumible>): String {
        // Crea el StringBuilder
        val sb = StringBuilder()

        sb.appendLine(cabecera(titulo))

        for (item in items) {
            sb.appendLine(formatearItem(item))
        }

        sb.appendLine(pie())
        return sb.toString() // devolver el string
    }

    /**
     * Establece el formato de la cabecera del texto
     * @param titulo String que se escribirá en la cabecera
     * @return Por defecto, devuelve el titulo tal y como se recibe
     */
    protected open fun cabecera(titulo: String): String = titulo

    /**
     * Miembro abstracto que da formato al elemento resumible recibido
     * @param item Elemento a resumir
     * @return String con el item formateado
     */
    protected abstract fun formatearItem(item: Resumible): String

    /**
     * Establece el formato del pie de página en el texto
     * @return String -- fin -- por defecto
     */
    protected open fun pie(): String = "-- fin --"

    override fun resumen(): String = "PlantillaInforme"
}

/**
 * Clase para informe en formato Markdown
 */
class InformeMarkdown : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "# $titulo"

    override fun formatearItem(item: Resumible): String = "- ${item.resumen()}"
}

/**
 * Clase para informe en formato CSV
 */

class InformeCsv : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "titulo,$titulo\nitem"

    override fun formatearItem(item: Resumible): String = item.resumen().replace(",", ";")
}

/**
 * Clase Persona
 * @constructor Crea una persona con un nombre y una edad
 * @constructor Constructor secundario que crea una persona únicamente con su nombre
 * @property nombre Nombre de la persona
 * @property edad Edad de la persona
 */

open class Persona(
    val nombre: String,
    val edad: Int,
) : Resumible {
    init {
        println("[Persona:init] nombre=$nombre edad=$edad")
    }

    constructor(nombre: String) : this(nombre, edad = 0) {
        println("[Persona:secondary] constructor(nombre)")
    }

    override fun resumen(): String = "$nombre ($edad)"
}

/**
 * Clase Alumno
 * @constructor Crea un alumno con un nombre, una edad y un curso
 * @constructor Constructor secundario que crea un alumno únicamente con su nombre y curso
 * @param nombre Nombre del alumno
 * @param edad Edad del alumno
 * @property curso Curso del alumno
 */
class Alumno : Persona {
    val curso: String

    constructor(nombre: String, edad: Int, curso: String) : super(nombre, edad) {
        // Asignar curso
        this.curso = curso
        println("[Alumno:secondary] nombre=$nombre edad=$edad curso=$curso")
    }

    constructor(nombre: String, curso: String) : this(nombre, edad = 0, curso = curso) {
        println("[Alumno:secondary] constructor(nombre, curso)")
    }

    override fun resumen(): String = "Alumno: ${super.resumen()} curso=$curso"
}

/**
 * Ejemplo para discutir "comentarios importantes":
 *
 * Se normaliza el nombre para evitar registros duplicados por diferencias de espacios o mayúsculas/minúsculas.
 */

/**
 * Clase encargada de registrar personas, a modo de base de datos
 * @param personasPorNombre Diccionario que contiene las personas
 *
 */

class RegistroPersonas {
    private val personasPorNombre = mutableMapOf<String, Persona>()
    /**
     * Recibe una persona y la registra por su nombre
     * @param persona Persona recibida
     */
    fun registrar(persona: Persona) {
        val clave = normalizarNombre(persona.nombre)
        personasPorNombre[clave] = persona
    }

    /**
     * Busca a una persona por su nombre
     * @param nombre Nombre de la persona a buscar
     * @return Devuelve el objeto que corresponde a ese nombre si lo encuentra, null en caso contrario
     */
    fun buscar(nombre: String): Persona? = personasPorNombre[normalizarNombre(nombre)]
    /**
     * Convierte el nombre recibido a minúscula y elimina espacios
     * @param nombre Nombre a normalizar
     * @return Nombre normalizado
     */
    private fun normalizarNombre(nombre: String): String {
        return nombre.trim().lowercase()
    }
}
