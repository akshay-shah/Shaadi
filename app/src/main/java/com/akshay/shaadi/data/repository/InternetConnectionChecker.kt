package com.akshay.shaadi.data.repository

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class InternetConnectionChecker @Inject constructor(val context: Context) {
    fun checkConnectivity(): Boolean? {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetwork
        return activeNetwork != null
    }
}