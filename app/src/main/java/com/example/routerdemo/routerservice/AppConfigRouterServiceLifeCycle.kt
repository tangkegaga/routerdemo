package com.example.routerdemo.routerservice

import android.app.Application
import com.example.basemodule.router.IModuleConfig
import com.example.routerservicemodule.app.AppConfigReceiverServiceLifeCycle

class AppConfigRouterServiceLifeCycle(application: Application) : AppConfigReceiverServiceLifeCycle(application) {
    override fun onCreate(config: IModuleConfig) {
        super.onCreate(config)

    }
}