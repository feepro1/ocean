package com.okeanarium.ocean

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okeanarium.ocean.database_server.AppDatabase
import com.okeanarium.ocean.database_server.Seans

/**
 * A fragment representing a list of Items.
 */
class SeansFragment(val servDB: AppDatabase, val supportFragmentManager: FragmentManager) : Fragment() {

    private var columnCount = 1
    lateinit var seans : List<Seans>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = 1
        }
        seans = servDB.seansDao().getSeans()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seans_item_list, container, false)

        // Set the adapter
        if (view.findViewById<RecyclerView>(R.id.list) is RecyclerView) {
            with(view.findViewById<RecyclerView>(R.id.list) ) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MySeansRecyclerViewAdapter(seans,context,supportFragmentManager)
            }
        }
        return view
    }

    companion object {

//        // TODO: Customize parameter argument names
//        const val ARG_COLUMN_COUNT = "column-count"
//
//        // TODO: Customize parameter initialization
//     @JvmStatic
//       fun newInstance() =
//          SeansFragment(servDB, supportFragmentManager).apply {
//              arguments = Bundle().apply {
//                  putInt(ARG_COLUMN_COUNT, columnCount)
//              }
//            }
//

    }


}