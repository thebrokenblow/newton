package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class Newton (
    var result: String? = null
)

private interface APINewton {
    @GET("{operation}/{expression}")
    fun getNewton(@Path("operation") operation : String, @Path("expression") expression : String) : Call<Newton>
}

class MainActivity : AppCompatActivity() {

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textView = findViewById<TextView>(R.id.textViewResult)
        outState.putString(RESULT, textView.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().baseUrl("https://newton.now.sh/api/v2/").
                        addConverterFactory(GsonConverterFactory.create()).build()

        val publicNewton = retrofit.create(APINewton::class.java)

        val textEditOperation = findViewById<EditText>(R.id.operation)
        val textEditExpression = findViewById<EditText>(R.id.expression)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        if (savedInstanceState != null)
            textViewResult.text = savedInstanceState.getString(RESULT)

        findViewById<Button>(R.id.buttonResult).setOnClickListener {
            val operation = textEditOperation.text.toString()
            val expression = textEditExpression.text.toString()

            publicNewton.getNewton(operation, expression).enqueue(object: Callback<Newton> {

                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<Newton>, response: Response<Newton>) {
                    val resultNewton = response.body()
                    if (resultNewton != null)
                        textViewResult.text = getString(R.string.resultTextView) + " " + resultNewton.result.toString()
                    else Toast.makeText(this@MainActivity, getString(R.string.error_result), Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Newton>, t: Throwable) {
                    Toast.makeText(this@MainActivity, getString(R.string.error_input_result), Toast.LENGTH_SHORT).show()
                }
            })
        }
        findViewById<Button>(R.id.buttonInformation).setOnClickListener {
            startActivity(Intent(this, UsageInformationActivity::class.java))
        }
    }
    companion object {
        const val RESULT = "RESULT"
    }
}