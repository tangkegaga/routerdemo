package com.example.routerdemo.routerservice

import android.app.Application
import com.example.basemodule.router.BaseModuleLifeCycleManager
import com.example.routerservicemodule.auth.AuthRouterServicesLifeCycle


internal class ModuleLifeCycleManager(application: Application) :
    BaseModuleLifeCycleManager(application) {

    init {
        moduleLifeCycleList.add(AuthRouterServicesLifeCycle(application))
    }

}