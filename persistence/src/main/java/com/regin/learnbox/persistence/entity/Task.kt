package com.regin.learnbox.persistence.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "task")
data class Task(@PrimaryKey var id: String = UUID.randomUUID().toString(), var name: String)