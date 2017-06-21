package com.vinhdn.kotlin.modules.login

import com.vinhdn.kotlin.components.base.model.BaseModel

/**
 * Created by vinh on 5/22/17.
 */
data class UserModel(val name: String, val email: String, val firstName: String, val lastName: String) : BaseModel()