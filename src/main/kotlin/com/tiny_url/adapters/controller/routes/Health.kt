package com.tiny_url.adapters.controller.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.health() {
    routing {
        get("/health") {
            call.respondText("Beibe beibe do biruleibe leibe")
        }
    }
}