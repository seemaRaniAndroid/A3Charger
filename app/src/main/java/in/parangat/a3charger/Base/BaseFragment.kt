package `in`.parangat.a3charger.Base

import `in`.parangat.a3charger.Database.SharedPreferenceUtil
import androidx.fragment.app.Fragment
import `in`.parangat.a3charger.Helper.CustomProgress

abstract class BaseFragment : Fragment(){

    val progressDialog: CustomProgress by lazy { CustomProgress(requireContext()) }

    abstract fun init()

    abstract fun initControl()

    val prefs by lazy {
        SharedPreferenceUtil.getInstance(requireContext())
    }



}