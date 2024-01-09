package com.example.volleyapikotlin.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.volleyapikotlin.R
import com.example.volleyapikotlin.api.ApiCallback
import com.example.volleyapikotlin.api.ApiRequest
import com.example.volleyapikotlin.model.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiRequest = ApiRequest()

        apiRequest.getUsers(object : ApiCallback<List<User>> {
            override fun onSuccess(users: List<User>?) {
                users?.forEach { user ->
                    val userId = user.id
                    val userName = user.name
                    val userEmail = user.email
                }
            }

            override fun onError(error: String) {
                 Toast.makeText(applicationContext, "Error: $error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
