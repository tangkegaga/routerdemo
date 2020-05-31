package com.example.searchmodule.routerservice

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ISearchReceiverService {
    fun getAppName(): String? = ""
    fun getBaseURL(): String? = ""

    fun getSessionState(): Boolean = false
    fun getToken(): String? = ""
    fun setSessionObserver(lifecycleOwner: LifecycleOwner, sessionObserver: Observer<Boolean>)
}