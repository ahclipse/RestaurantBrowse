package com.ahclipse.ui.injection

import android.app.Application
import com.ahclipse.ui.DoorDashApplication
import com.ahclipse.ui.injection.module.ApplicationModule
import com.ahclipse.ui.injection.module.DataModule
import com.ahclipse.ui.injection.module.RemoteModule
import com.ahclipse.ui.injection.module.UIModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        UIModule::class,
        DataModule::class,
        RemoteModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: DoorDashApplication)
}