package com.example.authmodule

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.authmodule.routerservice.AuthProviderServiceImp
import com.example.authmodule.routerservice.IAuthProviderService
import com.example.basemodule.router.BaseModuleLifeCycle
import com.example.basemodule.router.IModuleConfig

open class AuthModuleLifeCycle(application: Application) : BaseModuleLifeCycle(application) {

    override fun onCreate(config: IModuleConfig) {
        config.registerService(IAuthProviderService::class.java, AuthProviderServiceImp::class.java)
    }
}
