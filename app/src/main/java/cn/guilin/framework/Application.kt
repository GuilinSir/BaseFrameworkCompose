package cn.guilin.framework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        initLog()
    }

    private fun initLog() {
//        if (Config.DEBUG) {
        Timber.plant(Timber.DebugTree())
//        }
    }
}