package `in`.parangat.a3charger.viewmodel

import `in`.parangat.a3charger.Helper.*
import `in`.parangat.a3charger.model.VenueDataItem
import `in`.parangat.a3charger.model.VenueResponse
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONArray

class PendingViewModel(application: Application) : AndroidViewModel(application) {
    var mList: MutableLiveData<ArrayList<VenueDataItem>?>? = null
    var list: ArrayList<VenueDataItem>? = ArrayList()
    var progressDialog: SingleLiveEvent<Boolean>? = null
    init {
        progressDialog = SingleLiveEvent<Boolean>()
    }


    fun dashboardData(userId: String,status: String): MutableLiveData<ArrayList<VenueDataItem>?>? {
        if (mList == null) {
            mList = MutableLiveData<ArrayList<VenueDataItem>?>()
            prepareDashboard(userId, status)
        }
        return mList
    }

    fun prepareDashboard(userId: String, status: String) {
        progressDialog?.value = true
        hashMap["time"] = unixTime
        hashMap["hash"] = "3d3607b6ef6850bc98681d2ebc10e42a"
        hashMap["ocode"] = "korea"
        hashMap["openid"] = "n5dvamlpn25slmOc"
        Log.e(TAG, "init: $hashMap" )

        apiService.getPendingList(hashMap, userId, status).subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()
        ).subscribe({ onSuccess(it) }, { onFailure(it) })
    }

    fun onSuccess(it: VenueResponse) {
        progressDialog?.value = false

        val jsonArray = JSONArray(it.data)
        for (j in 0 until jsonArray.length()) {
            list?.add(
                VenueDataItem(
                    it.data?.get(j)?.address,
                    it.data?.get(j)?.numberOfMachines,
                    it.data?.get(j)?.createTime,
                    it.data?.get(j)?.latitude,
                    it.data?.get(j)?.notDelete,
                    it.data?.get(j)?.zoneId,
                    it.data?.get(j)?.updateTime,
                    it.data?.get(j)?.categoryId,
                    it.data?.get(j)?.venueType,
                    it.data?.get(j)?.numberOfOutlets,
                    it.data?.get(j)?.name,
                    it.data?.get(j)?.tel,
                    it.data?.get(j)?.id,
                    it.data?.get(j)?.subcategory,
                    it.data?.get(j)?.meetingDate,
                    it.data?.get(j)?.remarks,
                    it.data?.get(j)?.longitude,
                    it.data?.get(j)?.status
                )
            )
            mList!!.value = list
        }
        Log.e("TAG", "Success: " + it.toString())
    }

    fun onFailure(it: Throwable) {
        progressDialog?.value = false

        Log.e("TAG", "onFailure: " + it.toString())
    }
}