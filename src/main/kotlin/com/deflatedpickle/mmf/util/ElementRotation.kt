package com.deflatedpickle.mmf.util

import com.deflatedpickle.bellatrix.Vector3
import com.deflatedpickle.mmf.util.serializer.AxisSerializer
import com.deflatedpickle.mmf.util.serializer.VectorDoubleSerializer
import com.deflatedpickle.mmf.util.serializer.VectorIntSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
data class ElementRotation(
    val origin: @Serializable(with = VectorDoubleSerializer::class) Vector3<Double>,
    val axis: @Serializable(with = AxisSerializer::class) Axis = Axis.X,
    val angle: Double = 0.0,
    val rescale: Boolean = false,
    @SerialName("__comment")
    val comment: String = ""
)