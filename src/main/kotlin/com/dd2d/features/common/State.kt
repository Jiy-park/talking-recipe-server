package com.dd2d.features.users

import org.jetbrains.exposed.sql.Table
import org.postgresql.util.PGobject

class PGEnum<T : Enum<T>>(enumTypeName: String, enumValue: T?) : PGobject() {
    init {
        value = enumValue?.name
        type = enumTypeName
    }
}

object StateEnumTable : Table(name = "state_enum") {
    val state = customEnumeration(
        name = "state",
        sql = "state",
        fromDb = { value -> State.valueOf(value as String) },
        toDb = { dbValue -> PGEnum(enumTypeName = "state", enumValue = dbValue) }
    )
}

/** 공통으로 사용할 수 있는 상태값.
 * @property ENABLED
 * @property DISABLED*/
enum class State{
    ENABLED, DISABLED
}
