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

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InsufficientContrastActivity extends AppCompatActivity {

    private RelativeLayout mLoremIpsumContainer;
    private TextView mLoremIpsumTitle;
    private TextView mLoremIpsumText;
    private FloatingActionButton mAddItemFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insufficient_contrast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLoremIpsumContainer = (RelativeLayout) findViewById(R.id.lorem_ipsum_container);
        mLoremIpsumTitle = (TextView) findViewById(R.id.lorem_ipsum_title);
        mLoremIpsumText = (TextView) findViewById(R.id.lorem_ipsum_text);
        mAddItemFab = (FloatingActionButton) findViewById(R.id.add_item_fab);

        CheckBox colorContrastCheckbox = (CheckBox) findViewById(R.id.color_contrast_checkbox);
        if (colorContrastCheckbox != null) {
            colorContrastCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        useHighContrast();
                    } else {
                        useLowContrast();
                    }
                }
            });
        }
    }

    private void useHighContrast() {
        mLoremIpsumContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        mLoremIpsumTitle.setTextColor(ContextCompat.getColor(this, R.color.medium_grey));
        mLoremIpsumText.setTextColor(ContextCompat.getColor(this, R.color.dark_grey));
        mAddItemFab.setBackgroundTintList(ContextCompat.getColorStateList(this,
                R.color.colorPrimaryDark));
    }

    private void useLowContrast() {
        mLoremIpsumContainer.setBackgroundColor(ContextCompat.getColor(this,
                R.color.very_light_grey));
        mLoremIpsumTitle.setTextColor(ContextCompat.getColor(this, R.color.light_grey));
        mLoremIpsumText.setTextColor(ContextCompat.getColor(this, R.color.medium_grey));
        mAddItemFab.setBackgroundTintList(ContextCompat.getColorStateList(this,
                R.color.colorPrimaryLight));
    }
}
