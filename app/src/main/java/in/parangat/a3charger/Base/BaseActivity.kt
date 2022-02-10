package `in`.parangat.a3charger.Base

import `in`.parangat.a3charger.Database.SharedPreferenceUtil
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `in`.parangat.a3charger.Helper.CustomProgress
import okhttp3.RequestBody

abstract class BaseActivity : AppCompatActivity() {

    fun setRecyclerView(recyclerView: RecyclerView, context: Context)
    {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }


    val prefs by lazy {
        SharedPreferenceUtil.getInstance(this)
    }

    val progressDialog: CustomProgress by lazy { CustomProgress(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        changeStatusBarColor(ContextCompat.getColor(this, R.color.transparent))
    }

    fun changeStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= 21) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }

    fun isInternetAvailable(context: Context): Boolean {
        var status: Boolean = false
        try {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            //should check null because in airplane mode it will be null
            status = netInfo != null && netInfo.isConnected
            //  if (!status) Toast.makeText(context,context.resources.getString(R.string.error_no_internet_connection),Toast.LENGTH_SHORT).show()

            return status
        } catch (e: NullPointerException) {
            e.printStackTrace()
            return false
        }
    }
//
    abstract fun init()

    abstract fun initControl()

    fun createPartFromString(descriptionString: String): RequestBody {
        return RequestBody.create(
            okhttp3.MultipartBody.FORM, descriptionString
        )
    }

//    open fun gotoActivity(className: Class<*>?) {
//        val intent = Intent(this, className)
//        startActivity(intent)
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//    }


}