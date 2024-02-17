package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var count: Count

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        count = Count.Base()
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.countTextView)
        button = findViewById<Button>(R.id.incrementButton)
        button.setOnClickListener {
            count.increment()
            textView.text = (count.returnIncrement()-2).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY,count.returnIncrement())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = Count.Base(savedInstanceState.getInt(KEY))
        textView.text = (count.returnIncrement()-2).toString()
    }
    companion object {
        private const val KEY = "Key"
    }

}