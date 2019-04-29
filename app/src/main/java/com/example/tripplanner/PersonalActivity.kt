package com.example.tripplanner

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class PersonalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)

        var submitBtn : Button = this.findViewById(R.id.submit)
        val email = findViewById<EditText>(R.id.e_mail_input)
        val name = findViewById<EditText>(R.id.name_input)
        val pw = findViewById<EditText>(R.id.password_input)
        val pw_check = findViewById<EditText>(R.id.password_test_input)

        submitBtn.setOnClickListener{
            if(email.text.toString().length == 0 || pw.text.toString().length == 0 ||
                    pw_check.text.toString().length == 0){
                Toast.makeText(this,"입력되지 않은 칸이 있습니다.",Toast.LENGTH_SHORT).show()
            }
            else{
                //요기서 입력값들 가져다가 저장
            }
        }

    }
}