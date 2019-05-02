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

package com.example.android.basicandroidaccessibility;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LiveRegionFragment extends Fragment {

    private TextView mFeedbackTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_region, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        List<String> androidVersions = new ArrayList<>(Arrays.asList(getResources().getStringArray(
                R.array.android_versions)));
        final int correctAnswerIndex = androidVersions.indexOf(getString(R.string.lollipop));
        final RadioGroup radioGroup = view.findViewById(R.id.radio_group);
        mFeedbackTextView = view.findViewById(R.id.feedback_text_view);

        if (radioGroup != null && correctAnswerIndex != -1) {
            for (int i = 0; i < androidVersions.size(); i++) {
                RadioButton radioButton = new RadioButton(getContext());
                radioButton.setText(androidVersions.get(i));
                radioButton.setId(i);
                radioButton.setPadding(36, 36, 36, 36 );
                radioButton.setTextSize(18f);
                radioGroup.addView(radioButton);
            }

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int indexOfCheckedChild = radioGroup.indexOfChild(view.findViewById(checkedId));
                    if (indexOfCheckedChild == correctAnswerIndex) {
                        mFeedbackTextView.setText(R.string.correct);
                        mFeedbackTextView.setBackgroundColor(ContextCompat.getColor(getContext(),
                                R.color.green));
                    } else {
                        mFeedbackTextView.setText(R.string.incorrect);
                        mFeedbackTextView.setBackgroundColor(ContextCompat.getColor(getContext(),
                                R.color.red));
                    }
                }
            });
        }
    }
}
