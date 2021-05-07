package com.okeanarium.ocean

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.okeanarium.ocean.database_server.AppDatabase
import com.okeanarium.ocean.database_server.Suvenier

/**
 * A fragment representing a list of Items.
 */
class suveniierFragment(val db: AppDatabase) : Fragment() {

    private var columnCount = 2
    lateinit var suv : List<Suvenier>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = 2
        }
        suv = db.suvenierDao().getSuvenier()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_suveniier_list, container, false)

        // Set the adapter
        if (view.findViewById<RecyclerView>(R.id.list) is RecyclerView) {
            with(view.findViewById<RecyclerView>(R.id.list)) {
                layoutManager = when {
                    columnCount <= 1 -> StaggeredGridLayoutManager(
                        2,
                        StaggeredGridLayoutManager.VERTICAL
                    )
                    else -> StaggeredGridLayoutManager(
                        2,
                        StaggeredGridLayoutManager.VERTICAL
                    )
                }
                adapter = MySuveniierRecyclerViewAdapter(suv, context)
            }
            view.findViewById<ImageButton>(R.id.basket_open_btn).setOnClickListener {
                (activity as MainActivity?)?.openBusket()
            }

        }

        return view
    }

    companion object {

//        // TODO: Customize parameter argument names
//        const val ARG_COLUMN_COUNT = "column-count"
//
//        // TODO: Customize parameter initialization
//        @JvmStatic
//        fun newInstance(columnCount: Int) =
//                suveniierFragment().apply {
//                    arguments = Bundle().apply {
//                        putInt(ARG_COLUMN_COUNT, columnCount)
//                    }
//                }
    }
}