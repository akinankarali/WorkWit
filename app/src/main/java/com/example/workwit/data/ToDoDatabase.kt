package com.example.workwit.data

import android.content.Context
import androidx.room.*
import com.example.workwit.data.models.ToDoData


//creating database
@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object{


        //If there is a instance use it, if there is not use temp instance for our database
        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            //we use synchronized because of multiple threading
            //when creating instance and avoid crash.
            //Make sure only one thread access code inside synchronized block.
            //and only one thread can create instance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}