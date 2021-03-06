package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      Handler().postDelayed({
           val intent:Intent=Intent(this,HomeActivity::class.java);

          startActivity(intent);

          finish()

      },3000)

        val modalLoader:ModalLoader=ModalLoader(this)

        modalLoader.startLoader()

        var retrofit:Retrofit= Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val retrofitApi=retrofit.create(ApiService::class.java)

        retrofitApi.getAllUsers().enqueue(object :Callback<List<Users>>{
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                modalLoader.endLoader()
                d("ambrose","Has responded mrk"+response.body()!![0].username+"" )
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                d("ambrose","Has responded "+t.message.toString()+"" )
            }

        })
    }
}