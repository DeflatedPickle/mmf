package com.deflatedpickle.mmf.util.serializer

import com.deflatedpickle.mmf.util.Axis
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@ExperimentalSerializationApi
@Serializer(forClass = Axis::class)
object AxisSerializer : KSerializer<Axis> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(
            serialName = "Axis",
            kind = PrimitiveKind.STRING
        )

    override fun serialize(encoder: Encoder, value: Axis) =
        encoder.encodeString(value.name.toLowerCase())

    override fun deserialize(decoder: Decoder): Axis
        = Axis.valueOf(decoder.decodeString().toUpperCase())
}