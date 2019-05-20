package com.example.tripplanner

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val TAG : String = "CreateAccount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = FirebaseAuth.getInstance()

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