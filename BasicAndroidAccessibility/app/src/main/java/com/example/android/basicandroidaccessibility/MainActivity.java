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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static Class getClassForResId(int resId) {
        switch (resId) {
            case R.id.activity_content_labeling_button:
                return ContentLabelingActivity.class;
            case R.id.activity_content_grouping_button:
                return ContentGroupingActivity.class;
            case R.id.activity_live_region_button:
                return LiveRegionActivity.class;
            case R.id.activity_expand_touch_area_button:
                return ExpandTouchAreaActivity.class;
            case R.id.activity_insufficient_contrast_button:
                return InsufficientContrastActivity.class;
            default:
                return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchActivity(final View view) {
        Class klass = getClassForResId(view.getId());
        if (klass != null) {
            startActivity(new Intent(MainActivity.this, klass));
        }
    }
}
