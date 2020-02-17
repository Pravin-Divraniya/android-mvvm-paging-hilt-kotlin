package com.pravin.mvvmdiexample.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pravin.mvvmdiexample.data.model.api.GalleryImages

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
