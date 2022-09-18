package com.example.final_pro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class GroceryRvAdapter(
    var list: List<GroceryItems>,
    val groceryItemClickInterface: MainActivity
    ) : RecyclerView.Adapter<GroceryRvAdapter.GroceryViewHolder>(){
    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


                               val nameTV=itemView.findViewById<TextView>(R.id.idRVItemName)
                               val quantityTV=itemView.findViewById<TextView>(R.id.idTvQuantity)
                               val rateTV=itemView.findViewById<TextView>(R.id.idTvRate)
                               val amountTV=itemView.findViewById<TextView>(R.id.IdtvTotalAmt)
                               val deleteTV=itemView.findViewById<TextView>(R.id.idTvDel)

                           }

                        interface GroceryItemClickInterface{
                            fun onItemClick(groceryItems: GroceryItems)
                        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_items,parent,false)
            return GroceryViewHolder(view)
    }

//    override fun onBindViewHolder(
//
//
//    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GroceryRvAdapter.GroceryViewHolder,
                                  position: Int

    ) {
        holder.nameTV.text=list.get(position).itemName
        holder.quantityTV.text=list.get(position).itemQuantity.toString()
        holder.rateTV.text="Rs."+list.get(position).itemPrice.toString()

        val itemtotal: Int = list.get(position).itemPrice*list.get(position).itemQuantity

        holder.amountTV.text="Rs."+itemtotal.toString()
        holder.deleteTV.setOnClickListener {
            groceryItemClickInterface.onItemClick((list.get(position)))
        }

        TODO("Not yet implemented")
    }




}