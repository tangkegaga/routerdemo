package com.example.routerdemo.routerservice

import android.app.Application
import com.example.authmodule.routerservice.AuthProviderServiceImp
import com.example.authmodule.routerservice.IAuthProviderService
import com.example.basemodule.router.IModuleConfig
import com.example.routerservicemodule.app.AppConfigReceiverServiceLifeCycle
import com.example.routerservicemodule.app.IAppConfigProviderService

class AppConfigRouterServiceLifeCycle(application: Application) : AppConfigReceiverServiceLifeCycle(application) {
    override fun onCreate(config: IModuleConfig) {
        super.onCreate(config)
        config.registerService(IAppConfigProviderService::class.java, AppConfigProviderServiceImp::class.java)
    }
}