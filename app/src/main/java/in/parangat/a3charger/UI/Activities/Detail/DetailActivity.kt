package `in`.parangat.a3charger.UI.Activities.Detail

import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.Helper.gotoActivity
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.databinding.ActivityDetailBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil

class DetailActivity : BaseActivity(), View.OnClickListener {
    lateinit var binding: ActivityDetailBinding
    var venue_id: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.listener = this
        init()
        initControl()
    }

    override fun init() {
        var bundle: Bundle? = intent.extras
        venue_id = bundle!!.getString("venue_id")
        Toast.makeText(this, venue_id, Toast.LENGTH_SHORT).show()
    }

    override fun initControl() {

    }

    override fun onClick(v: View) {
        when (v) {
            binding.headerBack -> {
                onBackPressed()
            }
            binding.btnNext -> {
                gotoActivity(this, ReviewDetailsActivity::class.java)
            }
        }
    }
}