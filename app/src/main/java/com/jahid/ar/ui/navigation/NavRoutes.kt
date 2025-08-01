package com.jahid.ar.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
data class ARScreen(val model: String)

@Serializable
object DrillScreen

@Serializable
data class ObjectDetailsScreen(val objectName: String)