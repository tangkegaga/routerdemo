package com.example.routerservicemodule.app

import androidx.fragment.app.Fragment

interface IAppReceiverConfiguration {
    fun getBoltEntryFragment(): Fragment?
    fun getSearchEntryFragment(): Fragment?
    fun getMapEntryFragment(): Fragment?
    fun getAuthEntryFragment(): Fragment?
}