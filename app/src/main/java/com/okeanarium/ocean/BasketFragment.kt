package com.okeanarium.ocean

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
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

    private var columnCount = 1
    val suv : MutableList<Suvenier> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = 1
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

        view.findViewById<ImageView>(R.id.backBtn).setOnClickListener { (activity as MainActivity?)?.openSuvenier() }
        view.findViewById<Button>(R.id.buy_btn).setOnClickListener {
            if(suv.size > 0){
                db.BuyDao().deleteBuyAllItem()
                (activity as MainActivity?)?.openBusket()
                Toast.makeText(context,"Покупка совершена успешно!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Корзина пуста",Toast.LENGTH_SHORT).show()
            }
        }
        // Set the adapter
        if (view.findViewById<RecyclerView>(R.id.list) is RecyclerView) {
            with(view.findViewById<RecyclerView>(R.id.list)) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
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