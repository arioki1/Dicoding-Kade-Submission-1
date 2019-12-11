/*
 * *
 *   Created by Yoga Setiawan on 12/11/19 10:22 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/10/19 9:22 PM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui

import android.graphics.Typeface
import android.os.Bundle
import android.util.Base64
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission.data.FootballItem
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    var valName = ""
    var valDescription = ""
    var valBadge: Int = 0

    companion object {
        val bg = 1
        val badge = 2
        val description = 3
        val name = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var data: FootballItem = intent.getParcelableExtra("FootballItem")
        valName = data.name.toString()
        valDescription = data.description.toString()
        valBadge = data.badge

        val decrypt = Base64.decode(valDescription, Base64.DEFAULT)
        scrollView {
            relativeLayout {
                imageView {
                    id = bg
                    backgroundColor = resources.getColor(android.R.color.holo_blue_dark)
                }.lparams(width = matchParent, height = dip(200))

                imageView {
                    id = badge
                    setImageResource(valBadge)
                }.lparams(width = dip(150), height = dip(150)) {
                    centerHorizontally()
                    topMargin = dip(100)
                }

                textView {
                    id = description
                    padding = dip(16)
                    text = String(decrypt)
                }.lparams(width = matchParent) {
                    below(name)
                    topMargin = dip(24)
                }

                textView {
                    id = name
                    gravity = Gravity.CENTER
                    topPadding = dip(16)
                    text = valName
                    textSize = 24f
                    setTypeface(typeface, Typeface.BOLD)
                }.lparams(width = matchParent) {
                    below(badge)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
