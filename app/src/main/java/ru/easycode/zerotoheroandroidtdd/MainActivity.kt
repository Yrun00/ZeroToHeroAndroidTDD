package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var removeButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.rootLayout)
        removeButton = findViewById<Button>(R.id.removeButton)
        textView = findViewById<TextView>(R.id.titleTextView)
        removeButton.setOnClickListener {
            linearLayout.removeView(textView)
            removeButton.isEnabled = false
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removeTextView = linearLayout.childCount == 1
        outState.putBoolean(KEY, removeTextView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removeTextView = savedInstanceState.getBoolean(KEY)
        if (removeTextView) {
            linearLayout.removeView(textView)
            removeButton.isEnabled = false
        }
    }

    companion object {
        private const val KEY = "Key"
    }

}