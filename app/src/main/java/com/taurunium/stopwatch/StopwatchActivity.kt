package com.taurunium.stopwatch

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.taurunium.stopwatch.databinding.ActivityStopwatchBinding

class StopwatchActivity : AppCompatActivity() {
    lateinit var rounddingAlone: Animation
    lateinit var binding: ActivityStopwatchBinding

    lateinit var MLight: Typeface
    lateinit var MMedium: Typeface
    lateinit var MRegular: Typeface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStopwatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadTypeface()
        loadAndSetAnimation()
        initUI()
    }

    private fun loadTypeface(){
        MLight = Typeface.createFromAsset(assets, "fonts/MLight.ttf")
        MMedium = Typeface.createFromAsset(assets, "fonts/MMedium.ttf")
        MRegular = Typeface.createFromAsset(assets, "fonts/MRegular.ttf")

        binding.btnStart.typeface = MMedium
    }

    private fun loadAndSetAnimation(){
        rounddingAlone = AnimationUtils.loadAnimation(this, R.anim.roundingalone)
    }

    private fun initUI(){
        binding.btnStop.alpha = 0f

        binding.btnStart.setOnClickListener {
            binding.ivAnchor.startAnimation(rounddingAlone)
            binding.btnStop.animate().alpha(1.0f).translationY(-80f).setDuration(300).start()
            binding.btnStart.animate().alpha(0f).setDuration(300).start()

            binding.timer.base = SystemClock.elapsedRealtime()
            binding.timer.start()
        }

        binding.btnStop.setOnClickListener {
            binding.ivAnchor.clearAnimation()
            binding.timer.stop()
        }
    }
}