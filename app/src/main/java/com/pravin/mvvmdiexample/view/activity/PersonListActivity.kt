package com.pravin.mvvmdiexample.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.BaseModel
import com.pravin.mvvmdiexample.data.model.db.Person
import com.pravin.mvvmdiexample.databinding.ActivityPersonListBinding
import com.pravin.mvvmdiexample.view.adapter.PersonListAdapter
import com.pravin.mvvmdiexample.view.fragment.MyDialogFragment
import com.pravin.mvvmdiexample.view.navigator.PersonListActivityNavigator
import com.pravin.mvvmdiexample.view.navigator.PersonListNavigator
import com.pravin.mvvmdiexample.viewmodel.activity.PersonListViewModel
import kotlinx.android.synthetic.main.activity_person_list.*
import javax.inject.Inject

/**
 * Created by Pravin Divraniya
 */
class PersonListActivity : BaseActivity<ActivityPersonListBinding, PersonListViewModel>(),
        PersonListActivityNavigator,PersonListNavigator{

    @Inject
    protected lateinit var viewModel: PersonListViewModel

    @Inject
    protected lateinit var adapter:PersonListAdapter

    private lateinit var mActivityMainListBinding:ActivityPersonListBinding
    private val INTENT_RESULT_UPDATE_LIST = 0
    private var oldPersonItem:Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        mActivityMainListBinding = getViewDataBinding()
        viewModel.setNavigator(this)

        adapter.addAll(viewModel.getPersonList())
        rc_person_list.layoutManager = LinearLayoutManager(this)
        rc_person_list.adapter = adapter
    }

    override fun getLayoutId() = R.layout.activity_person_list
    override fun getBindingVariable() = BR.listViewModel
    override fun getMyViewModel() = viewModel

    override fun openAddEditPersonScreen(model: BaseModel?) {
        val intent = Intent(this, AddPersonActivity::class.java)
        if(null != model && model is Person) {
            oldPersonItem = model
            intent.putExtra(getString(R.string.intent_person_send_extra),model)
        }
        startActivityForResult(intent,INTENT_RESULT_UPDATE_LIST)
    }

    override fun longClickedItem(item: BaseModel) {
        MyDialogFragment.newInstance(item as Person).show(supportFragmentManager)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            INTENT_RESULT_UPDATE_LIST -> {
                if(resultCode != Activity.RESULT_OK)
                    return
                if(null == data || null == data.extras)
                    return

                val person = data.extras!!.get(getString(R.string.intent_person_receive_extra)) as Person

                val isUpdate = data.extras!!.getBoolean(getString(R.string.intent_is_update_person_extra))

                if(isUpdate){
                    adapter.change(person,oldPersonItem!!)
                    viewModel.updatePerson(person)
                }else{
                    adapter.add(person)
                    viewModel.insertPerson(person)
                }
            }
            else ->{
                //TODO Handle default implementation here
            }
        }
    }
    fun onUpdateClick(item:Person){
        openAddEditPersonScreen(item)
    }
    fun onDeleteClick(item:Person){
        viewModel.deletePerson(item)
        adapter.remove(item)
    }
}
