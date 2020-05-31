package com.example.basemodule.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import androidx.fragment.app.DialogFragment

object Router {
    fun open(context: Context?, uri: String) {
        open(context, uri, null)
    }

    fun open(context: Context?, uri: String, bundle: Bundle?, flags: Array<Int>?) {
        val config = InjectHelper.iModuleConfig
        val activityClass = config.getRouterActivity(uri)
        if (activityClass != null) {
            val intent = Intent(context, activityClass)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            flags?.forEach {
                intent.addFlags(it)
            }

            context?.startActivity(intent)
        } else {
            runProcess(uri, bundle)
        }
    }

    fun open(context: Context?, uri: String, bundle: Bundle?) {
        val config = InjectHelper.iModuleConfig
        val activityClass = config.getRouterActivity(uri)
        if (activityClass != null) {
            val intent = Intent(context, activityClass)
            if (bundle != null) {
                intent.putExtras(bundle)
            }

            context?.startActivity(intent)
        } else {
            runProcess(uri, bundle)
        }
    }

    fun openWithNewTaskFlag(context: Context?, uri: String, bundle: Bundle?) {
        val config = InjectHelper.iModuleConfig
        val activityClass = config.getRouterActivity(uri)
        if (activityClass != null) {
            val intent = Intent(context, activityClass)
            intent.flags = FLAG_ACTIVITY_NEW_TASK

            if (bundle != null) {
                intent.putExtras(bundle)
            }

            context?.startActivity(intent)
        } else {
            runProcess(uri, bundle)
        }
    }

    fun openForResult(context: Activity, uri: String, bundle: Bundle?, requestCode: Int) {
        val config = InjectHelper.iModuleConfig
        val activityClass = config.getRouterActivity(uri)
        if (activityClass != null) {
            val intent = Intent(context, activityClass)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            context.startActivityForResult(intent, requestCode)
        } else {
            runProcess(uri, bundle)
        }
    }

    fun openForResult(context: androidx.fragment.app.Fragment, uri: String, bundle: Bundle?, requestCode: Int) {
        val config = InjectHelper.iModuleConfig
        val activityClass = config.getRouterActivity(uri)
        if (activityClass != null) {
            val intent = Intent(context.context, activityClass)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            context.startActivityForResult(intent, requestCode)
        } else {
            runProcess(uri, bundle)
        }
    }

    fun getRouterFragment(uri: String): androidx.fragment.app.Fragment? {
        val config = InjectHelper.iModuleConfig
        val routerFragment = config.getRouterFragment(uri)
        if (routerFragment != null) {
            try {
                val fragmentInstance = routerFragment.newInstance()
                return fragmentInstance
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return null
    }

    fun getRouterDialogFragment(uri: String, bundle: Bundle?): DialogFragment? {
        val config = InjectHelper.iModuleConfig
        val routerFragment = config.getRouterDialogFragment(uri)
        if (routerFragment != null) {
            try {
                val fragmentInstance = routerFragment.newInstance()
                fragmentInstance.arguments = bundle
                return fragmentInstance
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return null
    }

    fun runProcess(uri: String, bundle: Bundle?) {
        val config = InjectHelper.iModuleConfig
        val process = config.getRouterProcess(uri)
        if (process != null) {
            process.process(uri)
        } else {
            //throw RuntimeException("can not execute uri : ")
        }
    }

    fun <T> getService(clazz: Class<T>): T? = InjectHelper.getInstance(clazz)
}