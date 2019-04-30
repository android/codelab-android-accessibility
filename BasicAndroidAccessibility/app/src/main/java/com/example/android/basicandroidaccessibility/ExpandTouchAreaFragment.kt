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
import android.widget.ImageButton

class ExpandTouchAreaFragment : Fragment() {

    private lateinit var toggleImageButton: ImageButton
    private var playing: Boolean = false

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expand_touch_area, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toggleImageButton = view.findViewById(R.id.play_pause_toggle_view)

        setUI()
        toggleImageButton.setOnClickListener {
            playing = !playing
            setUI()
        }
    }

    private fun setUI() {
        if (playing) {
            toggleImageButton.setImageResource(R.drawable.ic_cancel)
            toggleImageButton.contentDescription = "Cancel"
        } else {
            toggleImageButton.setImageResource(R.drawable.ic_play_circle_outline)
            toggleImageButton.contentDescription = "Refresh"
        }
    }
}
