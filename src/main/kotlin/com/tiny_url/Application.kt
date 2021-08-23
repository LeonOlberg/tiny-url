package com.tiny_url

import com.tiny_url.adapters.controller.routes.createTinyUrl
import com.tiny_url.adapters.controller.routes.health
import com.tiny_url.adapters.controller.routes.redirectTinyUrl
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.server.engine.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.netty.*
import org.slf4j.event.Level
import java.util.concurrent.TimeUnit

class Application {
    private val server : ApplicationEngine

    init {
        server = embeddedServer(Netty, port = 8080) {
            install(ContentNegotiation) {
                gson()
            }
            install(CallLogging) {
                level = Level.INFO
            }

            health()
            createTinyUrl()
            redirectTinyUrl()
        }.start(wait = true)
    }

    fun start() {
        server.start(wait = true)
    }

    fun stop() {
        server.stop(0, 0, TimeUnit.SECONDS)
    }
}

fun main() {
    Application().start()
}