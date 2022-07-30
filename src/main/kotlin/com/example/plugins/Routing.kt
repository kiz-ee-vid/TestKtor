package com.example.plugins

import com.example.dao.dao
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        static("/static") {
            resources("files")
        }
        route("/articles") {
            get {
                if (dao.allArticles().isNotEmpty()) {
                    call.respond(dao.allArticles())
                } else {
                    call.respondText("No articles found", status = HttpStatusCode.OK)
                }
            }
        }
    }
}
