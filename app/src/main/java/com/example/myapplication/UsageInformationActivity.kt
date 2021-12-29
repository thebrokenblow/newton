package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi

open class NewtonModel(
    var operation: String,
    var expression: String,
    var result: String
)

class NewtonItems(
    val List: List<NewtonModel> = listOf(
        NewtonModel("test","test","test"),
        NewtonModel("test","test","test"),
        NewtonModel("test","test","test"),
        NewtonModel("test","test","test")
    )
)

class NewtonAdapter(private val dataBase: List<NewtonModel>) : RecyclerView.Adapter<NewtonAdapter.NewtonViewHolder>() {
    class NewtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var operation: TextView = itemView.findViewById(R.id.operation)
        var expression: TextView = itemView.findViewById(R.id.expression)
        var result: TextView = itemView.findViewById(R.id.result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewtonViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_usage_information, parent, false)
        return NewtonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewtonViewHolder, position: Int) {
        holder.operation.text = dataBase[position].operation
        holder.expression.text = dataBase[position].expression
        holder.result.text = dataBase[position].result
    }
    override fun getItemCount() = dataBase.size
}

@DelicateCoroutinesApi
class UsageInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage_information)

        findViewById<RecyclerView>(R.id.recyclerView).adapter = NewtonAdapter(NewtonItems().List)

//        findViewById<Button>(R.id.buttonBack).setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//        }
    }
}


