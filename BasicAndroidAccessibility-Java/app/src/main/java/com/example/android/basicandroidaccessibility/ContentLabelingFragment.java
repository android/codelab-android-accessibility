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
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class ContentLabelingFragment extends Fragment {

    private boolean mPlaying = false;
    private ImageButton mPlayPauseToggleImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content_labeling, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        mPlayPauseToggleImageView = view.findViewById(R.id.play_pause_toggle_view);
        if (mPlayPauseToggleImageView != null) {
            updateImageButton();
            mPlayPauseToggleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlaying = !mPlaying;
                    updateImageButton();
                }
            });
        }
    }

    private void updateImageButton() {
        if (mPlaying) {
            mPlayPauseToggleImageView.setImageResource(R.drawable.ic_pause);
        } else {
            mPlayPauseToggleImageView.setImageResource(R.drawable.ic_play_arrow);
        }
    }
}
