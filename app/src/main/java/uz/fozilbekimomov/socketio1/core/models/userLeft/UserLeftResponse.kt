package uz.fozilbekimomov.socketio1.core.models.userLeft


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class UserLeftResponse(
    @SerializedName("username")
    val username: String?, // ki
    @SerializedName("numUsers")
    val numUsers: Int? // 6
)