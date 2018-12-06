package com.clarion.mvvmdiexample.common

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by Pravin Divraniya on 10/4/2017.
 */
abstract class MyTextWatcher:TextWatcher {
    override fun afterTextChanged(p0: Editable) {
        onTextChanged(p0)
    }

    override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

    }
    abstract fun onTextChanged(newValue:Any?)
}