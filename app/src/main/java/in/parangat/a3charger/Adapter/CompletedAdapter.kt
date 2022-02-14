package `in`.parangat.a3charger.Adapter

import `in`.parangat.a3charger.R
import `in`.parangat.a3charger.databinding.RowListLayoutBinding
import `in`.parangat.a3charger.model.VenueDataItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CompletedAdapter: RecyclerView.Adapter<CompletedAdapter.DeveloperViewHolder>() {
    lateinit var listener: OnItemClickListener
    private var mDeveloperModel: ArrayList<VenueDataItem>? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): DeveloperViewHolder {
        val mDeveloperListItemBinding = DataBindingUtil.inflate<RowListLayoutBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.row_list_layout,
            viewGroup,
            false
        )
        return DeveloperViewHolder(mDeveloperListItemBinding)
    }

    override fun onBindViewHolder(mDeveloperViewHolder: DeveloperViewHolder, i: Int) {
        val currentModel = mDeveloperModel!![i]
        mDeveloperViewHolder.mDeveloperListItemBinding.datamodel = currentModel
        mDeveloperViewHolder.mDeveloperListItemBinding.tvCount.text=(i+1).toString()+"."
        mDeveloperViewHolder.mDeveloperListItemBinding.root.setOnClickListener {
            listener.onItemClick(position = i,mDeveloperModel!!)
        }
    }

    override fun getItemCount(): Int {
        return if (mDeveloperModel != null) {
            mDeveloperModel!!.size
        } else {
            0
        }
    }

    fun setDeveloperList(mDeveloperModel: ArrayList<VenueDataItem>) {
        this.mDeveloperModel = mDeveloperModel
        notifyDataSetChanged()
    }

    inner class DeveloperViewHolder(var mDeveloperListItemBinding: RowListLayoutBinding) :
        RecyclerView.ViewHolder(mDeveloperListItemBinding.root)


    interface OnItemClickListener {
        fun onItemClick(position: Int,arrayList: ArrayList<VenueDataItem>)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

}
