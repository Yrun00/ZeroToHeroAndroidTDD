package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState

    class Base(private var step: Int, private var max: Int) : Count {
        init {
            when {
                (step < 1) -> throw IllegalStateException("step should be positive, but was -2")
                max < 1 -> throw IllegalStateException("max should be positive, but was -2")
                max < step -> throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {

            val digit = step + number.toInt()
            val count = digit
            return if (max - max % step > count) {
                UiState.Base(count.toString())
            } else
                UiState.Max(count.toString())
        }

    }

}