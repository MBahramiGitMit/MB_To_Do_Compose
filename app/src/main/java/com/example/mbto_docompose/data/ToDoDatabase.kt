package com.example.mbto_docompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mbto_docompose.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao
}