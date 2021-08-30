package com.sunrise.plugins

import com.sunrise.plugins.dao.DatabaseFactory
import com.sunrise.plugins.dao.User
import com.sunrise.plugins.dao.Users
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.slf4j.event.Level

fun Application.module() {

    DatabaseFactory.init()

    install(StatusPages) {
        exception<Throwable> { cause ->
            call.respond(HttpStatusCode.InternalServerError)
        }
    }

    install(CallLogging) {
        level = Level.ERROR
    }


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
            json(Json {
                ignoreUnknownKeys = true
            })
        }

    }
}

private fun toUsers(row: ResultRow): User {
    return User(
        id = row[Users.id],
        call_status = row[Users.call_status],
        caller_id_number = row[Users.caller_id_number],
        call_to_number = row[Users.call_to_number],
        digits_dialed = row[Users.digits_dialed],
        duration = row[Users.duration],
        uuid = row[Users.uuid]
    )
}