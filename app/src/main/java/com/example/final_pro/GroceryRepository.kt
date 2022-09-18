package com.example.final_pro

class GroceryRepository(private val db: GroceryDatabase) {


    suspend fun insert(items: GroceryItems)=db.getGroceryDap().insert(items)
    suspend fun delete(items: GroceryItems)=db.getGroceryDap().delete(items)

    fun getAllItems()=db.getGroceryDap().getAllGroceryItems()

}