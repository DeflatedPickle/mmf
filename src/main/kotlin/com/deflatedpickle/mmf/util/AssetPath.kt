package com.deflatedpickle.mmf.util

import com.deflatedpickle.mmf.util.serializer.AssetPathSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A Minecraft asset path
 */
@ExperimentalSerializationApi
@Serializable(with = AssetPathSerializer::class)
@Suppress("MemberVisibilityCanBePrivate")
data class AssetPath(
    val id: String = "",
    val path: String = "",
    val asset: String = "",
    @SerialName("__comment")
    val comment: String = ""
) {
    companion object {
        /**
         * Parse a [String] into an [AssetPath]
         */
        fun from(s: String): AssetPath {
            // Sometimes an ID isn't given - it defaults to minecraft
            val id = s.substringBefore(':', "minecraft")
            val path = s.substringAfter("$id:").substringBeforeLast('/')
            val asset = s.substringAfterLast('/')

            return AssetPath(id, path, asset)
        }
    }

    /**
     * Turn this [AssetPath] into a [String]
     */
    override fun toString(): String = if ("$id$path$asset".isEmpty()) "" else "$id:$path/$asset"
}

@ExperimentalSerializationApi
fun String.toAssetPath(): AssetPath = AssetPath.from(this)
@ExperimentalSerializationApi
fun String.from(s: AssetPath): String = s.toString()