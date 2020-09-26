package uz.fozilbekimomov.socketio1.core.models.newMessage


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class NewMessageResponse(
    @SerializedName("username")
    val username: String?, // KING BOT
    @SerializedName("message")
    val message: String? // WELCOME [ ki ]
)