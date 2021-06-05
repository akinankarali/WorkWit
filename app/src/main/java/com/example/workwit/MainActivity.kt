package com.example.workwit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/*
* <h1> WorkWit </h1>
* <p>
* With this application you can create a work,
* add title desc and priority to this work,
* update this work and delete this work like CRUD.
* Also sorting high and low in the menu and delete all option in the menu.
* You can search anything in the created works.
* In this app has a database.
* </p
*
*
* @Authors:
* Gökçe Kahraman
* 20161701035
*
* Saim Akın Ankaralı
* 20141701005
*
*
* @version 1.0
* @since 2021-05-26
* */


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //actually our app crashing when i run this code.
        //We planned this function for back arrow when add or update fragment transition.
        //But this is not work.
        //setupActionBarWithNavController(findNavController(R.id.navHostFragment))

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)

        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    }





