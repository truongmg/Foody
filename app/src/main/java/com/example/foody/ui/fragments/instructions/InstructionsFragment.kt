package com.example.foody.ui.fragments.instructions

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.foody.R
import com.example.foody.models.Result
import com.example.foody.util.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_instructions.view.*

class InstructionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_instructions, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        view.instructions_webView.apply {
            webViewClient = object : WebViewClient() {}
            val websiteUrl: String = myBundle!!.sourceUrl
            Log.d("InstructionsFragment", websiteUrl.replace("http:", "https:"))
            loadUrl(websiteUrl.replace("http:", "https:"))
        }

        return view
    }

}