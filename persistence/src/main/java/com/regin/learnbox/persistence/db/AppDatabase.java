package com.regin.learnbox.persistence.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.regin.learnbox.persistence.entity.Card;

@Database(entities = {Card.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

}