package com.sunrise

import com.sunrise.plugins.module
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 7933, host = "176.58.109.130") {
        module()
    }.start(wait = true)
}
