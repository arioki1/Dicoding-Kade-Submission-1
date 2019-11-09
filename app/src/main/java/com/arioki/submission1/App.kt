package com.arioki.submission1

import android.app.Application
import com.arioki.submission1.remote.ThesportsDBApi
import com.arioki.submission1.repository.ThesportsDBRepository

class App : Application() {
    val repository: ThesportsDBRepository by lazy {
        ThesportsDBRepository(ThesportsDBApi.create())
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        @Volatile
        private var INSTANCE: App? = null
        val instances: App
            get() {
                if (INSTANCE == null) {
                    synchronized(App::class.java) {
                        if (INSTANCE == null) {
                            throw RuntimeException("Something went wrong!")
                        }
                    }
                }
                return INSTANCE!!
            }
    }
}