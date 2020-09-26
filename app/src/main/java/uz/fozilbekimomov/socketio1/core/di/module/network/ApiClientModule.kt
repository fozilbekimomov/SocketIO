package uz.fozilbekimomov.socketio1.core.di.module.network

import android.app.Application
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import uz.fozilbekimomov.socketio1.R
import uz.fozilbekimomov.socketio1.core.network.BaseUrl
import javax.inject.Singleton

/**
 * Created by <a href="mailto: fozilbekimomov@gmail.com" >Fozilbek Imomov</a>
 *
 * @author fozilbekimomov
 * @version 1.0
 * @date 9/20/20
 * @project socketio1
 */


@Module
open class ApiClientModule {

    @Provides
    @Singleton
    open fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.i("wallpapersNetwork ##  %s", message)
            }
        })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


    @Provides
    @Singleton
    open fun getOkHttpClient(
        logging: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(logging)
            .build()
    }


//    @Provides
//    @Singleton
//    open fun getApiClient(gson: Gson, okHttpClient: OkHttpClient, baseUrl: BaseUrl): Retrofit {
//        return Retrofit
//            .Builder()
//            .baseUrl(baseUrl.baseUrl)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    }


//    @Provides
//    @Singleton
//    open fun getMainServices(retrofit: Retrofit): MainService =
//        retrofit.create(MainService::class.java)


    @Provides
    @Singleton
    open fun getJson(): Gson = GsonBuilder().setLenient().create()


        @Provides
    @Singleton
    open fun getSocketIO(baseUrl: BaseUrl): Socket {
//        val opts = IO.Options()
//        opts.path = "/api"
        return IO.socket(baseUrl.socketUrl)
    }


    @Provides
    @Singleton
    open fun getBaseUrl(app: Application): BaseUrl {
        val baseUrl: String = app.getString(R.string.base_url)
//        val socketUrl: String = app.getString(R.string.socket_url)
        return BaseUrl(baseUrl)
    }
}