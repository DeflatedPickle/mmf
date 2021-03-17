/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.mmf.util

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@ExperimentalSerializationApi
@Serializable
data class ModelOverride(
    val predicate: JsonObject,
    val model: AssetPath = AssetPath(),
    @SerialName("__comment")
    val comment: String = ""
)
