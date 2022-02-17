/*
package `in`.parangat.a3charger.UI.Activities

import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.Helper.gotoActivity
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.UI.Activities.Login.LoginActivity
import `in`.parangat.a3charger.databinding.ActivitySubmittedSuccessfullyBinding
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil

class SubmittedSuccessfully : BaseActivity(), View.OnClickListener {
    lateinit var binding: ActivitySubmittedSuccessfullyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submitted_successfully)
        init()
        initControl()
    }

    override fun init() {
    }

    override fun initControl() {

    }

    override fun onClick(v: View) {
        when (v) {
            binding.headerDash.headerBack -> {
                onBackPressed()
            }
            binding.headerDash.headerPower -> {
                prefs.deletePreferences()
                gotoActivity(this,LoginActivity::class.java)
            }
        }
    }
}*/
