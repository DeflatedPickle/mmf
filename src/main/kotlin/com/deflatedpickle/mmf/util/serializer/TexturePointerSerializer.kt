/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.mmf.util.serializer

import com.deflatedpickle.mmf.util.TexturePointer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@ExperimentalSerializationApi
@Serializer(forClass = TexturePointer::class)
object TexturePointerSerializer : KSerializer<TexturePointer> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(
            serialName = "TexturePointer",
            kind = PrimitiveKind.STRING
        )

    override fun serialize(encoder: Encoder, value: TexturePointer) =
        encoder.encodeString(value.toString())

    override fun deserialize(decoder: Decoder): TexturePointer =
        TexturePointer.from(decoder.decodeString())
}
