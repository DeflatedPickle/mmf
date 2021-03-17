package com.deflatedpickle.mmf.util

import com.deflatedpickle.bellatrix.Vector3
import com.deflatedpickle.mmf.util.serializer.VectorDoubleSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
data class DisplayElement(
    val rotation: @Serializable(with = VectorDoubleSerializer::class) Vector3<Double> = Vector3(0.0, 0.0, 0.0),
    val translation: @Serializable(with = VectorDoubleSerializer::class) Vector3<Double> = Vector3(0.0, 0.0, 0.0),
    val scale: @Serializable(with = VectorDoubleSerializer::class) Vector3<Double> = Vector3(0.0, 0.0, 0.0),
    @SerialName("__comment")
    val comment: String = ""
)