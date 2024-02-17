package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView


interface UiState {

    fun update(countTextView: TextView)
    fun update(incrementButton: Button, activity: MainActivity)

    abstract class Abstract(
        private val text: String = "0",
        private val buttonIsEnabled: Boolean = true
    ) : UiState {
        override fun update(countTextView: TextView) {
            countTextView.text = text
        }

        override fun update(incrementButton: Button, activity: MainActivity) {
            incrementButton.isEnabled = buttonIsEnabled
        }
    }

    data class Base(private val text: String) : Abstract(text = text)

    data class Max(private val text: String) : Abstract(
        text = text, buttonIsEnabled = false
    )

}
