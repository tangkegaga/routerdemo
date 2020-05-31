package com.example.authmodule.routerservice

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.authmodule.AuthApplication
import com.example.authmodule.ui.AuthEntryFragment

class AuthProviderServiceImp : IAuthProviderService {
    private var checkSessionLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun getEntryFragment(): Fragment? {
        return AuthEntryFragment()
    }

    override fun getSessionState(): Boolean {
        return AuthApplication.token.isNotBlank()
    }

    override fun getToken(): String? {
        return AuthApplication.token
    }

    override fun setSessionObserver(fragment: LifecycleOwner, sessionObserver: Observer<Boolean>) {
        checkSessionLiveData.removeObservers(fragment)
        checkSessionLiveData.observe(fragment, sessionObserver)
    }

    override fun setSessionState(newSession: Boolean) {
        checkSessionLiveData.value = newSession
    }


}