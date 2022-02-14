package `in`.parangat.a3charger.viewmodel

import `in`.parangat.a3charger.Database.SharedPreferenceUtil
import `in`.parangat.a3charger.Helper.*
import `in`.parangat.a3charger.UI.Activities.Venue.VenueActivity
import `in`.parangat.a3charger.model.LoginResponse
import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var btnSelected: ObservableBoolean? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var progressDialog: SingleLiveEvent<Boolean>? = null
    var loginResponse: MutableLiveData<LoginResponse>? = null
    val prefs by lazy {
        SharedPreferenceUtil.getInstance(application)
    }

    init {
        btnSelected = ObservableBoolean(false)
        progressDialog = SingleLiveEvent<Boolean>()
        email = ObservableField("")
        password = ObservableField("")
    }

    @SuppressLint("CheckResult")
    fun getUserLogin() {
        when {
            email!!.get()!!.toString().trim().isEmpty() -> {
                Toast.makeText(getApplication(), "Enter Email Id", Toast.LENGTH_SHORT).show()
            }
            password!!.get()!!.toString().trim().isEmpty() -> {
                Toast.makeText(getApplication(), "Enter Password", Toast.LENGTH_SHORT).show()
            }
            else -> {
                progressDialog?.value = true
                apiService.getUserLogin(email!!.get()!!.trim(), password!!.get()!!.trim())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ onSuccess(it) }, { onFailure(it) })

            }

        }


    }


    fun onSuccess(it: LoginResponse) {
        progressDialog?.value = false
        loginResponse?.value = it
        Log.e(TAG, "onSuccess: $it")
        Toast.makeText(getApplication(),it.msg,Toast.LENGTH_SHORT).show()
        prefs.loggedIn=true
        gotoActivity(getApplication(), VenueActivity::class.java)

    }

    fun onFailure(it: Throwable) {
        progressDialog?.value = false
        Log.e(TAG, "onFailure: $it")

    }

}