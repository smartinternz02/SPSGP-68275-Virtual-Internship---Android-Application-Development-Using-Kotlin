package com.example.final_pro

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var itemsRV:RecyclerView
    lateinit var addFAB:FloatingActionButton
    lateinit var list: List<GroceryItems>
    lateinit var groceryRvAdapter: GroceryRvAdapter
    lateinit var groceryViewModel: GroceryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemsRV=findViewById(R.id.idRVItems)
        addFAB=findViewById(R.id.idFABAdd)
        list=ArrayList<GroceryItems>()
        groceryRvAdapter= GroceryRvAdapter(list,this)
        itemsRV.layoutManager=LinearLayoutManager(this)
        itemsRV.adapter=groceryRvAdapter

        val groceryRepository=GroceryRepository(GroceryDatabase(this))
        val factory=GroceryViewModelFactory(groceryRepository)

        groceryViewModel=ViewModelProvider(this,factory).get(GroceryViewModel::class.java)
        groceryViewModel.getAllGloceryItems().observe(this,{
            groceryRvAdapter.list=it
            groceryRvAdapter.notifyDataSetChanged()
        })
        addFAB.setOnClickListener {
            openDialog()

        }

    }
    fun openDialog(){
        val dialog=Dialog(this)
        dialog.setContentView(R.layout.grocery_add_dialog)

        val cancelBtn=dialog.findViewById<Button>(R.id.idBtncancle)
        val addBtn=dialog.findViewById<Button>(R.id.idBtnAdd)
        val itemEdt=dialog.findViewById<EditText>(R.id.idEditItemName)
        val itemPriceEdit=dialog.findViewById<EditText>(R.id.idEditItemPrice)
        val itemQuantityEdit=dialog.findViewById<EditText>(R.id.idEditItemQuantity)

        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }
        addBtn.setOnClickListener {
            val itemName: String = itemEdt.text.toString()
            val itemPrice: String = itemPriceEdit.text.toString()
            val itemQuantity: String = itemQuantityEdit.text.toString()
            val qty: Int = itemQuantity.toInt()
            val pr: Int = itemPrice.toInt()

            if (itemName.isNotEmpty() && itemPrice.isNotEmpty() && itemQuantity.isNotEmpty())
            {
                val items = GroceryItems(itemName, qty, pr)

            groceryViewModel.insert(items)
            Toast.makeText(applicationContext, "Item added", Toast.LENGTH_SHORT)
            groceryRvAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }else{
                Toast.makeText(applicationContext,"Please enter all data",Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }
    fun onItemClick(groceryItems: GroceryItems){
        groceryViewModel.delete(groceryItems)
        groceryRvAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext,"Item Deleted",Toast.LENGTH_SHORT).show()
    }
}