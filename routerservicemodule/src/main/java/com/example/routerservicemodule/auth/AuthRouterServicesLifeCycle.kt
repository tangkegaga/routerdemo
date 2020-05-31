package com.example.routerservicemodule.auth

import android.app.Application
import com.example.authmodule.AuthModuleLifeCycle
import com.example.authmodule.routerservice.IAuthReceiverService
import com.example.basemodule.router.IModuleConfig

class AuthRouterServicesLifeCycle(application: Application) : AuthModuleLifeCycle(application) {
    override fun onCreate(config: IModuleConfig) {
        super.onCreate(config)
        config.registerService(IAuthReceiverService::class.java, AuthReceiverServiceImp::class.java)
    }
}