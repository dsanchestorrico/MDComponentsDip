package com.mdcomponents.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.mdcomponents.R
import com.mdcomponents.entity.Component

class ComponentAdapter(): RecyclerView.Adapter<ComponentAdapter.ViewHolder>() {

    private var list: MutableList<Component> = mutableListOf()
    private lateinit var clickListener: OnClickListener

    fun setOnItemClickListener(clickListener: OnClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_component, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var component = list[position]
        holder.tvName.text = component.name
        holder.imgPhoto.setImageResource(component.photoRes)
        holder.view.setOnClickListener{ view ->
            clickListener.onClick(component)
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    fun add(component: Component) {
        this.list.add(component)
        notifyItemInserted(this.list.size - 1)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto = itemView.findViewById<AppCompatImageView>(R.id.imgPhoto)
        var tvName = itemView.findViewById<TextView>(R.id.tvName)
        var view = itemView.findViewById<MaterialCardView>(R.id.item)
    }




}