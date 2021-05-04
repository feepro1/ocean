package com.okeanarium.ocean

import android.app.ActionBar
import android.content.Context
import android.text.Layout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

import com.okeanarium.ocean.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MySuveniierRecyclerViewAdapter(
        private val values: List<DummyItem>,
        private val context: Context
)
    : RecyclerView.Adapter<MySuveniierRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_suveniier, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
      if((position+1 )%6== 0 || position == 0)
          holder.parentCL.layoutParams.height = (340*context.resources.displayMetrics.density).toInt()
        else
          holder.parentCL.layoutParams.height = (370*context.resources.displayMetrics.density).toInt()
//        holder.idView.text = item.id
//        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val parentCL: ConstraintLayout = view.findViewById(R.id.parentCL)
//        val contentView: TextView = view.findViewById(R.id.content)
//
//        override fun toString(): String {
//            return super.toString() + " '" + contentView.text + "'"
//        }
    }
}