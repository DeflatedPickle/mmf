package com.deflatedpickle.mmf.util.serializer

import com.deflatedpickle.mmf.util.AssetPath
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@ExperimentalSerializationApi
@Serializer(forClass = AssetPath::class)
object AssetPathSerializer : KSerializer<AssetPath> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(
            serialName = "AssetPath",
            kind = PrimitiveKind.STRING
        )

    override fun serialize(encoder: Encoder, value: AssetPath) =
        encoder.encodeString(value.toString())

    override fun deserialize(decoder: Decoder): AssetPath =
        AssetPath.from(decoder.decodeString())
}