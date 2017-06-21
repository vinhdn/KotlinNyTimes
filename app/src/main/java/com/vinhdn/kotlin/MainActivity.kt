package com.vinhdn.kotlin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.widget.TextView
import com.vinhdn.kotlin.components.base.view.BaseActivity
import com.vinhdn.kotlin.modules.login.LoginFragment

class MainActivity : BaseActivity() {
    override fun getCurrentFrameLayoutId(): Int {
        return R.id.framelayout
    }

    override fun getCurrentFragmentManager(): FragmentManager {
        return supportFragmentManager
    }

    private var mTextMessage: TextView? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mTextMessage!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mTextMessage!!.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mTextMessage!!.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextMessage = findViewById(R.id.message) as TextView
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if(savedInstanceState == null){
            changeFragment(LoginFragment.getInstance(), false)
        }
    }
}
