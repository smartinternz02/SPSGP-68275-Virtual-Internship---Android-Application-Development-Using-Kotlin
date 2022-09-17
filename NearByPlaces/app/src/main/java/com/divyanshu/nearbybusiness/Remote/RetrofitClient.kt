package com.divyanshu.nearbybusiness.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit:Retrofit?=null
    fun getClient(baseurll:String):Retrofit{
        if (retrofit==null)
        {
            retrofit = Retrofit.Builder()
                .baseUrl(baseurll)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}