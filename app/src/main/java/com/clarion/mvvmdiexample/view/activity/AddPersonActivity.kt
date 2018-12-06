package com.clarion.mvvmdiexample.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.R
import com.clarion.mvvmdiexample.data.model.BaseModel
import com.clarion.mvvmdiexample.data.model.db.Person
import com.clarion.mvvmdiexample.databinding.ActivityAddPersonBinding
import com.clarion.mvvmdiexample.view.navigator.AddPersonActivityNavigator
import com.clarion.mvvmdiexample.viewmodel.activity.AddPersonViewModel
import javax.inject.Inject


class AddPersonActivity : BaseActivity<ActivityAddPersonBinding, AddPersonViewModel>(),
        AddPersonActivityNavigator {
    @Inject
    protected lateinit var viewModel: AddPersonViewModel

    private lateinit var binding:ActivityAddPersonBinding
    private var isUpdate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init(){
        binding = getViewDataBinding()
        viewModel.setNavigator(this)

        if(intent.hasExtra(getString(R.string.intent_person_send_extra))){
            isUpdate = true
            val person:Person = intent.extras
                    .getSerializable(getString(R.string.intent_person_send_extra)) as Person
            viewModel.setPerson(person)
        }else
            isUpdate = false
    }

    override fun getLayoutId() = R.layout.activity_add_person
    override fun getBindingVariable() = BR.addViewmodel
    override fun getMyViewModel() = viewModel

    override fun openListActivity(model: BaseModel) {
        hideKeyboard()
        val person = model as Person
        val intent = Intent()
        val bundle = Bundle()
        bundle.putSerializable(getString(R.string.intent_person_receive_extra)
                ,person)
        bundle.putBoolean(getString(R.string.intent_is_update_person_extra)
                ,isUpdate)
        intent.putExtras(bundle)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}
