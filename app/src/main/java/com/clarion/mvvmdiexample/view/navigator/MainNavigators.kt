package com.clarion.mvvmdiexample.view.navigator

import com.clarion.mvvmdiexample.data.model.BaseModel
import com.clarion.mvvmdiexample.data.model.api.GalleryImages

/**
 * Created by Pravin Divraniya on 11/29/2017.
 */

/**
 * Created by Pravin Divraniya on 10/9/2017.
 */
interface AddPersonActivityNavigator : BaseNavigator {
    fun openListActivity(model: BaseModel)
}

/**
 * Created by Pravin Divraniya on 11/20/2017.
 */
interface MainActivityNavigator: BaseNavigator

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
interface PersonListActivityNavigator : BaseNavigator {
    fun openAddEditPersonScreen(model: BaseModel?)
}

/**
 * Created by Pravin Divraniya on 11/21/2017.
 */
interface RemoteDataFragmentNavigator : BaseNavigator

/**
 * Created by Pravin Divraniya on 11/29/2017.
 */
interface MyDialogFrgNavigator:BaseNavigator{
    fun onUpdateClick()
    fun onDeleteClick()
}
/**
 * Created by Pravin Divraniya on 12/15/2017.
 */
interface PagerActivityNavigator : BaseNavigator

/**
 * Created by Pravin Divraniya on 12/19/2017.
 */
interface PageFrgNavigator : BaseNavigator

/**
 * Created by Pravin Divraniya on 04/10/2018.
 */
interface GalleryFragmentNavigator : BaseNavigator{
    fun onItemCheck(isChecked: Boolean,item:GalleryImages)
}
/**
 * Created by Pravin Divraniya on 04/24/2018.
 */
interface MainFrgNavigator:BaseNavigator{
    fun openDBActivity()
    fun openRemoteDataFragment()
    fun openViewPagerActivity()
    fun openGalleryViewFragment()
}