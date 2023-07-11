package com.flipbay.lamdacallbacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.flipbay.lamdacallbacks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.viewModel = viewModel

        viewModel.getCallbackAfterDelay { response ->
            //Capture Callback Here
            Log.d(MainActivity::class.java.name,response)
            binding?.textLive?.text = response
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}