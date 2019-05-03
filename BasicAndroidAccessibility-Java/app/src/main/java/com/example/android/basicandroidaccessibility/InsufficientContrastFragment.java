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
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class InsufficientContrastFragment extends Fragment {

    private RelativeLayout mLoremIpsumContainer;
    private TextView mLoremIpsumTitle;
    private TextView mLoremIpsumText;
    private FloatingActionButton mAddItemFab;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insufficient_contrast, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        mLoremIpsumContainer = view.findViewById(R.id.lorem_ipsum_container);
        mLoremIpsumTitle = view.findViewById(R.id.lorem_ipsum_title);
        mLoremIpsumText = view.findViewById(R.id.lorem_ipsum_text);
        mAddItemFab = view.findViewById(R.id.add_item_fab);

        CheckBox colorContrastCheckbox = view.findViewById(R.id.color_contrast_checkbox);
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
        mLoremIpsumContainer.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white));
        mLoremIpsumTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.medium_grey));
        mLoremIpsumText.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey));
        mAddItemFab.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(),
                R.color.colorPrimaryDark));
    }

    private void useLowContrast() {
        mLoremIpsumContainer.setBackgroundColor(ContextCompat.getColor(requireContext(),
                R.color.very_light_grey));
        mLoremIpsumTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.light_grey));
        mLoremIpsumText.setTextColor(ContextCompat.getColor(requireContext(), R.color.medium_grey));
        mAddItemFab.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(),
                R.color.colorPrimaryLight));
    }
}
