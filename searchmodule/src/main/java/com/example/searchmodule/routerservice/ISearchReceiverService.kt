package com.example.searchmodule.routerservice

interface ISearchReceiverService {
    fun getAppName(): String? = ""
    fun getFlavor(): String? = ""
    fun getBaseURL(): String? = ""

    fun getSessionState(): Boolean = false
    fun getToken(): String? = ""
}