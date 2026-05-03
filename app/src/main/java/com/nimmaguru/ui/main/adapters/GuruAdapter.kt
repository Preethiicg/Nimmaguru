package com.nimmaguru.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nimmaguru.R
import com.nimmaguru.data.model.Guru

class GuruAdapter(private var items: List<Guru>) : RecyclerView.Adapter<GuruAdapter.VH>() {
    class VH(v: View): RecyclerView.ViewHolder(v)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(LayoutInflater.from(parent.context).inflate(R.layout.item_guru, parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(h: VH, i: Int) {
        val g = items[i]
        h.itemView.findViewById<TextView>(R.id.tvName).text = "👨‍🏫 ${g.name}"
        h.itemView.findViewById<TextView>(R.id.tvSkills).text = "Skills: ${g.skills.joinToString()}"
        h.itemView.findViewById<TextView>(R.id.tvAvailability).text = "Available: ${g.availability}"
        h.itemView.findViewById<TextView>(R.id.tvLocation).text = "Location: ${g.location}"
    }
    fun update(newItems: List<Guru>) { items = newItems; notifyDataSetChanged() }
}
