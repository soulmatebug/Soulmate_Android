package com.example.tripplanner

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.lang.Exception

class SplashActivity :  AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            Thread.sleep(4000);
        }catch (e : Exception){
            e.printStackTrace()
        }

        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}