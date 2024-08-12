package com.dd2d.features.users

import com.dd2d.database.table.Users
import com.dd2d.features.users.dto.request.UserInsertRequestDTO
import com.dd2d.features.users.dto.request.UserUpdateRequestDTO
import kotlinx.datetime.Clock
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class UserRepository(private val users: Users = Users) {
    fun findById(userId: Int) = users
        .findByIdQuery(id = userId)
        .toList()
    fun findAll() = users
        .findAllQuery()
        .limit(10, offset = 0)
        .toList()
    fun insert(insertDTO: UserInsertRequestDTO) = users
        .insert {
            it[subId] = insertDTO.subId
        }[Users.id]

    fun update(updateDTO: UserUpdateRequestDTO) = users
        .update(
            where = { Users.id eq updateDTO.userId },
            limit = 1,
            body = {
                updateDTO.subId?.let { updated-> it[subId] = updated }
                updateDTO.profileImageUrl?.let { updated-> it[profileImageUrl] = updated }
                updateDTO.backgroundImageUrl?.let { updated-> it[backgroundImageUrl] = updated }
            }
        )

    fun delete(userId: Int) = users.softDelete(id = userId)
}