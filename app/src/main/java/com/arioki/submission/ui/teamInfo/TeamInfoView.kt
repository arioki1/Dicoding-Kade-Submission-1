/*
 * *
 *   Created by Yoga Setiawan on 11/27/19 9:31 PM
 *   Copyright (c) 2019 . All rights reserved.
 *   Last modified 11/26/19 8:06 AM
 *   Github : https://github.com/arioki1/Submission-Kelas-Kade-Dicoding.git
 *
 */

package com.arioki.submission.ui.teamInfo

import com.arioki.submission.data.TeamInfoItem

interface TeamInfoView {
    fun getDataFinish(items: MutableList<TeamInfoItem>)
}
