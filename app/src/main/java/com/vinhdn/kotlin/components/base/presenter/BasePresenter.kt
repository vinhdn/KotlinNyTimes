package com.vinhdn.kotlin.components.base.presenter

import com.vinhdn.kotlin.components.base.view.BaseView
import java.lang.ref.WeakReference

/**
 * Created by vinh on 5/24/17.
 */
open class BasePresenter<V : BaseView> : Presenter<V>{
    private var weakReference: WeakReference<V>? = null

    override fun attachView(view: V) {
        if (!isViewAttached) {
            weakReference = WeakReference(view)
        }
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
    }

    val view: V?
        get() = weakReference?.get()

    val isViewAttached: Boolean
        get() = weakReference != null && weakReference!!.get() != null
}