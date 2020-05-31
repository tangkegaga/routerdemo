package com.example.basemodule.router

import android.app.Activity
import androidx.fragment.app.DialogFragment

class ModuleConfig : IModuleConfig {


    override fun <T> getServiceInstance(serviceClass: Class<T>): T? {
            if (serviceInstances[serviceClass] != null)
                return serviceInstances[serviceClass] as T
            else
                return null
    }

    override fun <T> registerSrvInstance(serviceClass: Class<T>, instance: Any?) {
        serviceInstances.put(serviceClass, instance)
    }

    private val serviceInstances: MutableMap<Class<*>, Any?>


    private val activityRouterConfig: MutableMap<String, Class<out Activity>>
    private val routerProcessConfig: MutableMap<String, IRouterProcess>
    private val fragmentRouterConfig: MutableMap<String, Class<out androidx.fragment.app.Fragment>>
    private val dialogFragmentRouterConfig: MutableMap<String, Class<out DialogFragment>>
    private val serviceConfig: MutableMap<Class<*>, Class<*>>

    init {
        activityRouterConfig = HashMap<String, Class<out Activity>>()
        routerProcessConfig = HashMap<String, IRouterProcess>()
        serviceConfig = HashMap<Class<*>, Class<*>>()
        fragmentRouterConfig = HashMap<String, Class<out androidx.fragment.app.Fragment>>()
        dialogFragmentRouterConfig = HashMap<String, Class<out DialogFragment>>()
        serviceInstances = HashMap<Class<*>, Any?>()
    }

    override fun registerRouterActivity(uri: String, activityClass: Class<out Activity>) {
        activityRouterConfig[uri] = activityClass
    }

    override fun getRouterActivity(uri: String): Class<out Activity>? {
        return activityRouterConfig[uri]
    }

    override fun registerRouterActivity(uri: String, routerProcess: IRouterProcess) {
        routerProcessConfig.put(uri, routerProcess)
    }

    override fun getRouterProcess(uri: String): IRouterProcess? {
        return routerProcessConfig[uri]
    }

    override fun <T> registerService(serviceClass: Class<T>, implementClass: Class<out T>) {
        serviceConfig.put(serviceClass, implementClass)
    }

    override fun <T> getServiceImplementClass(serviceClass: Class<T>): Class<out T>? {
        if (serviceConfig[serviceClass] != null)
            return serviceConfig[serviceClass] as Class<out T>
        else
            return null
    }

    override fun registerFragmentRouter(uri: String, fragmentClass: Class<out androidx.fragment.app.Fragment>) {
        fragmentRouterConfig[uri] = fragmentClass
    }

    override fun getRouterFragment(uri: String): Class<out androidx.fragment.app.Fragment>? {
        return fragmentRouterConfig[uri]
    }

    override fun registerDialogFragmentRouter(uri: String, fragmentClass: Class<out DialogFragment>) {
        dialogFragmentRouterConfig[uri] = fragmentClass
    }

    override fun getRouterDialogFragment(uri: String): Class<out DialogFragment>? {
        return dialogFragmentRouterConfig[uri]
    }
}