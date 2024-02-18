package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.actionButton)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textView = findViewById<TextView>(R.id.titleTextView)

        button.setOnClickListener { viewModel.load() }

        viewModel.livedata().observe(this) { uiState ->
            uiState.update(textView, progressBar, button)
        }
    }
}