package `in`.parangat.a3charger.Connectivity

import `in`.parangat.a3charger.model.LoginResponse
import `in`.parangat.a3charger.model.ReceeResponse
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
    @Headers(
        "time:1602487422",
        "hash:3d3607b6ef6850bc98681d2ebc10e42a",
        "ocode:korea",
        "openid:n5dvamlpn25slmOc"
    )
    fun getUserLogin(
        @Field("username") username: String,
        @Field("password") pass: String
    ): Observable<LoginResponse>

    //VenueList
    @FormUrlEncoded
    @POST("rider/venueList")
    @JvmSuppressWildcards
    @Headers(
        "time:1602487422",
        "hash:3d3607b6ef6850bc98681d2ebc10e42a",
        "ocode:korea",
        "openid:n5dvamlpn25slmOc"
    )
    fun getPendingList(
        @Field("user_id") user_id: String,
        @Field("status") status: String
    ): Observable<VenueResponse>


    @FormUrlEncoded
    @POST("rider/addRecce")
    @JvmSuppressWildcards
    @Headers(
        "time:1602487422",
        "hash:3d3607b6ef6850bc98681d2ebc10e42a",
        "ocode:korea",
        "openid:n5dvamlpn25slmOc"
    )
    fun getReceeData(
        @Field("venue_id") venue_id: String,
        ): Observable<ReceeResponse>
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