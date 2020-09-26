package uz.fozilbekimomov.socketio1.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import uz.fozilbekimomov.socketio1.core.app.App
import uz.fozilbekimomov.socketio1.core.di.module.network.ApiClientModule
import uz.fozilbekimomov.socketio1.core.di.module.ui.ActivityBuildersModule
import javax.inject.Singleton


/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/20/20
 * @project socketio1
 */


@Singleton
@Component(
    modules = [
        ApiClientModule::class,
        ActivityBuildersModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}