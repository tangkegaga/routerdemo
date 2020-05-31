package com.example.routerservicemodule.app

import android.app.Application
import com.example.basemodule.router.BaseModuleLifeCycle
import com.example.basemodule.router.IModuleConfig

open class AppConfigReceiverServiceLifeCycle(application: Application) : BaseModuleLifeCycle(application) {
    override fun onCreate(config: IModuleConfig) {
        config.registerService(IAppConfigReceiverService::class.java, AppConfigConfigReceiverServiceImp::class.java)
    }
}