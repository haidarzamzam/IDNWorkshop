package com.haidev.idnworkshopandroid

import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnBoardingActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private lateinit var adapterSlider: SliderAdapter
    private lateinit var mDots1: TextView
    private lateinit var mDots2: TextView
    private lateinit var mDots3: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_onboarding)

        adapterSlider = SliderAdapter(this, this)
        slideViewPager.adapter = adapterSlider
        slideViewPager.addOnPageChangeListener(this)

        mDots1 = TextView(this)
        mDots1.text = HtmlCompat.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
        mDots1.textSize = 50F
        dotsLayout.addView(mDots1)

        mDots2 = TextView(this)
        mDots2.text = HtmlCompat.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
        mDots2.textSize = 50F
        dotsLayout.addView(mDots2)

        mDots3 = TextView(this)
        mDots3.text = HtmlCompat.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
        mDots3.textSize = 50F
        dotsLayout.addView(mDots3)
        addDotsIndicator(0)
    }

    fun addDotsIndicator(position: Int) {
        when (position) {
            0 -> {
                mDots1.setTextColor(ContextCompat.getColor(this, R.color.colorIndicator1))
                mDots2.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                mDots3.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            }
            1 -> {
                mDots1.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                mDots2.setTextColor(ContextCompat.getColor(this, R.color.colorIndicator2))
                mDots3.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            }
            2 -> {
                mDots1.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                mDots2.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                mDots3.setTextColor(ContextCompat.getColor(this, R.color.colorIndicator3))
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        addDotsIndicator(position)
    }


}
