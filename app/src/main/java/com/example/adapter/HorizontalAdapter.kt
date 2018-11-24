package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.SingleHorizontal
import kotlinx.android.synthetic.main.horizontal_single_row.view.*
import java.util.*

class HorizontalAdapter(private var data: ArrayList<SingleHorizontal>) :
    RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_single_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = holder.itemView
        val data = data[position]
        itemView.description.text = data.desc
        itemView.title.text = data.title
        itemView.published_date.text = data.pubDate
        itemView.image_view.setImageResource(data.images)
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
