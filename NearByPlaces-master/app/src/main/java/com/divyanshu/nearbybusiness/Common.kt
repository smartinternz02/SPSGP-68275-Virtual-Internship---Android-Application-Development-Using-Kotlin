package com.divyanshu.nearbybusiness

import com.divyanshu.nearbybusiness.Model.Results
import com.divyanshu.nearbybusiness.Remote.IGoogleAPIService
import com.divyanshu.nearbybusiness.Remote.RetrofitClient


object Common {
    var currentResult: Results? = null

    private val GOOGLE_API_URL="https://maps.googleapis.com/"
    val googleApiService:IGoogleAPIService
    get()=RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService::class.java)
}