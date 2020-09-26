package uz.fozilbekimomov.socketio1.core.app

import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import uz.fozilbekimomov.socketio1.BuildConfig
import uz.fozilbekimomov.socketio1.core.di.component.DaggerAppComponent


class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
//        MultiDex.install(this)
    }


    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }

}