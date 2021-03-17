package com.deflatedpickle.mmf

import com.deflatedpickle.mmf.util.AssetPath
import com.deflatedpickle.mmf.util.ModelDisplay
import com.deflatedpickle.mmf.util.ModelElements
import com.deflatedpickle.mmf.util.ModelOverride
import java.io.File
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual

@ExperimentalSerializationApi
@Serializable
data class MMFModel(
    val parent: AssetPath = AssetPath(),
    var textures: Map<String, AssetPath> = mapOf(),
    val elements: List<ModelElements> = listOf(),
    @SerialName("ambientocclusion")
    val ambientOcclusion: Int = 0,
    val display: ModelDisplay? = null,
    @SerialName("gui_light")
    val guiLight: String = "",
    val overrides: List<ModelOverride> = listOf(),
    @SerialName("__comment")
    val comment: String = ""
) {
    companion object {
        fun load(s: String) = Json.decodeFromString<MMFModel>(s)
        fun load(f: File) = load(f.readText())
    }
}