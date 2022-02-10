package `in`.parangat.a3charger.UI.Fragment

import `in`.parangat.a3charger.Adapter.PendingAdapter
import `in`.parangat.a3charger.Base.BaseFragment
import `in`.parangat.a3charger.Helper.TAG
import `in`.parangat.a3charger.Helper.setRecyclerView
import `in`.parangat.a3charger.model.VenueDataItem
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.databinding.FragmentPendingBinding
import `in`.parangat.a3charger.viewmodel.PendingViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import java.util.ArrayList

class PendingFragment : BaseFragment() {
    var pendingViewModel: PendingViewModel? = null
    lateinit var binding: FragmentPendingBinding
    private var pendingAdapter: PendingAdapter? = null


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
        initControl()
        return binding.root
    }

    override fun init() {
        Log.e(TAG, "init: pending")
//        pendingViewModel?.progressDialog?.observe(this) {
//            if (it!!) {
//                progressDialog.showProgress()
//            }
//            else{
//                progressDialog.hideProgress()
//            }
////            getData()
//
//        }
    }

    override fun initControl() {
        binding.swipeRefresh.setColorSchemeResources(R.color.label_color, R.color.white);
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = true
            //getData()
        }

    }

    fun getData() {
        pendingViewModel?.dashboardData("12", "1")!!.observe(viewLifecycleOwner, Observer {
            binding.swipeRefresh.isRefreshing = false
            pendingAdapter = PendingAdapter()
            pendingAdapter?.setDeveloperList(it as ArrayList<VenueDataItem>)
            setRecyclerView(binding.rvPending, requireContext())
            binding.rvPending.adapter = pendingAdapter
            pendingAdapter?.setOnItemClickListener(object : PendingAdapter.OnItemClickListener {
                override fun onItemClick(position: Int, arrayList: ArrayList<VenueDataItem>) {
//                    startActivity(Intent(requireContext(),SubjectActivity::class.java).apply {
//                        putExtra("courseId",arrayList[position].courseId)
//                        putExtra("courseName",arrayList[position].courseName)
//                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    })
                }
            })
            pendingAdapter!!.notifyDataSetChanged()
        })
    }
}