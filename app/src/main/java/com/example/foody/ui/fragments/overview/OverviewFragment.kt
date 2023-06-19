package com.example.foody.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import coil.load
import com.example.foody.R
import com.example.foody.models.Result
import com.example.foody.util.Constants
import com.example.foody.util.Constants.Companion.RECIPE_RESULT_KEY
import kotlinx.android.synthetic.main.fragment_overview.view.*
import org.jsoup.Jsoup

class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT_KEY)

        view.apply {
            main_imageView.load(myBundle?.image)
            title_textView.text = myBundle?.title
            likes_textView.text = myBundle?.aggregateLikes.toString()
            time_textView.text = myBundle?.readyInMinutes.toString()
            myBundle?.summary.let { html ->
                val summary = Jsoup.parse(html).text()
                summary_textView.text = summary
            }

            if (myBundle?.vegan == true) {
                vegan_imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                vegan_textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (myBundle?.vegetarian == true) {
                vegetarian_imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                vegetarian_textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (myBundle?.glutenFree == true) {
                gluten_free_imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                gluten_free_textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (myBundle?.dairyFree == true) {
                dairy_free_imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                dairy_free_textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (myBundle?.veryHealthy == true) {
                healthy_imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                healthy_textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }

            if (myBundle?.cheap == true) {
                cheap_imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
                cheap_textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
            }
        }



        return view
    }

}