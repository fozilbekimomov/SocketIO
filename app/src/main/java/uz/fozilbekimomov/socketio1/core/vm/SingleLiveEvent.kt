package uz.fozilbekimomov.socketio1.core.vm


import androidx.annotation.MainThread
import androidx.lifecycle.*
import java.util.concurrent.atomic.AtomicBoolean


class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, Observer { t ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(t: T?) {
        pending.set(true)
        super.setValue(t)
    }
}

fun <T, A, B> LiveData<A>.combineAndCompute(
    other: LiveData<B>,
    onChange: (A, B) -> T
): MediatorLiveData<T> {

    var source1emitted = false
    var source2emitted = false

    val result = MediatorLiveData<T>()

    val mergeF = {
        val source1Value = this.value
        val source2Value = other.value

        if (source1emitted && source2emitted) {
            result.value = onChange.invoke(source1Value!!, source2Value!!)
        }
    }

    result.addSource(this) { source1emitted = true; mergeF.invoke() }
    result.addSource(other) { source2emitted = true; mergeF.invoke() }

    return result
}


fun <T> LiveData<T>.observeDelegate(owner: LifecycleOwner, observer: ObserverDelegate<in T>) {
    var lastValue: T? = null
    observe(owner, Observer { newValue ->
        lastValue = lastValue ?: newValue
        observer.onChanged(lastValue, newValue)
        lastValue = newValue
    })
}