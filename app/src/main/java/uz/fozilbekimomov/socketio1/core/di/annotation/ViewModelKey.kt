package uz.fozilbekimomov.socketio1.core.di.annotation

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass


/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/20/20
 * @project socketio1
 */


@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CONSTRUCTOR
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
