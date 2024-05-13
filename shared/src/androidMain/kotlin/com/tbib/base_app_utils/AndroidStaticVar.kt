package com.tbib.base_app_utils

import android.annotation.SuppressLint
import android.content.Context
import androidx.fragment.app.FragmentActivity

@SuppressLint("StaticFieldLeak")
object AndroidStaticVar {
    @SuppressLint("StaticFieldLeak")
    @JvmStatic
    lateinit var fragmentActivity: FragmentActivity

    @JvmStatic
    lateinit var androidContext: Context
    lateinit var path: String

    @JvmStatic
    var biometricIsSupported = false


}