package com.clarion.mvvmdiexample.services

import android.app.IntentService
import android.content.Intent
import android.location.Location
import android.util.Log
import android.widget.Toast
import com.google.android.gms.location.LocationResult
import com.clarion.mvvmdiexample.utils.ConstantData
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by Pravin Divraniya on 11/15/2017.
 */
class LocationService : IntentService(LocationService::class.java.simpleName) {

    companion object {
        val ACTION_PROCESS_UPDATES = ConstantData.PACKAGE_NAME+".action"+
                ".PROCESS_UPDATES"
    }

    override fun onHandleIntent(intent: Intent?) {
        if(null == intent)
            return
        val action = intent.action
        if(ACTION_PROCESS_UPDATES == action){
            val result = LocationResult.extractResult(intent) ?: return
            val locations = result.locations

            for(location:Location in locations){
                val msg = location.latitude.toString()+
                        "\n" +
                        location.longitude.toString()
                Log.i(LocationService::class.java.simpleName,msg);
//                launch(UI){
//                    Toast.makeText(this@LocationService,msg,Toast.LENGTH_SHORT).show()
//                }
            }
        }
    }
}