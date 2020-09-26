package uz.fozilbekimomov.socketio1.core.network

import android.util.Log
import androidx.lifecycle.LiveData
import com.github.nkzawa.emitter.Emitter
import com.github.nkzawa.socketio.client.Socket
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/26/20
 * @project socket.io1
 */

@Singleton
class SocketUtil @Inject constructor(
    private val gson: Gson,
    private val socketIO:Socket
){

    fun connect() {
        socketIO.connect()
    }

    fun login(userName: String) {
        val obj = JSONObject()
        obj.put(Types.TYPE_ADD_USER, userName)
        socketIO.emit(Events.EVENT_ADD_USER, userName)
    }

    fun sendMessage(message: String) {
        socketIO.emit(Events.EVENT_NEW_MESSAGE, message)
    }

    fun startTyping() {
        socketIO.emit(Events.EVENT_TYPING)
    }

    fun stopTyping() {
        socketIO.emit(Events.EVENT_STOP_TYPING)
    }

    fun disconnect() {
        socketIO.disconnect()
    }


    inner class EventListener<T> (private val data:Class<T>,private val event:String):LiveData<T>(),Emitter.Listener{
        override fun call(vararg args: Any?) {
            val argument=args[0].toString()
            Log.i("SOCKET_IO", argument)
            try {
                val obj:T=gson.fromJson(argument,data)
                postValue(obj)
            } catch (e: JsonSyntaxException) {
                Log.e("SOCKET_IO", e.message ?: e.localizedMessage ?: "Error")
            } catch (e: Exception) {
                Log.e("SOCKET_IO", e.message ?: e.localizedMessage ?: "Error")
            }
        }

        init {
            socketIO.on(event, this)

            socketIO.on("disconnect") {
                Log.d("SOCKET_IO", "disconnect")
            }
        }

        override fun onInactive() {
            socketIO.off(event,this)
            super.onInactive()
        }
    }
}