package com.example.basemodule

import android.app.Application
import com.example.basemodule.router.BaseModuleLifeCycleManager
import com.example.basemodule.router.IModuleConfig

lateinit var context: BaseModuleApplication

fun getAppContext(): BaseModuleApplication {
    return context
}

abstract class BaseModuleApplication : Application() {

    lateinit var lifeCycleManager: BaseModuleLifeCycleManager
    abstract fun initLifeCycleManager(): BaseModuleLifeCycleManager

    override fun onCreate() {
        super.onCreate()
        context = this
        lifeCycleManager = initLifeCycleManager()
        lifeCycleManager.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
        lifeCycleManager.onDestroy()
    }

    fun getModuleConfig(): IModuleConfig = lifeCycleManager.getModuleConfig()
}

