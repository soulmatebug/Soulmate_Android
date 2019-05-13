package com.example.tripplanner

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import com.example.tripplanner.Data.UserData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class PersonalActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference// ...

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)

        var submitBtn : Button = this.findViewById(R.id.submit)
        val email = findViewById<EditText>(R.id.e_mail_input).text.toString()
        val name = findViewById<EditText>(R.id.name_input).text.toString()
        //val birthday = findViewById<DatePicker>(R.id.birthday)
        val sex = findViewById<RadioGroup>(R.id.sex)
        val pw = findViewById<EditText>(R.id.password_input).text.toString()
        val pw_check = findViewById<EditText>(R.id.password_test_input).text.toString()
        database = FirebaseDatabase.getInstance().reference

        submitBtn.setOnClickListener{
            if(email.length == 0 || pw.length == 0 || pw_check.length == 0){
                Toast.makeText(this,"입력되지 않은 칸이 있습니다.",Toast.LENGTH_SHORT).show()
            }
            else{
                writeNewUser(email,name,pw)
            }
        }

    }

    private fun writeNewUser( email:String, name: String, pw: String){
        val user = UserData(email,name,pw)
        database.child("users").child(email).setValue(user)

    }
}