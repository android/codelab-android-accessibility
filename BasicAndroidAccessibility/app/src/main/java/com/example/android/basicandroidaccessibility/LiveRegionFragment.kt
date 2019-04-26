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
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.*

class LiveRegionFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val androidVersions = ArrayList(Arrays.asList(*resources.getStringArray(
                R.array.android_versions)))
        val correctAnswerIndex = androidVersions.indexOf(getString(R.string.lollipop))
        val radioGroup = view.findViewById<RadioGroup>(R.id.radio_group)
        val feedbackTextView = view.findViewById<TextView>(R.id.feedback_text_view)

        if (radioGroup != null && correctAnswerIndex != -1) {
            for (i in androidVersions.indices) {
                val radioButton = RadioButton(context)
                radioButton.text = androidVersions[i]
                radioButton.id = i
                radioButton.setPadding(36, 36, 36, 36)
                radioButton.textSize = 18f
                radioGroup.addView(radioButton)
            }

            context?.let {
                radioGroup.setOnCheckedChangeListener { _, checkedId ->
                    when (radioGroup.indexOfChild(view.findViewById<View>(checkedId))) {
                        correctAnswerIndex -> {
                            feedbackTextView.setText(R.string.correct)
                            feedbackTextView.setBackgroundColor(ContextCompat.getColor(it,
                                    R.color.green))
                        }
                        else -> {
                            feedbackTextView.setText(R.string.incorrect)
                            feedbackTextView.setBackgroundColor(ContextCompat.getColor(it,
                                    R.color.red))
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_region, container, false)
    }
}