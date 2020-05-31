package com.example.searchmodule.routerservice

import androidx.fragment.app.Fragment
import com.example.searchmodule.ui.SearchEntryFragment

class SearchProviderServiceImp : ISearchProviderService {

    override fun getEntryFragment(): Fragment? {
        return SearchEntryFragment()
    }
}