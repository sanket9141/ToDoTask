package com.example.todocrud.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoEntity::class], version = 1)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun TodoDAO(): ToDoDao

    companion object {
        private var instance: ToDoDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): ToDoDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, ToDoDatabase::class.java,
                    "note_database"
                )
                    .build()

            return instance!!

        }
    }
}