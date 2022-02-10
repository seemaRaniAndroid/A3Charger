package `in`.parangat.a3charger.UI.Activities

import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.Helper.gotoActivity
import `in`.parangat.a3charger.UI.Activities.Login.LoginActivity
import `in`.parangat.a3charger.databinding.ActivitySplashBinding
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

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
            gotoActivity(this, LoginActivity::class.java)
            finish()
        }).start()

    }

    override fun initControl() {
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }

}