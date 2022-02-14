package `in`.parangat.a3charger.UI.Activities.Venue

import `in`.parangat.a3charger.Adapter.TabAdapter
import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.databinding.ActivityVenueBinding
import android.os.Bundle
import android.view.View
import android.widget.Toast

class VenueActivity : BaseActivity() {
    lateinit var binding: ActivityVenueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVenueBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        initControl()

    }

    override fun init() {
        binding.pager.adapter = TabAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.pager)
        binding.headerDash.headerTitle.text = "DashBoard"
        binding.headerDash.headerHome.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
        })
        binding.headerDash.headerPower.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Power Clicked", Toast.LENGTH_SHORT).show()
        })
    }

    override fun initControl() {

    }


}