// To parse the JSON, install Klaxon and do:
//
//   val button = Button.fromJson(jsonString)

package quicktype

import com.beust.klaxon.*

private val klaxon = Klaxon()

data class Button (
    val name: String,
    val onPress: Double,

    @Json(name = "styleId")
    val styleID: String? = null
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Button>(json)
    }
}
