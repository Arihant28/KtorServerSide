package com.sunrise.plugins

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val call_status: String?,
    val call_to_number: String?,
    val caller_id_number: String?,
    val digits_dialed: String?,
    val duration: String?,
    val uuid: String?
)