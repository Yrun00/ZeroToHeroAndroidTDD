package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState
    fun initial(number: String): UiState
    fun decrement(number: String): UiState

    class Base(private val step: Int, private val max: Int, private val min: Int) : Count {
        private var count: Int = 0

        init {
            when {
                step < 1 -> throw IllegalStateException("step should be positive, but was -2")
                max < 1 -> throw IllegalStateException("max should be positive, but was -2")
                max < step -> throw IllegalStateException("max should be more than step")
                max < min -> throw IllegalStateException("max should be more than min")
            }
            UiState.Min(min.toString())
            UiState.Max(max.toString())

        }

        override fun increment(number: String): UiState {
            count = number.toInt() + step
            return if (max - count >= step) UiState.Base(count.toString())
            else UiState.Max(count.toString())
        }

        override fun initial(number: String): UiState {
            count = number.toInt()
            return when (count) {
                min -> UiState.Min(number)
                max -> UiState.Max(number)
                else -> UiState.Base(number)
            }
        }

        override fun decrement(number: String): UiState {
            count = number.toInt() - step
            return if (count - min >= step) UiState.Base(count.toString())
            else UiState.Min(count.toString())
        }

    }
}