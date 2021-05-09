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
import com.okeanarium.ocean.database_client.ClientDatabase
import com.okeanarium.ocean.database_server.AppDatabase
import com.okeanarium.ocean.database_server.Suvenier

/**
 * A fragment representing a list of Items.
 */
class BasketFragment(val db: ClientDatabase,val servDB : AppDatabase, val supportFragmentManager: FragmentManager) : Fragment() {

    private var columnCount = 2
    val suv : MutableList<Suvenier> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = 2
        }
        val buyList = db.BuyDao().getBuyItem()
        for(i in buyList)
            suv.add(servDB.suvenierDao().getSuvenierById(i.suvId))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_basket_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 2 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyBasketRecyclerViewAdapter(suv,context,supportFragmentManager)
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
//            BasketFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_COLUMN_COUNT, columnCount)
//                }
//            }
  }
}