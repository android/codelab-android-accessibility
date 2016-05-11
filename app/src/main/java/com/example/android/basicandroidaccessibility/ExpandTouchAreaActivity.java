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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class ExpandTouchAreaActivity extends AppCompatActivity {
    private boolean mPlaying = false;
    private ImageButton mToggleImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_touch_area);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mToggleImageButton = (ImageButton) findViewById(R.id.play_pause_toggle_view);
        if (mToggleImageButton != null) {
            setUI();
            mToggleImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlaying = !mPlaying;
                    setUI();
                }
            });
        }
    }

    private void setUI(){
        if (mPlaying) {
            mToggleImageButton.setImageResource(R.drawable.ic_cancel);
            mToggleImageButton.setContentDescription("Cancel");
        } else {
            mToggleImageButton.setImageResource(R.drawable.ic_play_circle_outline);
            mToggleImageButton.setContentDescription("Refresh");
        }
    }
}