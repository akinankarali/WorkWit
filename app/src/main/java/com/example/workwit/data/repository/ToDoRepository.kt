package com.example.workwit.data.repository

import androidx.lifecycle.LiveData
import com.example.workwit.data.ToDoDao
import com.example.workwit.data.models.ToDoData


//This is repository for our data and connecting network and our Dao.
class ToDoRepository(private val toDoDao: ToDoDao) {

    //getting our data
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()
    val sortByHighPriority: LiveData<List<ToDoData>> = toDoDao.sortByHighPriority()
    val sortByLowPriority: LiveData<List<ToDoData>> = toDoDao.sortByLowPriority()

    //inserting data into our data
    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }

    //for update our data
    suspend fun updateData(toDoData: ToDoData){
        toDoDao.updateData(toDoData)
    }

    //delete item function
    suspend fun deleteItem(toDoData: ToDoData){
        toDoDao.deleteItem(toDoData)
    }

    //delete all method.
    suspend fun deleteAll(){
        toDoDao.deleteAll()
    }

    //run search query
    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>>{
        return toDoDao.searchDatabase(searchQuery)
    }

}