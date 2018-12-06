package com.clarion.mvvmdiexample

import android.content.Context
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ConnectionCheck {
    companion object {
        fun checkConnectivity(context: Context){
            ReactiveNetwork.observeNetworkConnectivity(context)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe{
                        connectivity -> //Use this connectivity object to check network state and other network related information
                    }

        }
    }
}