// Copyright 2016 Google Inc.
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//      http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.example.android.basicandroidaccessibility;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiveRegionActivity extends AppCompatActivity {
    private TextView mFeedbackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_region);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);

        List<String> androidVersions = new ArrayList<>(Arrays.asList(getResources().getStringArray(
                R.array.android_versions)));
        final int correctAnswerIndex = androidVersions.indexOf(getString(R.string.lollipop));
        final RadioGroup radioGroup = findViewById(R.id.radio_group);
        mFeedbackTextView = findViewById(R.id.feedback_text_view);

        if (radioGroup != null && correctAnswerIndex != -1) {
            for (int i = 0; i < androidVersions.size(); i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(androidVersions.get(i));
                radioButton.setId(i);
                radioButton.setPadding(36, 36, 36, 36 );
                radioButton.setTextSize(18f);
                radioGroup.addView(radioButton);
            }

            final Context context = this;
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int indexOfCheckedChild = radioGroup.indexOfChild(findViewById(checkedId));
                    if (indexOfCheckedChild == correctAnswerIndex) {
                        mFeedbackTextView.setText(R.string.correct);
                        mFeedbackTextView.setBackgroundColor(ContextCompat.getColor(context,
                                R.color.green));
                    } else {
                        mFeedbackTextView.setText(R.string.incorrect);
                        mFeedbackTextView.setBackgroundColor(ContextCompat.getColor(context,
                                R.color.red));
                    }
                }
            });
        }
    }
}
