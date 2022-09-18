package com.example.final_pro
import androidx.lifecycle.LiveData
import androidx.room.*

// annotation for dao class.
@Dao
abstract class GroceryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item :GroceryItems) {
    }

    @Delete
    suspend fun delete(item:GroceryItems) {
    }

    @Query("Select * from grocery_items")
    abstract fun getAllGroceryItems(): LiveData<List<GroceryItems>>

}