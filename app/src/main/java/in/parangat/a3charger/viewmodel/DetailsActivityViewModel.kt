package `in`.parangat.a3charger.viewmodel

import `in`.parangat.a3charger.Helper.gotoActivity
import `in`.parangat.a3charger.UI.Activities.Detail.ReviewDetailsActivity
import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel

class DetailsActivityViewModel(application: Application) : AndroidViewModel(application) {


    init {

    }

    @SuppressLint("CheckResult")
    fun moveToPreviewActivity() {
        gotoActivity(getApplication(), ReviewDetailsActivity::class.java)
    }


}


