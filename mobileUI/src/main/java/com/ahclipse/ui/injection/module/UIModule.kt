package com.ahclipse.ui.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahclipse.data.executor.PostExecutionThread
import com.ahclipse.ui.UIThread
import com.ahclipse.ui.allRestaurants.AllRestaurantsActivity
import com.ahclipse.ui.injection.ViewModelFactory
import com.ahclipse.ui.login.LoginActivity
import com.ahclipse.ui.presentation.GetRestaurantsViewModel
import com.ahclipse.ui.presentation.LoginViewModel
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

    @ContributesAndroidInjector
    abstract fun contributesLoginActivity(): LoginActivity

    @Binds
    @IntoMap
    @ViewModelKey(GetRestaurantsViewModel::class)
    abstract fun bindGetRestaurantsViewModel(viewModel: GetRestaurantsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)