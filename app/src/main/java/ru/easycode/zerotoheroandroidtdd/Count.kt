package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState
    fun initial(number: String): UiState
    fun decrement(number: String): UiState

    class Base(step: Int, max: Int, min: Int) : Count {
        private var count:Int = 0
        init{

        }
        override fun increment(number: String): UiState {
            TODO("Not yet implemented")
        }

        override fun initial(number: String): UiState {
            TODO("Not yet implemented")
        }

        override fun decrement(number: String): UiState {
            TODO("Not yet implemented")
        }

    }
}