package `in`.parangat.a3charger.Adapter

import `in`.parangat.a3charger.UI.Fragment.CompletedFragment
import `in`.parangat.a3charger.UI.Fragment.PendingFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                 return PendingFragment()
            }
            1 ->{
                return CompletedFragment()
            }
            else -> {
                return PendingFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return when(position) {
            0 -> {
                "Pending"
            }
            1 ->{
                "Completed"
            }
            else -> {
                "Pending"
            }
        }
        return super.getPageTitle(position)
    }
}