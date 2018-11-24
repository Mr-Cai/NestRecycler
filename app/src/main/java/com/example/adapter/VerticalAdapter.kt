package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.SingleVertical
import kotlinx.android.synthetic.main.vertical_single_row.view.*
import java.util.*

class VerticalAdapter(private var data: ArrayList<SingleVertical>) :
    RecyclerView.Adapter<VerticalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vertical_single_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = holder.itemView
        val data = data[position]
        itemView.image.setImageResource(data.image)
        itemView.title.text = data.header
        itemView.description.text = data.subHeader
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
