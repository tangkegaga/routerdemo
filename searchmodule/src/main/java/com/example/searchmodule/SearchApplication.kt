package com.example.searchmodule

import android.content.Context
import com.example.basemodule.router.Router
import com.example.searchmodule.routerservice.ISearchReceiverService

class AuthApplication {

    companion object {
        var searchReceiverService: ISearchReceiverService? = null
    }

}


internal fun Context.getSearchReceiverService(): ISearchReceiverService? {
    if (AuthApplication.searchReceiverService == null) {
        AuthApplication.searchReceiverService = Router.getService(ISearchReceiverService::class.java)
    }
    return AuthApplication.searchReceiverService
}

