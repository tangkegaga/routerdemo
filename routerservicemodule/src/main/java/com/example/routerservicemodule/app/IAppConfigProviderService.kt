package com.example.routerservicemodule.app

interface IAppConfigProviderService {

    //Presentation
    fun getAppName(): String
    fun getAppVersion(): String
    fun getAuthBaseURL(): String?=null
    fun getSearchBaseURL(): String?=null
    fun getMapBaseURL(): String?=null
/*

    fun getBoltBaseURL(): String?=null
    fun getMapBaseURL(): String?=null
    fun getSearchBaseURL(): String?=null

    fun getTermAndCond(): String? = null
    fun getPrivacyUrl(): String? = null

    fun getAppLanguage(): String
    fun getAppTenant(): String

    fun getAPIKEY(): String? = null
    fun getAPISECRET(): String? = null


*/

}