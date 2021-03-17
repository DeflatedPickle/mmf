package com.deflatedpickle.mmf.util;

import com.deflatedpickle.bellatrix.Vector3
import com.deflatedpickle.mmf.util.serializer.VectorDoubleSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
data class ModelElements(
    val from: @Serializable(with = VectorDoubleSerializer::class) Vector3<Double> = Vector3(0.0, 0.0, 0.0),
    val to: @Serializable(with = VectorDoubleSerializer::class) Vector3<Double> = Vector3(0.0, 0.0, 0.0),
    val rotation: ElementRotation? = null,
    val shade: Boolean = true,
    val faces: Map<Direction, ElementFace> = mapOf(),
    @SerialName("__comment")
    val comment: String = ""
)
