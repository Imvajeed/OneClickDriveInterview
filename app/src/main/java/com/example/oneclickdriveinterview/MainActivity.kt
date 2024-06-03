package com.example.oneclickdriveinterview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.oneclickdriveinterview.databinding.ActivityMainBinding
import com.example.oneclickdriveinterview.viewmodel.MainViewModel
import com.example.oneclickdriveinterview.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModelFactory: MainViewModelFactory
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply {
            calculateBtn.setOnClickListener{
                getData()
            }
        }

    }

    private fun getData() {
        binding.apply {
            val text1 = textBox1.text.toString()
            val text2 = textBox2.text.toString()
            val text3 = textBox3.text.toString()

            if (!text1.isBlank() && !text2.isBlank() && !text3.isBlank()){
                var arr1 = text1.split(",")
                var arr2 = text2.split(",")
                var arr3 = text3.split(",")
                Log.i("textOne","$arr1 $arr2 $arr3")

                viewModelFactory = MainViewModelFactory(arr1,arr2,arr3)


            }else{
                Toast.makeText(
                    this@MainActivity,
                    "Must fill all the Fields",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}