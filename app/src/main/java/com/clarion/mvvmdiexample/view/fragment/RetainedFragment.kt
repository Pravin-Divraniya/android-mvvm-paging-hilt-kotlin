package com.clarion.mvvmdiexample.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.clarion.mvvmdiexample.R
import com.clarion.mvvmdiexample.data.model.api.GalleryImages
import com.clarion.mvvmdiexample.data.model.api.NewsResponse

/**
 * A simple [Fragment] subclass.
 *
 */
class RetainedFragment : Fragment() {

    var galleryList:MutableList<GalleryImages>? = null
        get() = field
        set(value) {
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

}
