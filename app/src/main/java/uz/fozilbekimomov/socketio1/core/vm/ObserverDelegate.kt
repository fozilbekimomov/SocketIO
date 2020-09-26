package uz.fozilbekimomov.socketio1.core.vm

interface ObserverDelegate<T> {
    fun onChanged(oldValue: T?, newValue: T?)
}