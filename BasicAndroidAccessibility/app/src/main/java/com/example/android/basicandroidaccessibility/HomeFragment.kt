/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.basicandroidaccessibility

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonContentLabeling = view.findViewById<Button>(R.id.content_labeling_button)
        buttonContentLabeling.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_contentLabelingFragment, null))

        val buttonContentGrouping = view.findViewById<Button>(R.id.content_grouping_button)
        buttonContentGrouping.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_contentGroupingFragment, null))

        val buttonLiveRegion = view.findViewById<Button>(R.id.live_region_button)
        buttonLiveRegion.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_liveRegionFragment, null))

        val buttonExpandTouchArea = view.findViewById<Button>(R.id.expand_touch_area_button)
        buttonExpandTouchArea.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_expandTouchAreaFragment, null))

        val buttonInsufficientContrast = view.findViewById<Button>(R.id.insufficient_contrast_button)
        buttonInsufficientContrast.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_insufficientContrastFragment, null))

    }
}



