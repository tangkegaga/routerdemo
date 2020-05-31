package com.example.authmodule.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.authmodule.AuthApplication
import com.example.authmodule.R
import com.example.authmodule.getAuthProviderService
import com.example.authmodule.getAuthReceiverService
import kotlinx.android.synthetic.main.fragment_auth_entry.*

class AuthEntryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth_entry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //to show that we can get url from other module
        tv_endpoint.text = context?.getAuthReceiverService()?.getBaseURL()

        bt_signin.setOnClickListener {
            AuthApplication.token = "Bear abcdefg"
            context?.getAuthProviderService()?.setSessionState(true)

            Toast.makeText(context, "set token to ${AuthApplication.token}", Toast.LENGTH_LONG)
                .show()
        }

        bt_signout.setOnClickListener {
            AuthApplication.token = ""
            context?.getAuthProviderService()?.setSessionState(false)

            Toast.makeText(context, "clear token", Toast.LENGTH_LONG)
                .show()
        }
    }
}