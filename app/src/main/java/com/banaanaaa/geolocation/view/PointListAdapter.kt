package com.banaanaaa.geolocation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.banaanaaa.geolocation.R
import com.banaanaaa.geolocation.databinding.PointItemBinding
import com.banaanaaa.geolocation.model.entity.Point

class PointListAdapter(private val listener: FragmentList.Listener) :
    RecyclerView.Adapter<PointListAdapter.PointViewHolder>() {

    private val points = mutableListOf<Point>()

    internal fun setPoints(points: List<Point>) {
        this.points.clear()
        this.points.addAll(0, points)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        return PointViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.point_item, parent, false))
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        holder.binding.point = points[position]
        holder.binding.listener = listener
    }

    override fun getItemCount() = points.size


    inner class PointViewHolder(val binding: PointItemBinding)
            : RecyclerView.ViewHolder(binding.root)
}