/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.mmf.util.serializer

import com.deflatedpickle.bellatrix.Vector
import com.deflatedpickle.bellatrix.toVector
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@ExperimentalSerializationApi
@Serializer(forClass = Vector::class)
object VectorDoubleSerializer : KSerializer<Vector<Double>> {
    override val descriptor: SerialDescriptor
        get() = ListSerializer(Double.serializer()).descriptor

    override fun serialize(encoder: Encoder, value: Vector<Double>) =
        encoder.encodeSerializableValue(
            ListSerializer(Double.serializer()),
            value.toList()
        )

    override fun deserialize(decoder: Decoder): Vector<Double> {
        val decode = decoder.decodeSerializableValue(
            ListSerializer(Double.serializer())
        )
        return decode.toVector()
    }
}
