package com.example.android.accessibility.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import com.example.android.accessibility.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val count = ObservableInt(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.count = count

        binding.addButton.setOnClickListener {
            count.set(count.get() + 1)
        }

        binding.subtractButton.setOnClickListener {
            count.set(count.get() - 1)
        }
    }
}
