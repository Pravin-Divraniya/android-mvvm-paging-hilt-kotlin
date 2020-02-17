package com.pravin.mvvmdiexample.view.fragment

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.pravin.mvvmdiexample.receiver.LocationReceiver
import com.pravin.mvvmdiexample.utils.LocationUtils.getDefaultLocationReq


/**
 * A simple [Fragment] subclass.
 * Use the [LocationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationFragment : Fragment() {
    /**
     * Stores parameters for requests to the FusedLocationProviderApi.
     */
    private lateinit var mLocationRequest: LocationRequest

    /**
     * Provides access to the Fused Location Provider API.
     */
    private lateinit var mFusedLocationClient: FusedLocationProviderClient

    /*
     * Pending intent object of Associated broadcast receiver responsible to listen to location change.
     */
    private var mPendingIntent:PendingIntent? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        initLocationService()
    }
    companion object {

        val TAG = LocationFragment::class.java.simpleName

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment LocationFragment.
         */
        fun newInstance(): LocationFragment = LocationFragment()

    }

    private fun initLocationService() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context!!);
        createLocationRequest();
    }

    /**
     * Sets up the location request. Android has two location request settings:
     * `ACCESS_COARSE_LOCATION` and `ACCESS_FINE_LOCATION`. These settings control
     * the accuracy of the current location. This sample uses ACCESS_FINE_LOCATION, as defined in
     * the AndroidManifest.xml.
     *
     *
     * When the ACCESS_FINE_LOCATION setting is specified, combined with a fast update
     * interval (5 seconds), the Fused Location Provider API returns location updates that are
     * accurate to within a few feet.
     *
     *
     * These settings are appropriate for mapping applications that show real-time location
     * updates.
     */
    private fun createLocationRequest() {
        mLocationRequest = getDefaultLocationReq()
        requestLocationUpdates()
    }

    /**
     * Handles the Request Updates button and requests start of location updates.
     */
    private fun requestLocationUpdates() {
        try {
            Log.i(TAG, "Starting location updates")
            mPendingIntent = getPendingIntent()
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, getPendingIntent())
        } catch (e: SecurityException) {
            e.printStackTrace()
        }

    }

    /**
     * Handles the Remove Updates button, and requests removal of location updates.
     */
    fun removeLocationUpdates() {
        if(null == mPendingIntent)
            return
        Log.i(TAG, "Removing location updates")
        mFusedLocationClient.removeLocationUpdates(mPendingIntent)
    }

    /**/
    private fun getPendingIntent(): PendingIntent {
        // Note: for apps targeting API level 25 ("Nougat") or lower, either
        // PendingIntent.getService() or PendingIntent.getBroadcast() may be used when requesting
        // location updates. For apps targeting API level O, only
        // PendingIntent.getBroadcast() should be used. This is due to the limits placed on services
        // started in the background in "O".


//        val intent = Intent(this, LocationService::class.java)
//        intent.action = LocationService.ACTION_PROCESS_UPDATES
//        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val intent = Intent(context, LocationReceiver::class.java)
        intent.action = LocationReceiver.ACTION_PROCESS_UPDATES
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
}
