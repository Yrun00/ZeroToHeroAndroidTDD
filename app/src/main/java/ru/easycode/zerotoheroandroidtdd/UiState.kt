package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView

interface UiState {
    fun update(incrementButton:Button,decrementButton:Button,text:TextView)

    abstract class Abstract(
        private val text: String = "0",
        private val incrementEnabled: Boolean = true,
        private val decrementEnabled: Boolean = true,
    ):UiState {

        override fun update(incrementButton:Button,decrementButton:Button,text:TextView){
            incrementButton.isEnabled = incrementEnabled
            decrementButton.isEnabled = decrementEnabled
            text.text = this.text
        }
    }

    data class Min(private val text: String) : Abstract(text = text,incrementEnabled = true,decrementEnabled = false)

    data class Base(private val text: String) : Abstract(text = text)

    data class Max(private val text: String) : Abstract(text = text,incrementEnabled = false,decrementEnabled = true)
}