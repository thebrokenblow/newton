package com.example.myapplication

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {
    private lateinit var newtonDao: NewtonDao
    private lateinit var db: AppDatabase

//    @Before
//    fun createDb() {
//        val context = getApplicationContext<Context>()
//        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
//        newtonDao = db.newtonDao()
//    }
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb() {
//        db.close()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test1() {
//        newtonDao.insertAll(NewtonRoom("sin(0)", "", ""))
//        val getResult = NewtonRoom(newtonDao.getAll()!!.result,
//                                   newtonDao.getAll()!!.operation,
//                                   newtonDao.getAll()!!.expression)
//        assertTrue("sin(0)" == getResult.result && "" == getResult.operation && "" == getResult.expression)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test2() {
//        newtonDao.insertAll(NewtonRoom("cos(0)"))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue ("cos(0)" == getResult.result)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test3() {
//        newtonDao.insertAll(NewtonRoom("test1 test2"))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue ("test1 test2" == getResult.result)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test4() {
//        newtonDao.insertAll(NewtonRoom(""))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue ("" == getResult.result)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test5() {
//        newtonDao.insertAll(NewtonRoom("tan(0)"))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue (getResult.result == "tan(0)")
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test6() {
//        newtonDao.insertAll(NewtonRoom("test1 test2"))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue ("test1 test2" == getResult.result)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test7() {
//        newtonDao.insertAll(NewtonRoom("x^2"))
//        newtonDao.insertAll(NewtonRoom("x^2"))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue ("x^2" == getResult.result)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test8() {
//        newtonDao.insertAll(NewtonRoom("x^3"))
//        newtonDao.insertAll(NewtonRoom("x^2"))
//        newtonDao.insertAll(NewtonRoom("x^3"))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue ("x^3" == getResult.result)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test9() {
//        newtonDao.insertAll(NewtonRoom("result"))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue ("result" == getResult.result)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun test10() {
//        newtonDao.insertAll(NewtonRoom("1 2 3 4 5"))
//        val getResult = NewtonRoom(newtonDao.getAll().result)
//        assertTrue ("1 2 3 4 5" == getResult.result)
//    }
}