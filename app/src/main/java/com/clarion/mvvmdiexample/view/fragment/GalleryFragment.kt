package com.clarion.mvvmdiexample.view.fragment

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.*
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.R
import com.clarion.mvvmdiexample.data.model.api.GalleryImages
import com.clarion.mvvmdiexample.databinding.FragmentGalleryBinding
import com.clarion.mvvmdiexample.view.adapter.GalleryAdapter
import com.clarion.mvvmdiexample.view.navigator.GalleryFragmentNavigator
import com.clarion.mvvmdiexample.viewmodel.fragment.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [GalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GalleryFragment : BaseFragment<FragmentGalleryBinding, GalleryViewModel>(), GalleryFragmentNavigator {

    @Inject
    protected lateinit var mViewModel: GalleryViewModel

    @Inject
    protected lateinit var adapter:GalleryAdapter

    private val TAG_RETAINED_FRAGMENT = RetainedFragment::class.java.simpleName

    private var mRetainedFragment: Fragment? = null

    private var listState: Parcelable? = null

    private val LIST_STATE_KEY = "recycler_list_state"

    override fun getViewModel() = mViewModel

    override fun getBindingVariable() = BR.galleryViewModel

    override fun getLayoutId() = R.layout.fragment_gallery

    private var mHandler:Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.mAdapter.set(adapter)
        mViewModel.dataList.observe(this, android.arch.lifecycle.Observer { list ->
            mViewModel.mAdapter.get()?.submitList(list)
            (mRetainedFragment as RetainedFragment).galleryList = list
            mViewModel.mAdapter.get()?.notifyItemRangeChanged(0, (list?.size!!), list.size)
        })
        addAndGetRetainFragment()
        initHandlerThread()
    }

    private fun initHandlerThread() {
        val handlerThread = HandlerThread("MyHandlerThread")
        handlerThread?.start()
        mHandler = Handler(handlerThread?.looper,Handler.Callback { msg ->
            toggleCheckBox(msg.obj as Boolean)
            true })
    }

    private fun addAndGetRetainFragment() {
        // find the retained fragment on activity restarts
        val fm = childFragmentManager
        mRetainedFragment = fm.findFragmentByTag(TAG_RETAINED_FRAGMENT)

        // create the fragment and data the first time
        if (mRetainedFragment == null) {
            // add the fragment
            mRetainedFragment = RetainedFragment()
            fm.beginTransaction().add(mRetainedFragment, TAG_RETAINED_FRAGMENT).commit()
            // load data from a data source or perform any calculation
            (mRetainedFragment as RetainedFragment).galleryList = mViewModel.loadInitialData(resources)
        }else if((mRetainedFragment as RetainedFragment).galleryList != null)
            mViewModel.dataList.value = (mRetainedFragment as RetainedFragment).galleryList
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        listState = rcGalleryView.layoutManager.onSaveInstanceState()
        outState.putParcelable(LIST_STATE_KEY,listState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(null != savedInstanceState)
            listState = savedInstanceState.getParcelable(LIST_STATE_KEY)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
        if(activity!!.isFinishing){
            if (mRetainedFragment != null)
                childFragmentManager.beginTransaction().remove(mRetainedFragment)
            if(mHandler != null && mHandler!!.looper != null)
                mHandler!!.looper.quit()
        }
    }

    override fun onResume() {
        super.onResume()
        if(null != listState){
            rcGalleryView.layoutManager.onRestoreInstanceState(listState)
            listState = null
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcGalleryView.layoutManager = GridLayoutManager(context,
                if (resources.configuration.orientation == ORIENTATION_PORTRAIT) SPAN_COUNT_PORTRAIT
                else SPAN_COUNT_LANDSCAPE)
        rcGalleryView.setHasFixedSize(true)
    }

    companion object {

        private const val SPAN_COUNT_PORTRAIT = 3
        private const val SPAN_COUNT_LANDSCAPE = 5

        val TAG = GalleryFragment::class.java.simpleName
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment GalleryFragment.
         */
        @JvmStatic
        fun newInstance() =
                GalleryFragment()
    }

    override fun onItemCheck(isChecked: Boolean, item: GalleryImages) {
        mHandler?.post {
            var allChecked = isChecked
            for (model in mViewModel.dataList.value!!){
                if(!model.isChecked && allChecked){
                    allChecked = false
                    return@post
                }
            }
            val msg = Message()
            msg.obj = allChecked
            mHandler?.sendMessage(msg)
        }
    }

    private fun toggleCheckBox(isChecked: Boolean){
        launch(UI) { cbCheckAll.isChecked = isChecked }
    }
}