package com.example.searchmodule

import android.app.Application
import com.example.basemodule.router.BaseModuleLifeCycle
import com.example.basemodule.router.IModuleConfig
import com.example.searchmodule.routerservice.ISearchProviderService
import com.example.searchmodule.routerservice.SearchProviderServiceImp

open class SearchModuleLifeCycle(application: Application) : BaseModuleLifeCycle(application) {
    override fun onCreate(config: IModuleConfig) {
        super.onCreate(config)
        config.registerService(
            ISearchProviderService::class.java,
            SearchProviderServiceImp::class.java
        )
    }
}