package com.sunrise.plugins

import com.sunrise.plugins.dao.DatabaseFactory
import com.sunrise.plugins.dao.User
import com.sunrise.plugins.dao.Users
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

fun Application.module() {

    DatabaseFactory.init()

    routing {
        post("/contact") {
            val userData = call.receive<UserData>()
            call.respondText("OK")
            DatabaseFactory.insert(userData)
        }

        get("/contact") {
            val userData: List<User> = newSuspendedTransaction {
                Users.selectAll().map { toUsers(it) }
            }
            call.respond(userData)
        }

        install(ContentNegotiation) {
            json()
        }

    }
}

private fun toUsers(row: ResultRow): User {
    return User(
        id = row[Users.id],
        call_status = row[Users.call_status],
        caller_id_number = row[Users.caller_id_number],
        agent_ring_time = row[Users.agent_ring_time],
        answer_stamp = row[Users.answer_stamp],
        answered_agent = row[Users.answered_agent],
        billing_circle = row[Users.billing_circle],
        billsec = row[Users.billsec],
        broadcast_lead_fields = row[Users.broadcast_lead_fields],
        call_flow = row[Users.call_flow],
        call_id = row[Users.call_id],
        call_to_number = row[Users.call_to_number],
        digits_dialed = row[Users.digits_dialed],
        direction = row[Users.direction],
        duration = row[Users.duration],
        end_stamp = row[Users.end_stamp],
        hangup_cause = row[Users.hangup_cause],
        missed_agent = row[Users.missed_agent],
        outbound_sec = row[Users.outbound_sec],
        recording_url = row[Users.recording_url],
        start_stamp = row[Users.start_stamp],
        uuid = row[Users.uuid]
    )
}