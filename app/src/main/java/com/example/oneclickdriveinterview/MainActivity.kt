package com.example.oneclickdriveinterview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.oneclickdriveinterview.databinding.ActivityMainBinding
import com.example.oneclickdriveinterview.viewmodel.MainViewModel
import com.example.oneclickdriveinterview.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory = MainViewModelFactory(binding)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        setUi(viewModel.page)
        binding.apply {
            calculateBtn.setOnClickListener{
                viewModel.getData()
                setUi(viewModel.page)
            }

            backButton.setOnClickListener{
                viewModel.page = 1
                setUi(viewModel.page)
            }
        }

    }
    fun setUi(page:Int){
        if (page == 1){
            binding.inputData.visibility = View.VISIBLE
            binding.outputData.visibility = View.GONE
            binding.apply {
                textBox1.text.clear()
                textBox2.text.clear()
                textBox3.text.clear()
            }

        }else{
            binding.inputData.visibility = View.GONE
            binding.outputData.visibility = View.VISIBLE
            binding.apply {
                intersected.text = viewModel.value2
                union.text = viewModel.value1
                biggest.text = viewModel.value3.toString()
            }
        }
    }



}