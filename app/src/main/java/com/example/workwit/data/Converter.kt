package com.example.workwit.data

import androidx.room.TypeConverter
import com.example.workwit.data.models.Priority

class Converter {

    /*
    *We need a converter when we read priorities from db and
    *When we add to db. We need two function for that.
    * These are from priority to string and string to priority.
    * */

    @TypeConverter
    fun fromPriority(priority: Priority):String{
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}