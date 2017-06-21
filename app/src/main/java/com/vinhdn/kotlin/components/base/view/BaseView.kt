package com.vinhdn.kotlin.components.base.view

/**
 * Created by vinh on 5/24/17.
 */
interface BaseView {
    fun onRefresh(isRefresh : Boolean)
    fun changeFragment(fragment: BaseFragment, hasAddBackStack: Boolean)
}