package com.vinhdn.kotlin.components.base.view

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentManager

/**
 * Created by vinh on 5/22/17.
 */
open abstract class BaseActivity : LifecycleActivity(), BaseView{
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
    }

    abstract fun getCurrentFrameLayoutId(): Int
    abstract fun getCurrentFragmentManager(): FragmentManager

    /**
     * Change fragment with option add to back stack with [android.support.v4.app.FragmentManager] using [.getSupportFragmentManager]
     * @param fragment - fragment you want change {[BaseFragment]}
     * *
     * @param hasAddBackStack - option add to backstack
     */
    override fun changeFragment(fragment: BaseFragment, hasAddBackStack: Boolean) {
        var fm = getCurrentFragmentManager()
        if (fm == null) fm = supportFragmentManager
        val transaction = fm
                .beginTransaction()
                .replace(getCurrentFrameLayoutId(), fragment)
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