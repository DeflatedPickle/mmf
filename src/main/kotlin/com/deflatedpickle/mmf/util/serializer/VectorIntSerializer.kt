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
object VectorIntSerializer : KSerializer<Vector<Int>> {
    override val descriptor: SerialDescriptor
        get() = ListSerializer(Int.serializer()).descriptor

    override fun serialize(encoder: Encoder, value: Vector<Int>) =
        encoder.encodeSerializableValue(
            ListSerializer(Int.serializer()),
            value.toList()
        )

    override fun deserialize(decoder: Decoder): Vector<Int> {
        val decode = decoder.decodeSerializableValue(
            ListSerializer(Int.serializer())
        )
        return decode.toVector()
    }
}