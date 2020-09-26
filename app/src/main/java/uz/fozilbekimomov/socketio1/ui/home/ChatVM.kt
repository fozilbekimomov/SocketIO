package uz.fozilbekimomov.socketio1.ui.home

import androidx.lifecycle.LiveData
import uz.fozilbekimomov.socketio1.core.models.newMessage.NewMessageResponse
import uz.fozilbekimomov.socketio1.core.models.userJoined.UserJoinedResponse
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


class ChatVM @Inject constructor(
    private val socketUtil: SocketUtil
) : BaseViewModel(), ChatContract.VM {

    init {
        socketUtil.connect()
    }

    private val _userLoginLiveData =
        socketUtil.EventListener(UserJoinedResponse::class.java, Events.EVENT_USER_JOINED)
    override val userLoginLiveData: LiveData<UserJoinedResponse>
        get() = _userLoginLiveData

    override fun userLogin(userName: String) {
        socketUtil.login(userName)
    }


    private val _newMessageLiveData =
        socketUtil.EventListener(NewMessageResponse::class.java, Events.EVENT_NEW_MESSAGE)
    override val newMessageLiveData: LiveData<NewMessageResponse>
        get() = _newMessageLiveData

    override fun sendMessage(message: String) {
        socketUtil.sendMessage(message)
    }


    override fun startTyping() {
        socketUtil.startTyping()
    }

    override fun stopTyping() {
        socketUtil.stopTyping()
    }
}