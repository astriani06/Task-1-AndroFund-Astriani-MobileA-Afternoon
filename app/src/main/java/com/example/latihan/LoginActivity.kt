 package com.example.latihan

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

 class LoginActivity : AppCompatActivity(), View.OnClickListener {

     private lateinit var etUsername:EditText
     private lateinit var etPassword:EditText

     val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.edt_username)
        etPassword = findViewById(R.id.edt_password)

        val bundle = intent.extras
        if (bundle != null){
            etUsername.setText(bundle.getString("username"))
            etPassword.setText(bundle.getString("password"))
        }

        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)
    }

     override fun onClick(v: View) {
         when (v.id){
             R.id.btn_login -> {
                 val intent = Intent(this@LoginActivity, MainActivity::class.java)
                 intent.putExtra("User",User(etUsername.text.toString(),etPassword.text.toString()))
                 startActivity(intent)
             }
         }
     }
 }