package com.appcrafters.gamenews.gamedetails.view

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.appcrafters.gamenews.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_screenshot.view.*

class ScreenshotView(context: Context): LinearLayout(context) {
    private val view = View.inflate(context, R.layout.item_screenshot, this)

    fun bind(screenshotImgUrl: String) {
        Glide.with(view).load(screenshotImgUrl).into(view.screenshot)
    }
}