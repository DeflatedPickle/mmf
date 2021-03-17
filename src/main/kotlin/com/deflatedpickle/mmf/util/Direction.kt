/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.mmf.util

import com.deflatedpickle.mmf.util.serializer.DirectionSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

/**
 * @see com.deflatedpickle.mmf.util.serializer.DirectionSerializer
 */
@ExperimentalSerializationApi
@Suppress("unused")
@Serializable(with = DirectionSerializer::class)
enum class Direction {
    UP,
    DOWN,
    NORTH,
    SOUTH,
    EAST,
    WEST,
    BOTTOM
}
