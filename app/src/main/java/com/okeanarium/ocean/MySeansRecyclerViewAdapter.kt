package com.okeanarium.ocean

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.okeanarium.ocean.database_server.Seans
import com.okeanarium.ocean.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MySeansRecyclerViewAdapter(
    private val values: List<Seans>?
) : RecyclerView.Adapter<MySeansRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_seans, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values?.get(position)
        if(position%2 == 0){
            holder.name_left.text = item?.name ?: "A";
            holder.time_left.text = item?.times ?: "A";
            holder.date_left.text = item?.date ?: "A";

            holder.leftCard.visibility = View.VISIBLE
            holder.rightCard.visibility = View.GONE
        }else{
            holder.name_right.text = item?.name ?: "A";
            holder.time_right.text = item?.times ?: "A";
            holder.date_right.text = item?.date ?: "A";

            holder.leftCard.visibility = View.GONE
            holder.rightCard.visibility = View.VISIBLE
        }
//            holder.idView.text = item.id
//            holder.contentView.text = item.content

    }

    override fun getItemCount(): Int = values?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val leftCard: ConstraintLayout = view.findViewById(R.id.leftCard)

        val name_left: TextView = view.findViewById(R.id.name_left)
        val time_left: TextView = view.findViewById(R.id.time_left)
        val date_left: TextView = view.findViewById(R.id.date_left)
        //val leftCard: ConstraintLayout = view.findViewById(R.id.leftCard)

        val rightCard: ConstraintLayout = view.findViewById(R.id.rightCard)
        val name_right: TextView = view.findViewById(R.id.name_right)
        val time_right: TextView = view.findViewById(R.id.time_right)
        val date_right: TextView = view.findViewById(R.id.date_right)
    }
}