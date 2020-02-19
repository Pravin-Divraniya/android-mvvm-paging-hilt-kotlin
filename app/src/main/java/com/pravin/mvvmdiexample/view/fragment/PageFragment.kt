package com.pravin.mvvmdiexample.view.fragment

import android.os.Bundle
import android.view.View
import com.pravin.mvvmdiexample.BR

import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.databinding.FragmentPageBinding
import com.pravin.mvvmdiexample.viewmodel.fragment.PageFrgViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [PageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageFragment : BaseFragment<FragmentPageBinding, PageFrgViewModel>() {

    @Inject
    lateinit var mViewModel: PageFrgViewModel

    // TODO: Rename and change types of parameters
    private var mParam1: Int = 0

    override fun getViewModel() = mViewModel
    override fun getBindingVariable() = BR.pagerFrgViewModel
    override fun getLayoutId() = R.layout.fragment_page

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getInt(ARG_PARAM1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.setPageText(mParam1.toString())
    }

    companion object {
        private const val ARG_PARAM1 = "no_of_pages"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment PageFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
