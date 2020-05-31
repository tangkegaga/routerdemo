package com.example.routerservicemodule.auth

import com.example.authmodule.routerservice.IAuthReceiverService
import com.example.basemodule.context
import com.example.routerservicemodule.getAppConfigProviderService

class AuthReceiverServiceImp : IAuthReceiverService {
    override fun getAppName(): String? {
        return context.getAppConfigProviderService()?.getAppName()
    }

    override fun getBaseURL(): String? {
        return context.getAppConfigProviderService()?.getBaseURL()
    }
}