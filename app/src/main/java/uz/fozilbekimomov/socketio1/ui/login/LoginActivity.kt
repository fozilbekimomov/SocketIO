package uz.fozilbekimomov.socketio1.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import uz.fozilbekimomov.socketio1.R
import uz.fozilbekimomov.socketio1.core.base.BaseActivity
import uz.fozilbekimomov.socketio1.ui.home.ChatActivity

class LoginActivity : BaseActivity(R.layout.activity_login), LoginContract.View {


//    @Inject
//    lateinit var vmProviderFactory: ViewModelProviderFactory
//
//    private val viewModel: LoginVM by viewModels { vmProviderFactory }

    override fun onCreateActivity(savedInstanceState: Bundle?) {

//        initObservers()

    }

    //    private fun initObservers() {
//        viewModel.userLoginLiveData.observe(this, loginUserObserver)
//    }
//
//    override val loginUserObserver: Observer<Any> = Observer(::onUserLogin)
//
//    override fun onUserLogin(any: Any) {
//        Timber.d("onUserLogin: $any")
//    }
//
    fun loginUser(view: View) {
        if (userName.text.isNotEmpty()) {
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("userName", userName.text.toString())
            startActivity(intent)
        }

    }


}