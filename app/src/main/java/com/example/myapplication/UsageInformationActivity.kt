package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi

open class NewtonList(var description: String, var operation: String, var expression: String, var result: String)

class NewtonItems (
    var List: List<NewtonList> = listOf(
        NewtonList("description: Simplify", "operation: simplify","expression: 2^2+2(2)","result: 8"),
        NewtonList("description: Factor","operation: factor","expression: x^2 + 2x","result: x(x + 2)"),
        NewtonList("description: Derive","operation: derive","expression: x^2+2x","result: 2x + 2"),
        NewtonList("description: Integrate","operation: integrate","expression: x^2+2x","result: 1/3 x^3 + x^2 + C"),
        NewtonList("description: Find 0's","operation: zeroes","expression: x^2+2x","result: [-2, 0]"),
        NewtonList("description: Find Tangent","operation: tangent","expression: 2lx^3","result: 12x +-16"),
        NewtonList("description: Area Under Curve","operation: area","expression: 2:4lx^3","result: 60"),
        NewtonList("description: Cosine","operation: cos","expression: pi","result: -1"),
        NewtonList("description: Sine","operation: sin","expression: 0","result: 0"),
        NewtonList("description: Tangent","operation: tan","expression: 0","result: 0"),
        NewtonList("description: Inverse Cosine","operation: arccos","expression: 1","result: 0"),
        NewtonList("description: Inverse Sine","operation: arcsin","expression: 0","result: 0"),
        NewtonList("description: Inverse Tangent","operation: arctan","expression: 0","result: 0"),
        NewtonList("description: Absolute Value","operation: abs","expression: -1","result: 1"),
        NewtonList("description: Logarithm","operation: log","expression: 2l8","result: 3"),
        )
)

class NewtonAdapter(private val newtonList: List<NewtonList>) : RecyclerView.Adapter<NewtonAdapter.NewtonHolder>() {
    class NewtonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var description: TextView = itemView.findViewById(R.id.description)
        var operation: TextView = itemView.findViewById(R.id.operation)
        var expression: TextView = itemView.findViewById(R.id.expression)
        var result: TextView = itemView.findViewById(R.id.result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewtonHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.usage_information, parent, false)
        return NewtonHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewtonHolder, position: Int) {
        holder.description.text = newtonList[position].description
        holder.operation.text = newtonList[position].operation
        holder.expression.text = newtonList[position].expression
        holder.result.text = newtonList[position].result
    }

    override fun getItemCount() = newtonList.size
}

@DelicateCoroutinesApi
class UsageInformationActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usage_information)

        val studentsRecyclerView = findViewById<RecyclerView>(R.id.StudentRecyclerView)
        studentsRecyclerView.adapter = NewtonAdapter(NewtonItems().List)
        studentsRecyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.buttonBack).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}


