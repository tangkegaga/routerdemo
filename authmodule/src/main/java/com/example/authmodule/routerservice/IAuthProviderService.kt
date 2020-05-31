package com.example.authmodule.routerservice

import androidx.fragment.app.Fragment

interface IAuthProviderService {

    //check if user is logged in or not
    fun getSessionState(): Boolean
    fun getToken(): String
    fun getEntryFragment(): Fragment? = null

}