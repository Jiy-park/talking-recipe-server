package com.dd2d.features.users

import kotlinx.datetime.*
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Users: Table(name = "users") {
    private val id = integer(name = "id").uniqueIndex().autoIncrement()
    val subId = varchar(name = "sub_id", length = 20)
    val profileImageUrl = text(name = "profile_image_url").nullable().default(null)
    val backgroundImageUrl = text(name = "background_image_url").nullable().default(null)
    val likeCount = integer(name = "like_count").default(0)
    val state = enumeration<State>(name = "state").default(State.ENABLED)
    val lastSignInAt = datetime("last_sign_in_at").default(Clock.System.now().toLocalDateTime(TimeZone.UTC))
    val createdAt = datetime("create_at").default(Clock.System.now().toLocalDateTime(TimeZone.UTC))
    val updatedAt = datetime("updated_at").default(Clock.System.now().toLocalDateTime(TimeZone.UTC))
    val deletedAt = datetime("deleted_at").nullable().default(null)
    override val primaryKey = PrimaryKey(id)
}
