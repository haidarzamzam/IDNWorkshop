package com.haidev.idnworkshopandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter

class SliderAdapter(cotextIntent: Context, activityIntent: Activity) : PagerAdapter() {

    val context = cotextIntent
    val activity = activityIntent

    val imageSlide = intArrayOf(R.drawable.walk, R.drawable.nunjuk, R.drawable.hai)
    val colorSlide = intArrayOf(R.color.colorSlide1, R.color.colorSlide2, R.color.colorSlide3)
    val colorText =
        intArrayOf(R.color.colorTextSlide1, R.color.colorTextSlide2, R.color.colorTextSlide3)
    val headingSlide = arrayOf("Laper?", "Pilih Menu", "Nikmati")
    val descSlide =
        arrayOf("Buka aja Mangkok Cantik", "Sesuai sama mood kamu", "Bareng sama teman kamu")

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }

    override fun getCount(): Int {
        return headingSlide.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View =
            LayoutInflater.from(container.context).inflate(R.layout.slide_layout, null)

        val layoutBackground: RelativeLayout = view.findViewById(R.id.layoutSlide)
        val imageViewBackground: ImageView = view.findViewById(R.id.ivImage)
        val textViewHeading: TextView = view.findViewById(R.id.txtHeading)
        val textViewDescription: TextView = view.findViewById(R.id.txtDesc)
        val btnMulai: Button = view.findViewById(R.id.btnMulai)

        textViewHeading.setTextColor(ContextCompat.getColor(context, colorText[position]))
        textViewDescription.setTextColor(ContextCompat.getColor(context, colorText[position]))
        layoutBackground.setBackgroundColor(ContextCompat.getColor(context, colorSlide[position]))
        imageViewBackground.setImageResource(imageSlide[position])
        textViewHeading.text = headingSlide[position]
        textViewDescription.text = descSlide[position]

        if (position == 2) {
            btnMulai.visibility = View.VISIBLE
        }

        btnMulai.setOnClickListener {
            context.startActivity(Intent(context, MainActivity::class.java))
            activity.finish()
        }
        container.addView(view)

        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }
}