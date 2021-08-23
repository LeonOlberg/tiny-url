package com.tiny_url.adapters.controller.routes

import ceom.tiny_url.useCases.CreateTinyUrl
import com.tiny_url.adapters.controller.model.TinyUrlModel
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.createTinyUrl() {
    routing {
        post("/create") {
            val tinyUrlModel = call.receive<TinyUrlModel>()
            val tinyUrl = CreateTinyUrl().execute(tinyUrlModel)

            call.respond(HttpStatusCode.Created, tinyUrl)
        }
    }
}