package com.sunrise.plugins.dao

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement()
    val call_status = varchar("call_status", 255)
    val call_to_number = varchar("call_to_number", 255)
    val caller_id_number = varchar("caller_id_number", 255)
    val digits_dialed = varchar("digits_dialed", 255)
    val duration = varchar("duration", 255)
    val uuid = varchar("uuid", 255)

    override val primaryKey = PrimaryKey(call_to_number)
}

@Serializable
data class User(
    val id: Int,
    val call_status: String,
    val call_to_number: String,
    val caller_id_number: String,
    val digits_dialed: String,
    val duration: String,
    val uuid: String
)