package com.example.routerservicemodule.search

import android.app.Application
import com.example.basemodule.router.IModuleConfig
import com.example.searchmodule.SearchModuleLifeCycle
import com.example.searchmodule.routerservice.ISearchProviderService
import com.example.searchmodule.routerservice.ISearchReceiverService
import com.example.searchmodule.routerservice.SearchProviderServiceImp

class SearchRouterServicesLifeCycle(application: Application) : SearchModuleLifeCycle(application) {
    override fun onCreate(config: IModuleConfig) {
        super.onCreate(config)
        config.registerService(
            ISearchReceiverService::class.java,
            SearchReceiverServiceImp::class.java
        )
    }
}