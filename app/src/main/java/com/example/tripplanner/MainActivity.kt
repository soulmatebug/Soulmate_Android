package com.example.tripplanner

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val TAG: String = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CheckAuth()
        auth = FirebaseAuth.getInstance()

        val id = findViewById(R.id.edt_main_activity_email) as EditText
        val pw = this.findViewById<EditText>(R.id.pw_input)

        login.setOnClickListener {
            val loginActivity: Intent = Intent(this, LoginActivity::class.java)

            if (id.text.toString().length == 0 || pw.text.toString().length == 0) {
                Toast.makeText(this, "e-mail 혹은 password를 반드시 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(id.text.toString(), pw.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUI(null)
                        }
                    }

            }

        }

        join.setOnClickListener {
            startActivity<JoinActivity>()

        }
    }

    private fun CheckAuth() {
        auth = FirebaseAuth.getInstance()
        val currentUser = auth?.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(cUser: FirebaseUser?) {
        if (cUser != null) {
            startActivity<LoginActivity>()
            toast("")
            finish()
        } else {
            toast("로그인이 필요합니다.")
           }
        edt_main_activity_email.setText("")
        pw_input.setText("")
        hideKeyboard(edt_main_activity_email)
    }

    private fun hideKeyboard(view: View) {
        view?.apply {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}

