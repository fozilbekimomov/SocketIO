package uz.fozilbekimomov.socketio1.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.fozilbekimomov.socketio1.core.network.Events
import uz.fozilbekimomov.socketio1.core.network.SocketUtil
import uz.fozilbekimomov.socketio1.core.vm.BaseViewModel
import javax.inject.Inject


/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/22/20
 * @project socketio1
 */


class LoginVM @Inject constructor(
    private val socketUtil: SocketUtil
): BaseViewModel(),LoginContract.VM{

//    init {
//        socketUtil.connect()
//    }
//
//    private val _userLoginLiveData=socketUtil.EventListener(Any::class.java,Events.EVENT_USER_JOINED)
//    override val userLoginLiveData: LiveData<Any>
//        get() = _userLoginLiveData
//
//    override fun userLogin(userName:String) {
//        socketUtil.login(userName)
//    }
}