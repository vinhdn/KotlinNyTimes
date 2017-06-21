package com.vinhdn.kotlin.components.base.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel

/**
 * Created by vinh on 5/22/17.
 */
abstract class BaseViewModel(application: Application) : AndroidViewModel(application)