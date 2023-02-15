package com.taurunium.stopwatch

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.taurunium.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var MLight:Typeface
    lateinit var MMedium:Typeface
    lateinit var MRegular:Typeface

    lateinit var animation_alphaToGo : Animation
    lateinit var animation_btgOne : Animation
    lateinit var animation_btgTwo : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadTypeface()
        loadAndSetAnimation()
        initUI()

    }

    private fun loadTypeface(){
        MLight = Typeface.createFromAsset(assets, "fonts/MLight.ttf")
        MMedium = Typeface.createFromAsset(assets, "fonts/MMedium.ttf")
        MRegular = Typeface.createFromAsset(assets, "fonts/MRegular.ttf")
    }

    private fun loadAndSetAnimation(){
        animation_alphaToGo = AnimationUtils.loadAnimation(this, R.anim.alpha_to_go)
        animation_btgOne = AnimationUtils.loadAnimation(this, R.anim.btgone)
        animation_btgTwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo)

        //passing animation
        binding.ivSplash.animation = animation_alphaToGo
        binding.tvSplash.animation = animation_btgOne
        binding.tvSubSplash.animation = animation_btgOne
        binding.btnGet.animation = animation_btgTwo
    }

    private fun initUI(){
        binding.tvSplash.typeface = MRegular
        binding.tvSubSplash.typeface = MLight
        binding.btnGet.typeface = MMedium
    }
}