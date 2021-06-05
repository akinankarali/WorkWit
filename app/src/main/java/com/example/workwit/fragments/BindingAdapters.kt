package com.example.workwit.fragments

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.workwit.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


//Data Binding part and with this we can have more efficient code
class BindingAdapters {

    companion object{


        //this navigates for add or update fragments.
        // Add working only tapping with floating action button
        //update navigation moved into list adapter.
        //with this binding i can delete navigate function in below from list fragment
        //view.floatingActionButton.setOnClickListener{
        //   findNavController().navigate(R.id.action_listFragment_to_addFragment)
        //}
        @BindingAdapter("android:navigateToAddFragment")
        @JvmStatic
        fun navigateToAddFragment(view: FloatingActionButton, navigate: Boolean){
            view.setOnClickListener {
                if (navigate){
                    view.findNavController().navigate(R.id.action_listFragment_to_addFragment)
                }
            }
        }


        /*
        I delete this  observe and function
        mSharedViewModel.emptyDatabase.observe(viewLifecycleOwner, Observer{
                    showEmptyDatabaseViews(it)
                })

            private fun showEmptyDatabaseViews(emptyDatabase: Boolean) {
            if(emptyDatabase){
                view?.no_data_imageView?.visibility = View.VISIBLE
                view?.no_data_textView?.visibility = View.VISIBLE
            }else{
                view?.no_data_imageView?.visibility = View.INVISIBLE
                view?.no_data_textView?.visibility = View.INVISIBLE
            }
        }
        from list fragment with this binding
        */
        @BindingAdapter("android:emptyDatabase")
        @JvmStatic
        fun emptyDatabase(view: View, emptyDatabase: MutableLiveData<Boolean>){
            when(emptyDatabase.value){
                true -> view.visibility = View.VISIBLE
                false -> view.visibility = View.INVISIBLE
            }
        }
    }
}