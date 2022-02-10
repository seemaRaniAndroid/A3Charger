package `in`.parangat.a3charger.Connectivity

import `in`.parangat.a3charger.model.BasicResponse
import `in`.parangat.a3charger.model.VenueResponse
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit


interface ApiServices {

    //Login
    @FormUrlEncoded
    @POST("rider/login")
    @JvmSuppressWildcards
    fun getUserLogin(
        @HeaderMap headers: Map<String, Any>,
        @Field("username") username: String,
        @Field("password") pass: String
    ): Observable<BasicResponse>

    //VenueList
    @FormUrlEncoded
    @POST("rider/venueList")
    @JvmSuppressWildcards
    fun getPendingList(
        @HeaderMap headers: Map<String, Any>,
        @Field("user_id") user_id: String,
        @Field("status") status: String
    ): Observable<VenueResponse>


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Companion Object of Retrofit~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    companion object {

        fun create(
            baseUrl: String,
            connectTimeoutInSec: Long = 10,
            readTimeoutInSec: Long = 30,
            writeTimeoutInSec: Long = 60
        ): ApiServices {
            val client = OkHttpClient.Builder()
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(loggingInterceptor)

            client.connectTimeout(connectTimeoutInSec, TimeUnit.SECONDS)
            client.readTimeout(readTimeoutInSec, TimeUnit.SECONDS)
            client.writeTimeout(writeTimeoutInSec, TimeUnit.SECONDS)
            val gson = GsonBuilder().setLenient().create()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client.build())
                .baseUrl(baseUrl)
                .build()

            return retrofit.create(ApiServices::class.java)
        }
    }


}