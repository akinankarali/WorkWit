package com.example.workwit.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.workwit.data.models.ToDoData

@Dao
interface ToDoDao {

    //this is our sql query for getting all data
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<ToDoData>>

    //insert data into our database query
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoData)

    //update data into our database
    @Update
    suspend fun updateData(toDoData: ToDoData)

    //delete data from our database
    @Delete
    suspend fun deleteItem(toDoData: ToDoData)


    //for delete all items
    @Query("DELETE FROM todo_table")
    suspend fun deleteAll()

    //for search function
    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>>


    //sorting queries
    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): LiveData<List<ToDoData>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): LiveData<List<ToDoData>>
}