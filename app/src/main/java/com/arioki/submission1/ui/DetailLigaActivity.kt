package com.arioki.submission1.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.arioki.submission1.App
import com.arioki.submission1.R
import com.arioki.submission1.adapter.PagerAdapter
import com.arioki.submission1.data.FootballItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_liga.*

class DetailLigaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_liga)
        initDetailLiga()
        initTab()
    }

    private fun initTab() {
        viewPagerDetailLiga.adapter =
            PagerAdapter(supportFragmentManager)
        tabsDetailLiga.setupWithViewPager(viewPagerDetailLiga)
    }

    private fun initDetailLiga() {
        shimerInfoLeague.startShimmerAnimation()
        val data: FootballItem = intent.getParcelableExtra("FootballItem")
        val id = data.id.toString()
        App.instances.repository.leaguesLookup(id.toInt(), {

            it.run {
                iv_str_league.text = strLeague
                iv_country.text = strCountry
                iv_date_first_event.text = dateFirstEvent
                iv_gender.text = strGender
                Picasso.get()
                    .load(strBadge)
                    .into(ivLogo, object : Callback {
                        override fun onSuccess() {
                            shimerInfoLeague.visibility = View.GONE
                            llInfoLeague.visibility = View.VISIBLE
                        }

                        override fun onError(e: Exception?) {
                            Log.d("LOGAPP", "error")
                        }
                    })
            }
        }, {
            it.printStackTrace()
        })

    }

}