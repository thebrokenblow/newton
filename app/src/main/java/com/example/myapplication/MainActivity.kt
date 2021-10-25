package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class Newton (
    var result: String? = null
)



public interface APINewton {
    @GET("{operation}/{expression}")
    fun getNewton(@Path("operation") operation : String, @Path("expression") expression : String) : retrofit2.Call<Newton>
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().baseUrl("https://newton.vercel.app/").
                        addConverterFactory(GsonConverterFactory.create()).build()

        val publicNewton = retrofit.create(APINewton::class.java)

    }
}