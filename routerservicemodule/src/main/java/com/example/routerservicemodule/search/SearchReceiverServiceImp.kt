package com.example.routerservicemodule.search

import com.example.basemodule.context
import com.example.routerservicemodule.getAppConfigProviderService
import com.example.routerservicemodule.getAuthProviderService
import com.example.searchmodule.routerservice.ISearchReceiverService

class SearchReceiverServiceImp : ISearchReceiverService {

    override fun getAppName(): String? {
        return context.getAppConfigProviderService()?.getAppName()
    }

    override fun getSessionState(): Boolean {
        return context.getAuthProviderService()?.getSessionState() ?: false
    }

    override fun getToken(): String? {
        return context.getAuthProviderService()?.getToken()
    }

}