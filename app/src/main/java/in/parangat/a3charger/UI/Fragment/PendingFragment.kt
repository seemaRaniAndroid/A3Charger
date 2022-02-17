package `in`.parangat.a3charger.UI.Fragment

import `in`.parangat.a3charger.Adapter.CompletedAdapter
import `in`.parangat.a3charger.Base.BaseFragment
import `in`.parangat.a3charger.Helper.TAG
import `in`.parangat.a3charger.Helper.setRecyclerView
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.UI.Activities.Detail.DetailsActivity
import `in`.parangat.a3charger.databinding.FragmentPendingBinding
import `in`.parangat.a3charger.model.VenueDataItem
import `in`.parangat.a3charger.viewmodel.PendingViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class PendingFragment : BaseFragment() {
    var pendingViewModel: PendingViewModel? = null
    lateinit var binding: FragmentPendingBinding
    private var completedAdapter: CompletedAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pending, container, false)
        pendingViewModel = ViewModelProvider(this)[PendingViewModel::class.java]
        binding.lifecycleOwner = activity
        binding.pendingmodel = pendingViewModel
        return binding.root
    }

    override fun init() {
        Log.e(TAG, "init: completed")
        pendingViewModel?.progressDialog?.observe(this) {
            if (it!!) {
                progressDialog.showProgress()
            } else {
                progressDialog.hideProgress()
            }

        }
        pendingViewModel?.dashboardData("12", "1")!!.observe(viewLifecycleOwner, Observer {
            completedAdapter = CompletedAdapter()
            completedAdapter?.setDeveloperList(it as ArrayList<VenueDataItem>)
            setRecyclerView(binding.rvPending, requireContext())
            binding.rvPending.adapter = completedAdapter

            completedAdapter?.setOnItemClickListener(object : CompletedAdapter.OnItemClickListener {
                override fun onItemClick(position: Int, arrayList: ArrayList<VenueDataItem>) {
                    val intent = Intent(requireContext(), DetailsActivity::class.java)
                    intent.putExtra("venue_id", arrayList[position].id.toString())
                    startActivity(intent)

                }
            })
            completedAdapter!!.notifyDataSetChanged()
        })
    }

    override fun initControl() {
    }

}
