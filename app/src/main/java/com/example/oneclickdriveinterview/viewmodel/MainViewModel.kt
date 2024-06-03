package com.example.oneclickdriveinterview.viewmodel

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.oneclickdriveinterview.R
import com.example.oneclickdriveinterview.databinding.ActivityMainBinding

class MainViewModel(val binding: ActivityMainBinding):ViewModel() {
    var value1 : String = ""
    var value2 : String = ""
    var value3 : Int = 0
    lateinit var arr1 : MutableList<String>
    lateinit var arr2 : MutableList<String>
    lateinit var arr3 : MutableList<String>
    lateinit var inter : MutableList<String>
    lateinit var unionOne : MutableList<String>


    var page = 1

    fun getData() {
        binding.apply {
            val text1 = textBox1.text.toString()
            val text2 = textBox2.text.toString()
            val text3 = textBox3.text.toString()

            if (!text1.isBlank() && !text2.isBlank() && !text3.isBlank()){
                arr1 = arrayListOf()
                arr2 = arrayListOf()
                arr3 = arrayListOf()
                arr1 = text1.split(",").toMutableList()
                arr2 = text2.split(",").toMutableList()
                arr3 = text3.split(",").toMutableList()
                Log.i("textOne","$arr1 $arr2 $arr3")

                page = 2
                val unionTwo = (arr1+arr2+arr3).distinct()
                value1 = unionTwo.joinToString(",")


                //intersection
                value2 = arr1.intersect(arr2).intersect(arr3).joinToString(",")
                //highest

                val intList = unionTwo.map{
                    it.toInt()
                }
                value3 = intList.max()



            }else{
                Toast.makeText(
                    binding.root.context,
                    "Must fill all the Fields",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    fun resetPage(){

        page = 1
        binding.apply {
            textBox1.setText(null)
            textBox2.setText(null)
            textBox3.setText(null)
        }
    }




}

class MainViewModelFactory(val binding: ActivityMainBinding): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(binding) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
