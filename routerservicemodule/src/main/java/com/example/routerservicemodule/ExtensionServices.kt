package com.example.routerservicemodule

import android.content.Context
import com.example.authmodule.routerservice.IAuthProviderService
import com.example.basemodule.router.Router
import com.example.routerservicemodule.app.IAppConfigProviderService
import com.example.routerservicemodule.app.IAppConfigReceiverService
import com.example.searchmodule.routerservice.ISearchProviderService


var authProviderService: IAuthProviderService? = null
var searchProviderService: ISearchProviderService? = null
var appConfigProviderService: IAppConfigProviderService? = null
var appConfigReciverService: IAppConfigReceiverService? = null


fun Context.getAuthProviderService(): IAuthProviderService? {
    if (authProviderService == null)
        authProviderService = Router.getService(IAuthProviderService::class.java)
    return authProviderService
}

fun Context.getSearchProviderService(): ISearchProviderService? {
    if (searchProviderService == null)
        searchProviderService = Router.getService(ISearchProviderService::class.java)
    return searchProviderService
}

fun Context.getAppConfigProviderService(): IAppConfigProviderService? {
    if (appConfigProviderService == null)
        appConfigProviderService = Router.getService(IAppConfigProviderService::class.java)
    return appConfigProviderService
}

fun Context.getAppConfigReceiverService(): IAppConfigReceiverService? {
    if (appConfigReciverService == null)
        appConfigReciverService = Router.getService(IAppConfigReceiverService::class.java)
    return appConfigReciverService
}