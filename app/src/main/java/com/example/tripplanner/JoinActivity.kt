package com.example.tripplanner

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        var personalBtn : Button = this.findViewById(R.id.personal)
        var companyBtn : Button = this.findViewById(R.id.company)

        personalBtn.setOnClickListener{
            val personalActivity : Intent = Intent(this,PersonalActivity::class.java)
            startActivity(personalActivity)
        }

        companyBtn.setOnClickListener{
            val companyActivity : Intent = Intent(this,CompanyActivity::class.java)
            startActivity(companyActivity)
        }

    }
}