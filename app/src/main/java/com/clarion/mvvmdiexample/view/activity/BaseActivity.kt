package com.clarion.mvvmdiexample.view.activity

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatDelegate
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import com.clarion.mvvmdiexample.utils.CommonUtils
import com.clarion.mvvmdiexample.utils.LocationUtils.getDefaultLocationReq
import com.clarion.mvvmdiexample.utils.NetworkUtils
import com.clarion.mvvmdiexample.view.fragment.LocationFragment
import com.clarion.mvvmdiexample.view.navigator.BaseNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsStatusCodes
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import dagger.android.support.DaggerAppCompatActivity


/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
abstract class BaseActivity<out T:ViewDataBinding, out V: BaseViewModel<out BaseNavigator>>: DaggerAppCompatActivity() {
    private lateinit var mViewDataBinding: T
    private var mViewModel: V? =  null
    private var mProgress:ProgressBar? = null
    private val REQUESTCHECKSETTINGS = 0x00000001
    private var fragmentLocation:Fragment? = null

    companion object {
        init {
            System.loadLibrary("native-lib")
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }
    protected fun startLocationUpdates(){
        setLocationPermissionFromSettings()
    }

    protected fun removeLocationUpdates(){
        if(null == fragmentLocation)
            return
        (fragmentLocation as LocationFragment).removeLocationUpdates()
    }

    protected external fun getApiKey():String

    fun setLocationPermissionFromSettings() {
        Dexter.withActivity(this)
                .withPermission(ACCESS_FINE_LOCATION)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                        displayLocationSettingsRequest(this@BaseActivity)
                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest?,
                                                                    token: PermissionToken?) {
                        token!!.continuePermissionRequest()
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                        //TODO display some useful information why we actually need this permission.
                    }
                })
                .check()
    }

    fun displayLocationSettingsRequest(context: Context) {
        val builder = LocationSettingsRequest.Builder().addLocationRequest(getDefaultLocationReq())
        val client = LocationServices.getSettingsClient(context)
        val task = client.checkLocationSettings(builder.build())

        task.addOnSuccessListener(this) {
            initLocationFragment()
        }
        task.addOnFailureListener(this){
            e -> val statusCode = (e as ApiException).statusCode
            when(statusCode){
                CommonStatusCodes.RESOLUTION_REQUIRED -> {
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        val resolvable = e as ResolvableApiException
                        resolvable.startResolutionForResult(this, REQUESTCHECKSETTINGS)
                    }catch (e: IntentSender.SendIntentException){
                        // Ignore the error.
                    }
                }
                LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                    // Location settings are not satisfied. However, we have no way
                    // to fix the settings so we won't show the dialog.
                }
                else ->{
                    //TODO handle default implementation
                }
            }
        }
    }
    private fun initLocationFragment() {
        val ft = supportFragmentManager.beginTransaction()
        fragmentLocation = supportFragmentManager.findFragmentByTag(LocationFragment.TAG)
        if(null == fragmentLocation)
            fragmentLocation = LocationFragment.newInstance()
        if (fragmentLocation!!.isAdded)
            return
        ft.add(fragmentLocation, LocationFragment.TAG).commitAllowingStateLoss()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil
                .setContentView(this, getLayoutId())
        this.mViewModel = if (mViewModel == null) getMyViewModel() else mViewModel
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    fun hideKeyboard(){
        val view = this.currentFocus
        if(null != view){
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken,0)
        }
    }

    fun isNetworkConnected() = NetworkUtils.isNetworkConnected(this)

    fun showLoading(){
        hideLoading()
        mProgress = CommonUtils.showLoadingDialog(this,mViewDataBinding.root)
    }

    fun hideLoading(){
        if(null != mProgress){
            CommonUtils.hideLoadingDialog(mViewDataBinding.root as ViewGroup,mProgress!!.parent as ViewGroup)
            mProgress = null
        }
    }

    abstract fun getBindingVariable(): Int
    abstract fun getMyViewModel(): V
    @LayoutRes
    abstract fun getLayoutId():Int

    protected fun getViewDataBinding():T = mViewDataBinding

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUESTCHECKSETTINGS -> {
                initLocationFragment()
            }
            else -> {
                //TODO handle default implementation
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        removeLocationUpdates()
    }
}