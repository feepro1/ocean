package com.okeanarium.ocean

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout

import com.okeanarium.ocean.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MySeansRecyclerViewAdapter(
    private val values: List<DummyItem>
) : RecyclerView.Adapter<MySeansRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_seans, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        if(position%2 == 0){
            holder.leftCard.visibility = View.VISIBLE
            holder.rightCard.visibility = View.GONE
        }else{
            holder.leftCard.visibility = View.GONE
            holder.rightCard.visibility = View.VISIBLE
        }
//            holder.idView.text = item.id
//            holder.contentView.text = item.content

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val leftCard: ConstraintLayout = view.findViewById(R.id.leftCard)
        val rightCard: ConstraintLayout = view.findViewById(R.id.rightCard)
    }
}