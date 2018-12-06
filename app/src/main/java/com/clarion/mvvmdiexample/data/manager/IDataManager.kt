package com.clarion.mvvmdiexample.data.manager

import com.clarion.mvvmdiexample.data.local.db.IDbHelper
import com.clarion.mvvmdiexample.data.local.db.prefs.ISharedPrefsHelper
import com.clarion.mvvmdiexample.data.remote.IApiHelper

/**
 * Created by Pravin Divraniya on 11/13/2017.
 */
interface IDataManager: IDbHelper, ISharedPrefsHelper,IApiHelper