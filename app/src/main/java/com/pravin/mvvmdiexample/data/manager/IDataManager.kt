package com.pravin.mvvmdiexample.data.manager

import com.pravin.mvvmdiexample.data.local.db.IDbHelper
import com.pravin.mvvmdiexample.data.local.db.prefs.ISharedPrefsHelper
import com.pravin.mvvmdiexample.data.remote.IApiHelper

/**
 * Created by Pravin Divraniya on 11/13/2017.
 */
interface IDataManager: IDbHelper, ISharedPrefsHelper,IApiHelper