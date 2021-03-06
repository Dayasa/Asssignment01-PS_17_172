package com.example.assignment01.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment01.models.data
import com.example.assignment01.R
import javax.security.auth.callback.Callback

class dataAdapter (private val datalist:List<data>,
                   val context: Callback<List<data>>,
                   private val onItemIsClicked: (position: Int) -> Unit
): RecyclerView.Adapter<dataAdapter.viewHolder>(){

    class viewHolder(ItemView: View, private val onItemIsClicked:(position:Int) -> Unit){
        val textTitle = itemView.findViewById<TextView>(R.id.Item_title)
        val itemId = itemView.findViewById<TextView>(R.id.item_id)

        override fun onClick(p0: View?){
            val position = adapterPosition
            onItemIsClicked(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return viewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val itemViewModel = datalist[position]

        Picasso.get()
        holder.textTitle.text = itemViewModel.title
        holder.itemId.text = itemViewModel.id
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}