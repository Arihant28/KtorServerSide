package com.sunrise.plugins.dao

import com.sunrise.plugins.UserData
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.insert

object DatabaseFactory {

    var db: Database? = null
    fun init() {
        db = Database.connect(hikari())
        transaction {
            create(Users)
        }
    }

    fun insert(userData: UserData) = transaction(db) {
        Users.insert {
                it[agent_ring_time] = userData.agent_ring_time
                it[answer_stamp] = userData.answer_stamp
                it[answered_agent] = userData.answered_agent
                it[billing_circle] = userData.billing_circle
                it[billsec] = userData.billsec
                it[broadcast_lead_fields] = userData.broadcast_lead_fields
                it[call_flow] = userData.call_flow
                it[call_id] = userData.call_id
                it[call_status] = userData.call_status
                it[call_to_number] = userData.call_to_number
                it[caller_id_number] = userData.caller_id_number
                it[digits_dialed] = userData.digits_dialed
                it[direction] = userData.direction
                it[duration] = userData.duration
                it[end_stamp] = userData.end_stamp
                it[hangup_cause] = userData.hangup_cause
                it[missed_agent] = userData.missed_agent
                it[outbound_sec] = userData.outbound_sec
                it[recording_url] = userData.recording_url
                it[start_stamp] = userData.start_stamp
                it[uuid] = userData.uuid
        }
    }


    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.h2.Driver"
        config.jdbcUrl = "jdbc:h2:~/user;AUTO_SERVER=TRUE"
        config.maximumPoolSize = 3
        config.poolName="/db.sql"
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }
}