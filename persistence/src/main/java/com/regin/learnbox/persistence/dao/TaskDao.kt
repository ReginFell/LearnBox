package com.regin.learnbox.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.regin.learnbox.persistence.entity.Task

@Dao
abstract class TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(tasks: List<Task>)

    @Query("SELECT * FROM task")
    abstract fun getAll(): List<Task>
}