package com.example.volleyapikotlin.api

import android.util.Log
import com.example.volleyapikotlin.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRequest {
    fun getUsers(callback: ApiCallback<List<User>>) {
        val call: Call<List<User>> = ApiClient.apiService.getUsers()

        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users: List<User>? = response.body()

                    // Log thông tin về người dùng từ API
                    users?.forEach {
                        Log.d("User", "ID: ${it.id}, Name: ${it.name}, Email: ${it.email}")
                    }

                    // Gọi phương thức onSuccess của ApiCallback
                    callback.onSuccess(users)
                } else {
                    // Log lỗi nếu không thành công
                    Log.e("ApiRequest", "Error: ${response.code()}")

                    // Gọi phương thức onError của ApiCallback
                    callback.onError("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Log lỗi nếu gặp lỗi trong quá trình thực hiện yêu cầu mạng
                Log.e("ApiRequest", "Error: ${t.message}")

                // Gọi phương thức onError của ApiCallback
                callback.onError("Error: ${t.message}")
            }
        })
    }
}