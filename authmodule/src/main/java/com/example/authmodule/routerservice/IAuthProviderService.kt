package com.example.authmodule.routerservice

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface IAuthProviderService {
    fun getEntryFragment(): Fragment? = null

    //check if user is logged in or not
    fun getSessionState(): Boolean
    fun setSessionState(newSession: Boolean)
    fun getToken(): String?
    fun setSessionObserver(lifecycleOwner: LifecycleOwner, sessionObserver: Observer<Boolean>)
}