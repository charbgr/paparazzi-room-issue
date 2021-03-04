package com.github.charbgr.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertAll(users: List<User>)

    @Query("SELECT * FROM users")
    suspend fun getUsers(): List<User>

    @Query("SELECT * FROM users WHERE users.id IN (:userIds) AND name LIKE :name LIMIT 1")
    suspend fun getUserByName(name: String, userIds: List<Int>): List<User>
}
