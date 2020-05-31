package com.example.basemodule.router

import android.app.Application

abstract class BaseModuleLifeCycle(val application: Application) : IModuleLifeCycle {

    override fun onCreate(config: IModuleConfig) {
    }

    override fun onDestroy() {
    }
}