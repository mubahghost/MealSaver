package com.codecx.mealsaver.adaptors

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codecx.mealsaver.databinding.DataitemlayoutBinding
import com.codecx.mealsaver.dataclasses.Meal
import com.codecx.mealsaver.viewholders.DataViewHolder

class DataAdaptor : RecyclerView.Adapter<DataViewHolder>() {
    private var mList: List<Meal> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            DataitemlayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        Glide.with(holder.binding.root.context).load(mList[position].strMealThumb).error(android.R.drawable.ic_menu_report_image).into(holder.binding.mImage)
        holder.binding.tvName.text=mList[position].strMeal
        holder.binding.tvInfo.text = mList[position].toString()
    }

    fun submitData(newList: List<Meal>) {
        mList = newList
        notifyDataSetChanged()
    }
}