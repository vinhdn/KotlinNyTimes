package com.vinhdn.kotlin.components.base.view

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinhdn.kotlin.components.base.view.BaseActivity


/**
 * Created by vinh on 5/22/17.
 */
open abstract class BaseFragment : LifecycleFragment(), BaseView{

    protected lateinit var baseActivity : BaseActivity

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseActivity = activity as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun changeFragment(fragment: BaseFragment, hasAddBackStack: Boolean) {
        if (getView() == null) return
        var fm = activity.getSupportFragmentManager()
        if (activity is BaseActivity) {
            fm = (activity as BaseActivity).getCurrentFragmentManager()
        }
        var transaction = fm.beginTransaction()
                .add((activity as BaseActivity).getCurrentFrameLayoutId(), fragment)
        if (hasAddBackStack) {
            transaction.addToBackStack(null).commitAllowingStateLoss()
            return
        }
        transaction.commitAllowingStateLoss()
    }

    override fun onRefresh(isRefresh: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
