package com.example.routerdemo.routerservice


import com.example.routerdemo.BuildConfig
import com.example.routerservicemodule.app.IAppConfigProviderService

class AppConfigProviderServiceImp : IAppConfigProviderService {
    override fun getAppName(): String {
        return BuildConfig.APPLICATION_ID
    }

    override fun getAppVersion(): String {
        return BuildConfig.VERSION_NAME
    }

    override fun getAuthBaseURL(): String? {
        return BuildConfig.AUTH_ENDPOINT_URL
    }

    override fun getSearchBaseURL(): String? {
        return BuildConfig.SEARCH_ENDPOINT_URL
    }

    override fun getMapBaseURL(): String? {
        return BuildConfig.MAP_ENDPOINT_URL
    }
}