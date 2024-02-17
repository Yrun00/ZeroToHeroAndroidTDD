package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private lateinit var textView: TextView
    private lateinit var uiState: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val count = Count.Base(2, 4, 0)
        textView = findViewById<TextView>(R.id.countTextView)
        incrementButton = findViewById<Button>(R.id.incrementButton)
        decrementButton = findViewById<Button>(R.id.decrementButton)
        uiState = UiState.Base("0")
        incrementButton.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.update(textView)
            uiState.update(incrementButton,decrementButton)
        }
        decrementButton.setOnClickListener {
            uiState = count.decrement(textView.text.toString())
            uiState.update(textView)
            uiState.update(incrementButton,decrementButton)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(DEC, decrementButton.isEnabled)
        outState.putBoolean(INC, incrementButton.isEnabled)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        decrementButton.isEnabled = savedInstanceState.getBoolean(DEC)
        incrementButton.isEnabled = savedInstanceState.getBoolean(INC)
    }

    companion object {
        private const val INC = "inc"
        private const val DEC = "dec"
    }

}
