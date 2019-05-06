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

        //val id = this.findViewById<EditText>(R.id.email)
        //val pw = this.findViewById<EditText>(R.id.password)

        loginBtn.setOnClickListener{
            val loginActivity : Intent = Intent(this,LoginActivity::class.java)

            /*if(id.text.toString().length==0 || pw.text.toString().length == 0){
                Toast.makeText(this,"e-mail 혹은 password를 반드시 입력하세요.", Toast.LENGTH_SHORT).show()
            } else {
                //firebase 요기서 써야대..
            }*/

            startActivity(loginActivity)
        }

        joinBtn.setOnClickListener{
            val joinActivity : Intent = Intent(this,JoinActivity::class.java)
            startActivity(joinActivity)
        }
    }
}
