package com.nimmaguru.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleTextAdapter(private var items: List<String>) : RecyclerView.Adapter<SimpleTextAdapter.VH>() {
    class VH(val tv: TextView): RecyclerView.ViewHolder(tv)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false) as TextView)
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: VH, position: Int) { holder.tv.text = items[position] }
    fun update(list: List<String>) { items = list; notifyDataSetChanged() }
}
