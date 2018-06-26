package com.regin.learnbox.persistence.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "task")
data class Task(@PrimaryKey(autoGenerate = true) var id: Long, var name: String)