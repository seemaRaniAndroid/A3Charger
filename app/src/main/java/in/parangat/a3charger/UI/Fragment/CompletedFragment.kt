package `in`.parangat.a3charger.UI.Fragment

import `in`.parangat.a3charger.Base.BaseFragment
import `in`.parangat.a3charger.Helper.TAG
import `in`.parangat.a3charger.Helper.setRecyclerView
import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.databinding.FragmentCompletedBinding
import `in`.parangat.a3charger.model.VenueDataItem
import `in`.parangat.a3charger.viewmodel.CompletedViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import `in`.parangat.a3charger.Adapter.CompletedAdapter
import androidx.lifecycle.Observer
import java.util.ArrayList

class CompletedFragment : BaseFragment() {
    var completedViewModel: CompletedViewModel? = null
    lateinit var binding: FragmentCompletedBinding
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_completed, container, false)
        completedViewModel = ViewModelProvider(this)[CompletedViewModel::class.java]
        binding.lifecycleOwner = activity
        binding.completemodel = completedViewModel
        return binding.root
    }

    override fun init() {
        Log.e(TAG, "init: completed")
        completedViewModel?.progressDialog?.observe(this) {
            if (it!!) {
                progressDialog.showProgress()
            } else {
                progressDialog.hideProgress()
            }

        }
        completedViewModel?.dashboardData("12", "1")!!.observe(viewLifecycleOwner, Observer {
            completedAdapter = CompletedAdapter()
            completedAdapter?.setDeveloperList(it as ArrayList<VenueDataItem>)
            setRecyclerView(binding.rvComplete, requireContext())
            binding.rvComplete.adapter = completedAdapter

            completedAdapter?.setOnItemClickListener(object : CompletedAdapter.OnItemClickListener {
                override fun onItemClick(position: Int, arrayList: ArrayList<VenueDataItem>) {
//                    startActivity(Intent(requireContext(),SubjectActivity::class.java).apply {
//                        putExtra("courseId",arrayList[position].courseId)
//                        putExtra("courseName",arrayList[position].courseName)
//                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    })
                }
            })
            completedAdapter!!.notifyDataSetChanged()
        })
    }

    override fun initControl() {
    }

}