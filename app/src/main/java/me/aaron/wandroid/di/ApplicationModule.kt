package me.aaron.wandroid.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Qualifier

@Module
class ApplicationModule(val appContext: Context) {

    @Provides
    fun providerRetrofit(
        okHttpClient: OkHttpClient,
        gsonConvertFactory: GsonConverterFactory,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl("")
            .addConverterFactory(gsonConvertFactory).build()

    }

    @Provides
    fun providerGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun providerGsonConvertFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun providerOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient().newBuilder().cache(cache).build()
    }

    @Provides
    fun providerOkHttpCache(): Cache {
        val file = File(appContext.cacheDir, "HttpCache").apply {
            mkdirs()
        }
        return Cache(file, 10_000_000)
    }

    @Provides
    fun providerAppContext():Context{
        return appContext
    }

}