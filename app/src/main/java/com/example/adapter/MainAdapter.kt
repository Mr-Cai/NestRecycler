package com.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.MainActivity.Companion.horizontalData
import com.example.MainActivity.Companion.verticalData
import com.example.R
import com.example.SingleHorizontal
import com.example.SingleVertical
import kotlinx.android.synthetic.main.horizontal.view.*
import kotlinx.android.synthetic.main.vertical.view.*
import java.util.*

class MainAdapter(private val context: Context, private val items: ArrayList<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            VERTICAL -> VerticalViewHolder(inflater.inflate(R.layout.vertical, parent, false))
            HORIZONTAL -> HorizontalViewHolder(inflater.inflate(R.layout.horizontal, parent, false))
            else -> HorizontalViewHolder(inflater.inflate(R.layout.horizontal, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VERTICAL) verticalView(holder as VerticalViewHolder)
        else if (holder.itemViewType == HORIZONTAL) horizontalView(holder as HorizontalViewHolder)
    }

    private fun verticalView(holder: VerticalViewHolder) {
        holder.itemView.verticalRecycler.layoutManager = LinearLayoutManager(context)
        holder.itemView.verticalRecycler.adapter = VerticalAdapter(verticalData)
    }


    private fun horizontalView(holder: HorizontalViewHolder) {
        holder.itemView.inner_recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.itemView.inner_recyclerView.adapter = HorizontalAdapter(horizontalData)
    }


    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        if (items[position] is SingleVertical) return VERTICAL
        return if (items[position] is SingleHorizontal) HORIZONTAL else -1
    }

    class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class VerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        const val VERTICAL = 1
        const val HORIZONTAL = 2
    }
}
