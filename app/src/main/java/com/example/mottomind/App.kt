package com.example.soulscript

import android.app.Application
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

class App : Application() {

    companion object{
        var shr: SharedPreferences? = null

        fun changeTheme(isTheme: Boolean) {
            var editor = shr?.edit()
            editor?.putBoolean("theme",isTheme)
            editor?.apply()
        }
    }

    override fun onCreate() {
        super.onCreate()
        initShared()

        getThemeData()
    }



        private fun initShared() {
            shr = getSharedPreferences("theme", MODE_PRIVATE)
    }

    private fun getThemeData() {
        var isTheme = shr?.getBoolean("theme",false)

        if (isTheme == true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        } else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }


}
