/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.mmf.util

import com.deflatedpickle.bellatrix.Vector4
import com.deflatedpickle.mmf.util.serializer.VectorDoubleSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
@Suppress("unused", "SpellCheckingInspection")
data class ElementFace(
    val uv: @Serializable(with = VectorDoubleSerializer::class) Vector4<Double> = Vector4(0.0, 0.0, 0.0, 0.0),
    val texture: TexturePointer,
    val rotation: Int = 0,
    @SerialName("tintindex")
    val tintIndex: Int = 0,
    val cullface: Direction? = null,
    @SerialName("__comment")
    val comment: String = ""
)
