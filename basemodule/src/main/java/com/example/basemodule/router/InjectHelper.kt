package com.example.basemodule.router

import com.example.basemodule.BaseModuleApplication
import com.example.basemodule.getAppContext


object InjectHelper {
    private val baseAppContext: BaseModuleApplication get() = getAppContext()
    val iModuleConfig: IModuleConfig = baseAppContext.getModuleConfig()

    fun <T> getInstance(clazz: Class<T>): T? {
        val config = iModuleConfig
        val implementClass = config.getServiceImplementClass(clazz)
        if (implementClass != null) {
            try {
                var ins = config.getServiceInstance(implementClass)
                if (ins == null) {
                    ins = implementClass.newInstance()
                    if (ins != null)
                        config.registerSrvInstance(implementClass, ins)
                }
                return ins
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return null
    }
}