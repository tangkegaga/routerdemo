package com.example.searchmodule.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.searchmodule.R
import com.example.searchmodule.getSearchReceiverService
import kotlinx.android.synthetic.main.fragment_search_entry.*


class SearchEntryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_entry, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //to show that we can get url from other module
        tv_endpoint.text = context?.getSearchReceiverService()?.getBaseURL()

        //check if user sign in or a guest
        tv_session_state.text =
            if (context?.getSearchReceiverService()?.getSessionState() ?: false)
                "I am logged in"
            else "You are a guest"

        //monitor the status change
        context?.getSearchReceiverService()?.setSessionObserver(this, Observer {
            tv_session_state.text =
                if (context?.getSearchReceiverService()?.getSessionState() ?: false)
                    "I am logged in"
                else "You are a guest"
        })

    }
}