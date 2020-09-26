package uz.fozilbekimomov.socketio1.core.models.userJoined


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class UserJoinedResponse(
    @SerializedName("username")
    val username: String?, // ki
    @SerializedName("numUsers")
    val numUsers: Int? // 7
)