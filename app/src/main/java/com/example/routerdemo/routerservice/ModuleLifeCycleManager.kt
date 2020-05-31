package com.example.routerdemo.routerservice

import android.app.Application
import com.example.basemodule.router.BaseModuleLifeCycleManager
import com.example.routerservicemodule.auth.AuthRouterServicesLifeCycle
import com.example.routerservicemodule.search.SearchRouterServicesLifeCycle


internal class ModuleLifeCycleManager(application: Application) :
    BaseModuleLifeCycleManager(application) {

    init {
        moduleLifeCycleList.add(AppConfigRouterServiceLifeCycle(application))
        moduleLifeCycleList.add(AuthRouterServicesLifeCycle(application))
        moduleLifeCycleList.add(SearchRouterServicesLifeCycle(application))
    }

}