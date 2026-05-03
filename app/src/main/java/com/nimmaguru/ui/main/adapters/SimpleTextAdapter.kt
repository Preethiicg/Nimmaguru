package com.nimmaguru.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nimmaguru.R

class SimpleTextAdapter(private var items: List<String>) : RecyclerView.Adapter<SimpleTextAdapter.VH>() {
    class VH(v: View): RecyclerView.ViewHolder(v)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(LayoutInflater.from(parent.context).inflate(R.layout.item_simple_card, parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: VH, position: Int) { holder.itemView.findViewById<TextView>(R.id.tvCardText).text = items[position] }
    fun update(list: List<String>) { items = list; notifyDataSetChanged() }
}
