package com.vinhdn.kotlin.modules.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinhdn.kotlin.R
import com.vinhdn.kotlin.components.base.view.BaseFragment
import com.vinhdn.kotlin.modules.home.view.PostFragment
import android.text.Spanned
import android.text.InputFilter
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * Created by vinh on 5/22/17.
 */
open class LoginFragment : BaseFragment() {

    companion object {
        fun getInstance(): LoginFragment {
            return LoginFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_login)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loginEmailBtn?.setOnClickListener({
            view -> changeFragment(PostFragment.getInstance(), true)
        })
        emailEdt?.filters = arrayOf(HIRAGANA_FILTER)
    }

    var HIRAGANA_FILTER: InputFilter = InputFilter { c, start, end, _, _, _ ->
        for (index in start..end - 1) {

            if ('\u3041' > c[index] || c[index] > '\u309e') {
                return@InputFilter ""
            }
        }
        null
    }

    fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
    }
}