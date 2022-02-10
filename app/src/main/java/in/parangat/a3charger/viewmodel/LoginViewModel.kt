package `in`.parangat.a3charger.viewmodel

import `in`.parangat.a3charger.Database.SharedPreferenceUtil
import `in`.parangat.a3charger.Helper.*
import `in`.parangat.a3charger.model.BasicResponse
import `in`.parangat.a3charger.UI.Activities.Venue.VenueActivity
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
    var basicResponse: MutableLiveData<BasicResponse>? = null
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
                hashMap["time"] = unixTime
                hashMap["hash"] ="3d3607b6ef6850bc98681d2ebc10e42a"
                hashMap["ocode"] = "korea"
                hashMap["openid"] ="n5dvamlpn25slmOc"
                Log.e(TAG, "getUserLogin: "+ unixTime )
                apiService.getUserLogin(hashMap, email!!.get()!!.trim(), password!!.get()!!.trim())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ onSuccess(it) }, { onFailure(it) })
            }
        }

    }

    fun onSuccess(it: BasicResponse) {
        progressDialog?.value = false
        basicResponse?.value = it
        Log.e(TAG, "onSuccess: $it" )
//        prefs.saveUserBeanResponse(it.userData!![0])
        gotoActivity(getApplication(), VenueActivity::class.java)

    }

    fun onFailure(it: Throwable) {
        progressDialog?.value = false
    }

}