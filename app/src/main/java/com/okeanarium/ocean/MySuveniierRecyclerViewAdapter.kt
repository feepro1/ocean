package com.okeanarium.ocean

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.okeanarium.ocean.database_server.Suvenier
import com.okeanarium.ocean.dummy.DummyContent.DummyItem
import com.squareup.picasso.Picasso

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MySuveniierRecyclerViewAdapter(
    private val values: List<Suvenier>,
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

        Picasso.with(context).load(item.imageURL).into(holder.avatar);
        holder.name.text = item.name;
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val parentCL: ConstraintLayout = view.findViewById(R.id.parentCL)
        val avatar: ImageView = view.findViewById(R.id.avatar)
        val name: TextView = view.findViewById(R.id.name)
    }
}