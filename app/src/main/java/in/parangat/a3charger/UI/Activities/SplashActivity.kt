package `in`.parangat.a3charger.UI.Activities

import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.Helper.gotoActivity
import `in`.parangat.a3charger.UI.Activities.Login.LoginActivity
import `in`.parangat.a3charger.UI.Activities.Venue.VenueActivity
import `in`.parangat.a3charger.databinding.ActivitySplashBinding
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    var permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
    )

    lateinit var binding: ActivitySplashBinding
    val activityScope = CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activityScope.launch {
            init()
        }
    }

    override fun init() {
        Thread(Runnable {
            Thread.sleep(2000)
            if (prefs.loggedIn == true) {
                gotoActivity(this, VenueActivity::class.java)
                finish()
            } else {
                gotoActivity(this, LoginActivity::class.java)
                finish()
            }

        }).start()


    }

    override fun onResume() {
        super.onResume()
        checkPermissions()
    }
    override fun initControl() {
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }
    private fun checkPermissions(): Boolean {
        var result: Int
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        for (p in permissions) {
            result = ContextCompat.checkSelfPermission(this, p)
            if (p == Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS) result =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) ContextCompat.checkSelfPermission(
                    this,
                    p
                ) else PackageManager.PERMISSION_GRANTED
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p)
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toTypedArray(), 100)
            return false
        }
        return true
    }
}