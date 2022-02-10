package `in`.parangat.a3charger.UI.Activities.Detail

import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.databinding.ActivityDetailBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil

class DetailActivity : BaseActivity(), View.OnClickListener {
    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
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

        }
    }
}