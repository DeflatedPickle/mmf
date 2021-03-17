/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.mmf.util

import com.deflatedpickle.mmf.util.serializer.TexturePointerSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable(with = TexturePointerSerializer::class)
data class TexturePointer(
    val texture: String = "",
    @SerialName("__comment")
    val comment: String = ""
) {
    companion object {
        fun from(s: String): TexturePointer = TexturePointer(s.substringAfter('#'))
    }

    override fun toString(): String = "#$texture"
}
