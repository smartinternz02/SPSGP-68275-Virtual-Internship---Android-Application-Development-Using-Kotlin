package com.example.final_pro

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName="grocery_items")
public final data class GroceryItems(

    @ColumnInfo(name = "itemName")
    var itemName: String,
    @ColumnInfo(name = "itemQuantity")
    var itemQuantity: Int,
    @ColumnInfo(name="itemPrice")
    var itemPrice: Int,
    )
    {
        @PrimaryKey(autoGenerate = true)
        var id:Int?=null
    }
