package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var uiState: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val count = Count.Base(2,4)
        textView = findViewById<TextView>(R.id.countTextView)
        button = findViewById<Button>(R.id.incrementButton)
        uiState = UiState.Base("0")
        button.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.update(textView)
            uiState.update(button,this)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putBoolean(KEY, button.isEnabled)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        button.isEnabled = savedInstanceState.getBoolean(KEY)
    }

    companion object {
        private const val KEY = "Key"
    }
}