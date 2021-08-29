package com.sunrise.plugins.dao

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement()

    //val callerId = varchar("callerId", 255)
    //val callStatus = varchar("callStatus", 255)
    //var registerDate = long("registerDate")
    val agent_ring_time = varchar("agent_ring_time", 255)
    val answer_stamp = varchar("answer_stamp", 255)
    val answered_agent = varchar("answered_agent", 255)
    val billing_circle = varchar("billing_circle", 255)
    val billsec = varchar("billsec", 255)
    val broadcast_lead_fields = varchar("broadcast_lead_fields", 255)
    val call_flow = varchar("call_flow", 255)
    val call_id = varchar("call_id", 255)
    val call_status = varchar("call_status", 255)
    val call_to_number = varchar("call_to_number", 255)
    val caller_id_number = varchar("caller_id_number", 255)
    val digits_dialed = varchar("digits_dialed", 255)
    val direction = varchar("direction", 255)
    val duration = varchar("duration", 255)
    val end_stamp = varchar("end_stamp", 255)
    val hangup_cause = varchar("hangup_cause", 255)
    val missed_agent = varchar("missed_agent", 255)
    val outbound_sec = varchar("outbound_sec", 255)
    val recording_url = varchar("recording_url", 255)
    val start_stamp = varchar("start_stamp", 255)
    val uuid = varchar("uuid", 255)

    override val primaryKey = PrimaryKey(caller_id_number)
}

@Serializable
data class User(
    val id: Int,
    val agent_ring_time: String,
    val answer_stamp: String,
    val answered_agent: String,
    val billing_circle: String,
    val billsec: String,
    val broadcast_lead_fields: String,
    val call_flow: String,
    val call_id: String,
    val call_status: String,
    val call_to_number: String,
    val caller_id_number: String,
    val digits_dialed: String,
    val direction: String,
    val duration: String,
    val end_stamp: String,
    val hangup_cause: String,
    val missed_agent: String,
    val outbound_sec: String,
    val recording_url: String,
    val start_stamp: String,
    val uuid: String
)