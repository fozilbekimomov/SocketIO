package uz.fozilbekimomov.socketio1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import uz.fozilbekimomov.socketio1.core.models.newMessage.NewMessageResponse
import uz.fozilbekimomov.socketio1.core.models.userJoined.UserJoinedResponse


/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/26/20
 * @project socket.io1
 */


interface ChatContract {
    interface View{
        val loginUserObserver: Observer<UserJoinedResponse>
        fun onUserLogin(data:UserJoinedResponse)

        val newMessageObserver: Observer<NewMessageResponse>
        fun onNewMessage(data:NewMessageResponse)


    }

    interface VM{

        val userLoginLiveData: LiveData<UserJoinedResponse>
        fun userLogin(userName:String)


        val newMessageLiveData: LiveData<NewMessageResponse>
        fun sendMessage(message:String)

        fun startTyping()

        fun stopTyping()



    }
}