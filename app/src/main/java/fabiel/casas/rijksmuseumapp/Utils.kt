package fabiel.casas.rijksmuseumapp

import java.util.Locale

/**
 * RijksMuseumApp
 * Created on 23/06/2023.
 * Author: johan
 */

fun getCulture(): String {
    val locale = Locale.getDefault()
    return when(locale.country) {
        "NL" -> locale.country.lowercase()
        else -> "en"
    }
}