package com.example.tripplanner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var loginBtn: Button = this.findViewById(R.id.login)
        var joinBtn : Button = this.findViewById(R.id.join)

        loginBtn.setOnClickListener{
            val loginActivity : Intent = Intent(this,LoginActivity::class.java)
            startActivity(loginActivity)
        }

        joinBtn.setOnClickListener{
            val joinActivity : Intent = Intent(this,JoinActivity::class.java)
            startActivity(joinActivity)
        }
    }
}
