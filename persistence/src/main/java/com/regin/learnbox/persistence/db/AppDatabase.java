package com.regin.learnbox.persistence.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.regin.learnbox.persistence.dao.TaskDao;
import com.regin.learnbox.persistence.entity.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();

}