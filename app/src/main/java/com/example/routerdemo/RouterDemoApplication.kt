package com.example.routerdemo


import com.example.basemodule.BaseModuleApplication
import com.example.basemodule.router.BaseModuleLifeCycleManager
import com.example.routerdemo.routerservice.ModuleLifeCycleManager

class RouterDemoApplication : BaseModuleApplication() {
    override fun initLifeCycleManager(): BaseModuleLifeCycleManager {
        return ModuleLifeCycleManager(this)
    }
}