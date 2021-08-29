package com.sunrise.plugins

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
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