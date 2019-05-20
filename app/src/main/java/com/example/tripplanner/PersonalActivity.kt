package com.example.tripplanner

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.*
import com.example.tripplanner.Data.UserData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_personal.*

class PersonalActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference// ...

    private lateinit var auth: FirebaseAuth
    private val TAG: String = "CreateAccount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)

        var submitBtn: Button = this.findViewById(R.id.submit)
        val email = findViewById<EditText>(R.id.e_mail_input)
        val name = findViewById<EditText>(R.id.name_input).text.toString()
        //val birthday = findViewById<DatePicker>(R.id.birthday)
        val sex = findViewById<RadioGroup>(R.id.sex)
        val pw = findViewById<EditText>(R.id.password_input)
        val pw_check = findViewById<EditText>(R.id.password_test_input).text.toString()

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        submitBtn.setOnClickListener {
            if (e_mail_input.text.toString().isEmpty() || password_input.text.toString().isEmpty() || password_test_input.text.toString().isEmpty()) {
                Toast.makeText(this, "입력되지 않은 칸이 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(e_mail_input.text.toString(), password_input.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "createUserWithEmail:success")
                            val user = auth.currentUser
                            //updateUI(user)
                            // 아니면 액티비티를 닫아 버린다.
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            //updateUI(null)
                            //입력필드 초기화
                            email.setText("")
                            pw?.setText("")
                            email.requestFocus()
                        }
                    }
            }
        }

    }

    private fun writeNewUser(email: String, name: String, pw: String) {
        val user = UserData(email, name, pw)
        database.child("users").child(email).setValue(user)

    }
}