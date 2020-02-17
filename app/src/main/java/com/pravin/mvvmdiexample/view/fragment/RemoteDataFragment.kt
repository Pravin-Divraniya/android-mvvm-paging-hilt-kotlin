package com.pravin.mvvmdiexample.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.BaseModel
import com.pravin.mvvmdiexample.data.model.api.Articles
import com.pravin.mvvmdiexample.data.model.api.Photo
import com.pravin.mvvmdiexample.databinding.FrgRemotedatamodelListBinding
import com.pravin.mvvmdiexample.view.activity.BaseActivity
import com.pravin.mvvmdiexample.view.adapter.RemoteDataAdapter
import com.pravin.mvvmdiexample.view.navigator.RemoteDataFragmentNavigator
import com.pravin.mvvmdiexample.view.navigator.RemoteItemNavigator
import com.pravin.mvvmdiexample.viewmodel.fragment.RemoteDataViewModel
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
/**
 * Created by Pravin Divraniya
 */
class RemoteDataFragment : BaseFragment<FrgRemotedatamodelListBinding,
        RemoteDataViewModel>(),RemoteDataFragmentNavigator,RemoteItemNavigator {
    @Inject
    protected lateinit var mViewModel: RemoteDataViewModel

    @Inject
    protected lateinit var adapter: RemoteDataAdapter

    @Inject
    protected lateinit var compositeDisposable:CompositeDisposable

    override fun getViewModel() = mViewModel

    override fun getBindingVariable() = BR.rDataViewModel
    override fun getLayoutId() = R.layout.frg_remotedatamodel_list

    private var apiKey = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.setNavigator(this)
        if (arguments != null) {
            apiKey = arguments!!.getString(ARG_API_KEY).toString()
        }
    }

    private fun initNetworkCalls(){
        if(getBaseActivity()!!.isNetworkConnected()){
//            getPhotoList()
//            getAlbumList()
//            getPostList()
//            getCommentList()
            getNewsList()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.adapter.set(adapter)
        initNetworkCalls()
    }

    private fun getNewsList() {
        if(!(activity is BaseActivity<*,*>))
            return
        showLoading()
        val disposable = mViewModel.getNews(apiKey)
                .flatMapIterable { t->t.articles}
                .toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listItem -> this.adapter.add(listItem)
                },{
                    _ -> Toast.makeText(getBaseActivity(),"Error in news list",Toast.LENGTH_LONG).show()
                    hideLoading()
                },{
                    Toast.makeText(getBaseActivity(),"Completed news list stream",Toast.LENGTH_LONG).show()
                    hideLoading()
                },{
                    t -> t.request(15000)
                })

        compositeDisposable.add(disposable)
    }

    private fun getCommentList() {
        val disposable = mViewModel.getComments()
                .toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{
                    _ -> Toast.makeText(getBaseActivity(),"Error in comment list",Toast.LENGTH_LONG).show()
                },{
                    Toast.makeText(getBaseActivity(),"Completed comment list stream",Toast.LENGTH_LONG).show()
                })

        compositeDisposable.add(disposable)
    }

    private fun getPostList() {
        val disposable = mViewModel.getPosts()
                .toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{
                    _ -> Toast.makeText(getBaseActivity(),"Error in post list",Toast.LENGTH_LONG).show()
                },{
                    Toast.makeText(getBaseActivity(),"Completed post list stream",Toast.LENGTH_LONG).show()
                })

        compositeDisposable.add(disposable)
    }

    private fun getAlbumList() {
        val disposable = mViewModel.getAlbums()
                .toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{
                    _ -> Toast.makeText(getBaseActivity(),"Error in Album list",Toast.LENGTH_LONG).show()
                },{
                    Toast.makeText(getBaseActivity(),"Completed album list stream",Toast.LENGTH_LONG).show()
                })
        compositeDisposable.add(disposable)
    }

    private fun getPhotoList() {
        showLoading()
        val disposable = mViewModel.getPhotos()
                .toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listItems -> this.adapter.addAll(listItems)
                }, {
                    error -> Toast.makeText(getBaseActivity(),error.message,Toast.LENGTH_LONG).show()
                    hideLoading()
                }, {
                    Toast.makeText(getBaseActivity(),"Completed photo list stream",Toast.LENGTH_LONG).show()
                    hideLoading()
                })
        compositeDisposable.add(disposable)
    }
    override fun onDestroyView() {
        compositeDisposable.dispose()
        super.onDestroyView()
    }

    override fun onDetach() {
        compositeDisposable.clear()
        super.onDetach()
    }
    companion object {

        private val ARG_API_KEY = "api-key"
        val TAG = RemoteDataFragment::class.java.simpleName

        @JvmStatic
        fun newInstance(apiKey: String): RemoteDataFragment {
            val fragment = RemoteDataFragment()
            val args = Bundle()
            args.putString(ARG_API_KEY, apiKey)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onRemoteItemClick(item: BaseModel, view: View?) {
        if(null == view)
            return
        var url:String
        when(item){
            is Articles -> {
                url = item.url
            }
            is Photo -> {
                url = item.url!!
            }
            else -> {
                url = ""
            }
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        view.context.startActivity(intent)
    }
}
