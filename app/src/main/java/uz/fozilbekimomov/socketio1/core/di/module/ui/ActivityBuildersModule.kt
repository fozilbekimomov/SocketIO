package uz.fozilbekimomov.socketio1.core.di.module.ui


import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.fozilbekimomov.socketio1.core.di.module.ui.login.ChatVMM
import uz.fozilbekimomov.socketio1.core.di.scope.MapScope
import uz.fozilbekimomov.socketio1.ui.home.ChatActivity
import uz.fozilbekimomov.socketio1.ui.login.LoginActivity


/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/20/20
 * @project iTV
 */

@Module
interface ActivityBuildersModule {

    @MapScope
    @ContributesAndroidInjector
    fun contributeLoginActivity(): LoginActivity

    @MapScope
    @ContributesAndroidInjector(
        modules = [ChatVMM::class]
    )
    fun contributeChatActivity(): ChatActivity

}