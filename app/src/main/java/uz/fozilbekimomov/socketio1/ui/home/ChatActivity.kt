package uz.fozilbekimomov.socketio1.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import co.intentservice.chatui.ChatView
import co.intentservice.chatui.models.ChatMessage
import kotlinx.android.synthetic.main.activity_chat.*
import timber.log.Timber
import uz.fozilbekimomov.socketio1.R
import uz.fozilbekimomov.socketio1.core.base.BaseActivity
import uz.fozilbekimomov.socketio1.core.models.newMessage.NewMessageResponse
import uz.fozilbekimomov.socketio1.core.models.userJoined.UserJoinedResponse
import uz.fozilbekimomov.socketio1.core.vm.ViewModelProviderFactory
import uz.fozilbekimomov.socketio1.core.vm.viewModels
import java.util.*
import javax.inject.Inject

class ChatActivity : BaseActivity(R.layout.activity_chat), ChatContract.View {

    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory

    private val viewModel: ChatVM by viewModels { vmProviderFactory }

    override fun onCreateActivity(savedInstanceState: Bundle?) {

        initObservers()

        val name = intent.getStringExtra("userName")!!

        viewModel.userLogin(name)


        initListeners()

    }

    private fun initListeners() {

        chatView.setOnSentMessageListener {

            viewModel.sendMessage(it.message)

            true
        }

        chatView.setTypingListener(object : ChatView.TypingListener {
            override fun userStartedTyping() {
                viewModel.startTyping()
            }

            override fun userStoppedTyping() {
                viewModel.stopTyping()
            }

        })

    }

    private fun initObservers() {
        viewModel.userLoginLiveData.observe(this, loginUserObserver)
        viewModel.newMessageLiveData.observe(this, newMessageObserver)
    }

    override val loginUserObserver: Observer<UserJoinedResponse> = Observer(::onUserLogin)

    override fun onUserLogin(data: UserJoinedResponse) {
        Timber.d("onUserLogin: $data")
    }


    override val newMessageObserver: Observer<NewMessageResponse> = Observer(::onNewMessage)
    override fun onNewMessage(data: NewMessageResponse) {
        Timber.d("onNewMessage: $data")
        chatView.addMessage(ChatMessage(data.message,Calendar.getInstance().timeInMillis,ChatMessage.Type.RECEIVED,data.username))
    }

}