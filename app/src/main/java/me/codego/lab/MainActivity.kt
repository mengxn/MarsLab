package me.codego.lab

import android.app.Activity
import android.os.Build
import android.os.Bundle

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expandStatusBar()
        finish()
    }

    private fun expandStatusBar() {
        try {
            val service = getSystemService("statusbar")
            val clazz = Class.forName("android.app.StatusBarManager")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                clazz.getMethod("expandNotificationsPanel")
            } else {
                clazz.getMethod("expand")
            }.also {
                it.invoke(service)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
