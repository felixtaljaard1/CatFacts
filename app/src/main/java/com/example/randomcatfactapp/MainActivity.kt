package com.example.randomcatfactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: CatViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val fact = findViewById<TextView>(R.id.textView)

        button.setOnClickListener(){
            viewModel.fetchFacts()

            viewModel.catLiveData.observe(this){
                fact.text = it?.data?.get(0).toString()
                fact.setMovementMethod(ScrollingMovementMethod())
            }
        }
    }
}