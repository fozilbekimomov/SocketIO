package uz.fozilbekimomov.socketio1.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment

abstract class BaseFragment(@LayoutRes private val contentLayoutId: Int) : DaggerFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(contentLayoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreatedSuccess(view, savedInstanceState)
    }

    abstract fun onViewCreatedSuccess(view: View, savedInstanceState: Bundle?)
}