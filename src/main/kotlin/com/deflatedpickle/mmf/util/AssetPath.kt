/* Copyright (c) 2021 DeflatedPickle under the MIT license */

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
            val ns = s.replace("\"", "")
            // Sometimes an ID isn't given - it defaults to minecraft
            val id = ns.substringBefore(':', "minecraft")
            val path = ns.substringAfter("$id:").substringBeforeLast('/')
            val asset = ns.substringAfterLast('/')

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
