package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import kotlin.properties.Delegates

@Entity
data class NewtonRoom(
    @ColumnInfo(name = "result") val result: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

@Dao
interface NewtonDao {
    @Query("SELECT * FROM NewtonRoom")
    fun getAll(): NewtonRoom
    @Insert
    fun insertAll(vararg newtonResult: NewtonRoom)
    @Query("DELETE FROM newtonRoom")
    fun dropAll()
}

@Database(entities = [NewtonRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newtonDao(): NewtonDao
}

data class Newton (
    var result: String? = null
)

private interface APINewton {
    @GET("{operation}/{expression}")
    fun getNewton(@Path("operation") operation : String,
                  @Path("expression") expression : String) : Call<Newton>
}

enum class ResultOfNewton{
    Nothing,
    YouHaveEnteredAnIncorrectOperationOrAnIncorrectExpression,
    InputError;
    var result: String? = null
}

class NewtonResult {
    @DelicateCoroutinesApi
    fun getNewtonResult(
        applicationContext: MainActivity,
        operation: String,
        expression: String,
        addingViewModel: UpdateLastResult,
        ) {
        val resultNewtonEnum: ResultOfNewton = ResultOfNewton.Nothing

        val retrofit = Retrofit.Builder().baseUrl("https://newton.now.sh/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val publicNewton = retrofit.create(APINewton::class.java)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "newton").build()
        val newtonDao = db.newtonDao()

        publicNewton.getNewton(operation, expression).enqueue(object : Callback<Newton> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Newton>, response: Response<Newton>) {
                val resultNewton = response.body()
                if (resultNewton != null) {
                    GlobalScope.launch(Dispatchers.IO) {
                        newtonDao.dropAll()
                        newtonDao.insertAll(NewtonRoom(resultNewton.result.toString()))
                    }
                    resultNewtonEnum.result = resultNewton.result.toString()
                    addingViewModel.updateLastResult(resultNewtonEnum)
                } else addingViewModel.updateLastResult(ResultOfNewton.YouHaveEnteredAnIncorrectOperationOrAnIncorrectExpression)
            }
            override fun onFailure(call: Call<Newton>, t: Throwable) {
                addingViewModel.updateLastResult(ResultOfNewton.InputError)
            }
        })
    }
}

@DelicateCoroutinesApi
interface UpdateLastResult {
    fun updateLastResult(result: ResultOfNewton)
}

@DelicateCoroutinesApi
class AddingViewModel : ViewModel(), UpdateLastResult {
    private var latResult: MutableLiveData<ResultOfNewton> = MutableLiveData(ResultOfNewton.Nothing)
    fun getLastResult() = latResult
    var operation: String by Delegates.observable("",{ _, _, _ -> updateLastResult(ResultOfNewton.Nothing)})
    var expression: String by Delegates.observable("",{ _, _, _ -> updateLastResult(ResultOfNewton.Nothing)})

    fun getResult(applicationContext: MainActivity) {
        NewtonResult().getNewtonResult(applicationContext, operation, expression, this)
    }
    override fun updateLastResult(result: ResultOfNewton) {
        latResult.value = result
    }
}

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: AddingViewModel by viewModels()

        viewModel.getLastResult().observe(this, {
            if (it != null) {
                when (it) {
                    ResultOfNewton.YouHaveEnteredAnIncorrectOperationOrAnIncorrectExpression ->
                        Toast.makeText(this, getString(R.string.error_result), Toast.LENGTH_SHORT)
                            .show()
                    ResultOfNewton.InputError ->
                        Toast.makeText(
                            this,
                            getString(R.string.error_input_result),
                            Toast.LENGTH_SHORT
                        ).show()
                    ResultOfNewton.Nothing -> findViewById<TextView>(R.id.textViewResult).text =
                        getString(R.string.resultTextView) + " " + it.result
                }
            }
        })

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "newton").build()
        val newtonDao = db.newtonDao()

        GlobalScope.launch(Dispatchers.IO) {
            val getAllResult = NewtonRoom(newtonDao.getAll().result)
            launch(Dispatchers.Main) {
                findViewById<TextView>(R.id.textViewResult).text = getString(R.string.resultTextView) + " " + getAllResult.result
            }
        }

        findViewById<Button>(R.id.buttonResult).setOnClickListener {
            viewModel.operation = findViewById<EditText>(R.id.operation).text.toString()
            viewModel.expression = findViewById<EditText>(R.id.expression).text.toString()
            viewModel.getResult(this)
        }

        findViewById<Button>(R.id.buttonInformation).setOnClickListener {
            startActivity(Intent(this, UsageInformationActivity::class.java))
        }
        findViewById<Button>(R.id.shareInformation).setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, findViewById<TextView>(R.id.textViewResult).text.toString())
            intent.type = "text/plain"
            val intentCreateChooser = Intent.createChooser(intent, null)
            startActivity(intentCreateChooser)
        }
    }
}