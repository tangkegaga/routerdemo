package com.example.routerservicemodule.app

import androidx.fragment.app.Fragment
import com.example.basemodule.context
import com.example.routerservicemodule.getAuthProviderService
import com.example.routerservicemodule.getSearchProviderService

class AppConfigConfigReceiverServiceImp : IAppConfigReceiverService {
    override fun getBoltEntryFragment(): Fragment? {
        return null
    }

    override fun getSearchEntryFragment(): Fragment? {
        return context.getSearchProviderService()?.getEntryFragment()
    }

    override fun getMapEntryFragment(): Fragment? {
        return null
    }

    override fun getAuthEntryFragment(): Fragment? {
        return context.getAuthProviderService()?.getEntryFragment()
    }

}