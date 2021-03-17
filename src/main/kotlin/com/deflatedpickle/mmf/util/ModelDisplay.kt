/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.mmf.util

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
data class ModelDisplay(
    val head: DisplayElement? = null,
    val gui: DisplayElement? = null,
    val ground: DisplayElement? = null,
    val fixed: DisplayElement? = null,
    val display: DisplayElement? = null,
    @SerialName("firstperson_lefthand")
    val firstPersonLeftHand: DisplayElement? = null,
    @SerialName("firstperson_righthand")
    val firstPersonRightHand: DisplayElement? = null,
    @SerialName("thirdperson_lefthand")
    val thirdPersonLeftHand: DisplayElement? = null,
    @SerialName("thirdperson_righthand")
    val thirdPersonRightHand: DisplayElement? = null,
    @SerialName("__comment")
    val comment: String = ""
)
