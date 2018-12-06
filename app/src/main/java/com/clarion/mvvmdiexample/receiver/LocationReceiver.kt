package com.clarion.mvvmdiexample.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.Location
import android.util.Log
import com.google.android.gms.location.LocationResult
import com.clarion.mvvmdiexample.services.LocationService
import com.clarion.mvvmdiexample.utils.ConstantData

/**
 * Created by Pravin Divraniya on 11/16/2017.
 */
class LocationReceiver : BroadcastReceiver() {
    companion object {
        val ACTION_PROCESS_UPDATES = ConstantData.PACKAGE_NAME+".action"+
                ".PROCESS_UPDATES"
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        if(null == intent)
            return
        val action = intent.action
        if(LocationService.ACTION_PROCESS_UPDATES == action){
            val result = LocationResult.extractResult(intent) ?: return
            val locations = result.locations

            for(location: Location in locations){
                val msg = location.latitude.toString()+
                        "\n" +
                        location.longitude.toString()
                Log.i(LocationService::class.java.simpleName,msg);
//                launch(UI){
//                    Toast.makeText(context, msg,Toast.LENGTH_SHORT).show()
//                }
            }
        }
    }
}