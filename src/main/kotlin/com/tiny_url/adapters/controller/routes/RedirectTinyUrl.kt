package com.tiny_url.adapters.controller.routes

import io.ktor.application.*
import io.ktor.routing.*

fun Application.redirectTinyUrl() {
    routing {
        get("/{tinyUrl}") {
            val tinyUrlToBeFount = call.parameters["tinyUrl"]

        }
    }
}