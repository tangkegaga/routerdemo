package com.example.basemodule.router

import android.app.Activity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

interface IModuleConfig {
  fun registerRouterActivity(uri: String, activityClass: Class<out Activity>)

  fun getRouterActivity(uri: String): Class<out Activity>?

  fun registerRouterActivity(uri: String, routerProcess: IRouterProcess)

  fun getRouterProcess(uri: String): IRouterProcess?

  fun registerFragmentRouter(uri: String, fragmentClass: Class<out Fragment>)
  fun getRouterFragment(uri: String): Class<out Fragment>?

  fun registerDialogFragmentRouter(uri: String, fragmentClass: Class<out DialogFragment>)
  fun getRouterDialogFragment(uri: String): Class<out DialogFragment>?

  fun <T> registerService(serviceClass: Class<T>, implementClass: Class<out T>)

  fun <T> getServiceImplementClass(serviceClass: Class<T>): Class<out T>?

  fun <T> getServiceInstance(serviceClass: Class<T>): T?


  fun <T> registerSrvInstance
          (serviceClass: Class<T>, instance: Any?)

}