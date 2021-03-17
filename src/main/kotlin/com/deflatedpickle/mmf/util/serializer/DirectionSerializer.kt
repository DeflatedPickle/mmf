package com.deflatedpickle.mmf.util.serializer

import com.deflatedpickle.mmf.util.Direction
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@ExperimentalSerializationApi
@Serializer(forClass = Direction::class)
object DirectionSerializer : KSerializer<Direction> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(
            serialName = "Direction",
            kind = PrimitiveKind.STRING
        )

    override fun serialize(encoder: Encoder, value: Direction) =
        encoder.encodeString(value.name.toLowerCase())

    override fun deserialize(decoder: Decoder): Direction
        = Direction.valueOf(decoder.decodeString().toUpperCase())
}