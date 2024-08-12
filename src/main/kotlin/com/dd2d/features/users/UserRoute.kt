package com.dd2d.features.users

import com.dd2d.features.common.DBSettings
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.usersRoute() {
    routing {
        post("/users") {

        }
        get("/users") {

        }
        get("/users/{id}") {

        }
        put("/users/{id}") {

        }
        delete("/users/{id}") {

        }
    }
}