package com.example.android.basicandroidaccessibility


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val buttonContentLabeling = view.findViewById<Button>(R.id.content_labeling_button)
        buttonContentLabeling?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_contentLabelingFragment, null)
        }
        val buttonContentGrouping = view.findViewById<Button>(R.id.content_grouping_button)
        buttonContentGrouping?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_contentGroupingFragment, null)
        }
        val buttonLiveRegion = view.findViewById<Button>(R.id.live_region_button)
        buttonLiveRegion?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_liveRegionFragment, null)
        }
        val buttonExpandTouchArea = view.findViewById<Button>(R.id.expand_touch_area_button)
        buttonExpandTouchArea?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_expandTouchAreaFragment, null)
        }
        val buttonInsufficientContrast = view.findViewById<Button>(R.id.insufficient_contrast_button)
        buttonInsufficientContrast?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_insufficientContrastFragment, null)
        }


    }
}



