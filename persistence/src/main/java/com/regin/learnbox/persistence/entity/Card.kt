package com.regin.learnbox.persistence.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "card")
data class Card(@PrimaryKey(autoGenerate = true) var id: Long?)