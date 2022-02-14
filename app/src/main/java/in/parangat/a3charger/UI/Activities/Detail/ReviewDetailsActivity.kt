package `in`.parangat.a3charger.UI.Activities.Detail

import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.Helper.gotoActivity
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.UI.Activities.SubmittedSuccessfully
import `in`.parangat.a3charger.databinding.ActivityDetailBinding
import `in`.parangat.a3charger.databinding.ActivityReviewDetailsBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil

class ReviewDetailsActivity : BaseActivity(), View.OnClickListener {
    lateinit var binding: ActivityReviewDetailsBinding
    var venue_id: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_review_details)
        binding.listener = this
        init()
        initControl()
    }

    override fun init() {
    }

    override fun initControl() {

    }

    override fun onClick(v: View) {
        when (v) {
            binding.headerBack -> {
                onBackPressed()
            }
            binding.btnNext -> {
                gotoActivity(this, SubmittedSuccessfully::class.java)
            }
            binding.headerEdit -> {
                onBackPressed()
            }
        }
    }
}