package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel

class ZeroApplication : Application(), ViewModelProviderFactory {

    private lateinit var factory: ViewModelProviderFactory

    override fun onCreate() {
        super.onCreate()
        factory = ViewModelProviderFactory.Base(this)
    }

    override fun <T : ViewModel> viewModel(clasz: Class<out T>): T {
        return factory.viewModel(clasz)
    }
}

interface ViewModelProviderFactory {

    fun <T : ViewModel> viewModel(clasz: Class<out T>): T

    class Base(
        private val context: Context
    ) : ViewModelProviderFactory {

        private val viewModelStore = HashMap<Class<*>, ViewModel>()

        override fun <T : ViewModel> viewModel(clasz: Class<out T>): T {
            return if (viewModelStore.containsKey(clasz))
                viewModelStore[clasz] as T
            else {
                val vm = when (clasz) {
                    MainViewModel::class.java -> MainViewModel(
                        LiveDataWrapper.Base(),
                        Repository.Base()
                    )

                    else -> throw IllegalStateException("unknown")
                } as T
                viewModelStore[clasz] = vm
                vm
            }
        }
    }
}