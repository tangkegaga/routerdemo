package com.example.authmodule

import android.content.Context
import com.example.authmodule.routerservice.IAuthProviderService
import com.example.authmodule.routerservice.IAuthReceiverService
import com.example.basemodule.router.Router

class AuthApplication {

    companion object {
        var authReceiverService: IAuthReceiverService? = null
        var authProviderService: IAuthProviderService? = null
        var token: String = ""
    }

}


internal fun Context.getAuthReceiverService(): IAuthReceiverService? {
    if (AuthApplication.authReceiverService == null) {
        AuthApplication.authReceiverService = Router.getService(IAuthReceiverService::class.java)
    }
    return AuthApplication.authReceiverService
}


internal fun Context.getAuthProviderService(): IAuthProviderService? {
    if (AuthApplication.authProviderService == null) {
        AuthApplication.authProviderService = Router.getService(IAuthProviderService::class.java)
    }
    return AuthApplication.authProviderService
}