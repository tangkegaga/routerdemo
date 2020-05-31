package com.example.routerdemo.routerservice


import com.example.routerservicemodule.app.IAppConfigProviderService

class AppConfigProviderServiceImp : IAppConfigProviderService {
    override fun getAppName(): String {
        return "Router Demo App"
    }

    override fun getAppVersion(): String {
        return "1.0"
    }

    override fun getAuthBaseURL(): String? {
        return "https://www.rea-group.com/auth/"
    }

    override fun getSearchBaseURL(): String? {
        return "https://www.rea-group.com/Search/"
    }
}