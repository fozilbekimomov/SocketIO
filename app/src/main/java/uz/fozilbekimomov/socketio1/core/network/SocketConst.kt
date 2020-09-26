package uz.fozilbekimomov.socketio1.core.network


/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/26/20
 * @project socket.io1
 */


class Events {
    companion object {
        //        42["user joined",{"username":"ki","numUsers":7}]	1601142748.1845996
        const val EVENT_USER_JOINED = "user joined"

        //        42["new message",{"username":"KING BOT","message":"WELCOME [ ki ]"}]	1601142748.1876073
        const val EVENT_NEW_MESSAGE = "new message"

        //        42["typing",{"username":"ki"}]	1601142752.7932374
        const val EVENT_TYPING = "typing"

        //        42["stop typing",{"username":"ki"}]	1601142753.4088478
        const val EVENT_STOP_TYPING = "stop typing"

        //        42["user left",{"username":"ki","numUsers":6}]	1601142771.124965
        const val EVENT_USER_LEFT = "user left"

        const val EVENT_ADD_USER = "add user"

    }
}

class Types {
    companion object {
        //        42["add user","hi"]	1601142393.7616346
        const val TYPE_ADD_USER = "add_user"

        //        42["new message","hi"]	1601142579.2723377
        const val TYPE_NEW_MESSAGE = "new message"

        //        42["typing"]	1601142578.844403
        const val TYPE_START_TYPING = "typing"

        //        42["stop typing"]	1601142579.276622
        const val TYPE_STOP_TYPING = "stop typing"
    }
}