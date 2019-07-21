package com.ahclipse.ui.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahclipse.data.executor.PostExecutionThread
import com.ahclipse.ui.UIThread
import com.ahclipse.ui.allRestaurants.AllRestaurantsActivity
import com.ahclipse.ui.injection.ViewModelFactory
import com.ahclipse.ui.presentation.GetRestaurantsViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class UIModule {

    @Binds
    abstract fun bindPostExecutionThread(uIThread: UIThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesAllRestaurantsActivity(): AllRestaurantsActivity

    @Binds
    @IntoMap
    @ViewModelKey(GetRestaurantsViewModel::class)
    abstract fun bindGetRestaurantsViewModel(viewModel: GetRestaurantsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)