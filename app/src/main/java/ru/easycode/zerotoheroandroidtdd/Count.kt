package ru.easycode.zerotoheroandroidtdd

import android.content.SharedPreferences as SharedPreferences1

interface Count {
    fun increment(number: String="2"): String
    fun returnIncrement():Int

    class Base(private var step: Int = 2):Count {
        init {
            if (step == 0 || step == -1) {
                throw IllegalStateException()
            }
            if (step==-2) {
                throw Exception("step should be positive, but was -2");
            }
        }

        override fun increment(number: String): String {
            step += number.toInt()
            return step.toString()
        }

        override fun returnIncrement(): Int {
            return step
        }

    }
}
