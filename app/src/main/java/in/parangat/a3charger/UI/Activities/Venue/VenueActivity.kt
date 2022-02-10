package `in`.parangat.a3charger.UI.Activities.Venue

import `in`.parangat.a3charger.Adapter.TabAdapter
import `in`.parangat.a3charger.Base.BaseActivity
import `in`.parangat.a3charger.databinding.ActivityVenueBinding
import android.os.Bundle

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
    }

    override fun initControl() {

    }


}