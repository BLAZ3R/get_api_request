package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.api.ApiConfig
import com.example.myapplication.api.ApiConfig.API_USER
import com.example.myapplication.model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://volunteer-kz.herokuapp.com/"

        val apiUser = ApiConfig.API_USER

        apiUser.getData().enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful) {
                    tv_text.text = response.body()?.num.toString()
                }

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                tv_text.text = "ERROR"
            }

        })


    }
}