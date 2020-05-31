package com.example.basemodule.router

import com.example.basemodule.router.IModuleConfig

interface IModuleLifeCycle {
  fun onCreate(config: IModuleConfig)
  fun onDestroy()
}