package uz.fozilbekimomov.socketio1.core.di.module.ui.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.fozilbekimomov.socketio1.core.di.annotation.ViewModelKey
import uz.fozilbekimomov.socketio1.core.vm.ViewModelProviderFactory
import uz.fozilbekimomov.socketio1.ui.home.ChatVM
import uz.fozilbekimomov.socketio1.ui.login.LoginVM


/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/20/20
 * @project socketio1
 */

@Module
interface ChatVMM {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ChatVM::class)
    fun bindLoginVM(vm: ChatVM): ViewModel

}