package com.example.tripplanner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import javax.security.auth.AuthPermission


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       val fragmentAdaper = PageAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdaper

        tabs.setupWithViewPager(viewpager_main)

        auth = FirebaseAuth.getInstance()
        btn_logout.setOnClickListener {
            auth.signOut()
            startActivity<MainActivity>()
        }
    }
}