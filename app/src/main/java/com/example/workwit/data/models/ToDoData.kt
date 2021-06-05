package com.example.workwit.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.workwit.data.models.Priority
import kotlinx.android.parcel.Parcelize


//this is our database model
// we need parcelize and parcelable for passing arguments between fragments.
@Entity(tableName = "todo_table")
@Parcelize
data class ToDoData (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: Priority,
    var description: String
    ):Parcelable