package com.example.android.basicandroidaccessibility


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
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

            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                val indexOfCheckedChild = radioGroup.indexOfChild(view.findViewById<View>(checkedId))
                when (indexOfCheckedChild) {
                    correctAnswerIndex -> {
                        feedbackTextView.setText(R.string.correct)
                        feedbackTextView.setBackgroundColor(ContextCompat.getColor(context!!,
                                R.color.green))
                    }
                    else -> {
                        feedbackTextView.setText(R.string.incorrect)
                        feedbackTextView.setBackgroundColor(ContextCompat.getColor(context!!,
                                R.color.red))
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