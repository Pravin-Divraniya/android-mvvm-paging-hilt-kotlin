package com.pravin.mvvmdiexample.view.fragment

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.db.Person
import com.pravin.mvvmdiexample.databinding.FrgMyDialogBinding
import com.pravin.mvvmdiexample.view.activity.BaseActivity
import com.pravin.mvvmdiexample.view.activity.PersonListActivity
import com.pravin.mvvmdiexample.view.navigator.MyDialogFrgNavigator
import com.pravin.mvvmdiexample.viewmodel.fragment.MyDialogFrgViewModel
import javax.inject.Inject

/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class MyDialogFragment : BaseDialogFragment<FrgMyDialogBinding,
        MyDialogFrgViewModel>(),MyDialogFrgNavigator {
    @Inject
    lateinit var mViewModel: MyDialogFrgViewModel
    private var personItem:Person? = null
    private lateinit var mActivity:BaseActivity<*,*>

    override fun getViewModel() = mViewModel
    override fun getBindingVariable() = BR.myDialogViewModel
    override fun getLayoutId() = R.layout.frg_my_dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(null != arguments && null != arguments?.getSerializable(ARG_PERSON))
            personItem = arguments!!.getSerializable(ARG_PERSON) as Person?

        mActivity = getBaseActivity()!!
        mViewModel.setNavigator(this)
    }

    fun show(fragmentManager: FragmentManager) {
        showDialog(fragmentManager, TAG)
    }

    companion object {
        private const val ARG_PERSON = "mPerson"
        val TAG = MyDialogFragment::class.java.simpleName

        fun newInstance(model:Any?): MyDialogFragment {
            val fragment = MyDialogFragment()
            if(null != model && model is Person) {
                val args = Bundle()
                args.putSerializable(ARG_PERSON, model)
                fragment.arguments = args
            }
            return fragment
        }
    }
    override fun onUpdateClick() {
        dismiss()
        if(mActivity is PersonListActivity){
            val act = mActivity as PersonListActivity
            act.onUpdateClick(personItem!!)
        }
    }

    override fun onDeleteClick() {
        dismiss()
        if(mActivity is PersonListActivity){
            val act = mActivity as PersonListActivity
            act.onDeleteClick(personItem!!)
        }
    }
}
