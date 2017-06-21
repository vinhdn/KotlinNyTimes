package com.vinhdn.kotlin.components.base.presenter;

import com.vinhdn.kotlin.components.base.view.BaseView

interface Presenter<V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}