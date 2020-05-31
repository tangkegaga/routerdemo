package com.example.routerservicemodule.search

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.basemodule.context
import com.example.routerservicemodule.getAppConfigProviderService
import com.example.routerservicemodule.getAuthProviderService
import com.example.searchmodule.routerservice.ISearchReceiverService

class SearchReceiverServiceImp : ISearchReceiverService {

    override fun getAppName(): String? {
        return context.getAppConfigProviderService()?.getAppName()
    }

    override fun getBaseURL(): String? {
        return context.getAppConfigProviderService()?.getSearchBaseURL()
    }

    override fun getSessionState(): Boolean {
        return context.getAuthProviderService()?.getSessionState() ?: false
    }

    override fun getToken(): String? {
        return context.getAuthProviderService()?.getToken()
    }

    override fun setSessionObserver(
        lifecycleOwner: LifecycleOwner, sessionObserver: Observer<Boolean>
    ) {
        context.getAuthProviderService()?.setSessionObserver(lifecycleOwner, sessionObserver)
    }

}