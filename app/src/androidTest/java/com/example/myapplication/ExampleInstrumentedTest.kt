package com.example.myapplication

import android.app.Activity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun test1() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("simplify"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("2^2+2(2)"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 16")))
    }
    @Test
    fun test2() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("factor"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("x^2 + 2x"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 2 x^3")))
    }
    @Test
    fun test3() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("derive"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("x^2+2x"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 6 x^2")))
    }
    @Test
    fun test4() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("integrate"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("x^2+2x"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 1/2 x^4")))
    }
    @Test
    fun test5() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("area"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("2:4lx^3"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 2")))
    }
    @Test
    fun test6() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("cos"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("pi"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: -1")))
    }
    @Test
    fun test7() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("sin"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("0"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 0")))
    }
    @Test
    fun test8() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("tan"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("0"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 0")))
    }
    @Test
    fun test9() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("arccos"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("0"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 1/2 pi")))
    }
    @Test
    fun test10() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("arcsin"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("0"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 0")))
    }
    @Test
    fun test11() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("arctan"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("0"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 0")))
    }
    @Test
    fun test12() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("abs"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("-1"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 1")))
    }
    @Test
    fun test13() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("log"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("2|8"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 3")))
    }
    @Test
    fun test14() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("log"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("2|8"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 3")))
    }
    @Test
    fun test15() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText(""))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText(""))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        var activity: Activity? = null
        activityScenarioRule.scenario.onActivity { activity = it }
        Espresso.onView(withText(R.string.error_input_result)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(
                    CoreMatchers.`is`(
                        activity!!.window.decorView
                    )
                )
            )
        ).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }
    @Test
    fun test16() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("teest"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText(""))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        var activity: Activity? = null
        activityScenarioRule.scenario.onActivity { activity = it }
        Espresso.onView(withText(R.string.error_result)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(
                    CoreMatchers.`is`(
                        activity!!.window.decorView
                    )
                )
            )
        ).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }
    @Test
    fun test17() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText(""))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("jfvbweiv"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        var activity: Activity? = null
        activityScenarioRule.scenario.onActivity { activity = it }
        Espresso.onView(withText(R.string.error_result)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(
                    CoreMatchers.`is`(
                        activity!!.window.decorView
                    )
                )
            )
        ).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }
    @Test
    fun test18() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("vnewfvj"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("nfvnoe"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        var activity: Activity? = null
        activityScenarioRule.scenario.onActivity { activity = it }
        Espresso.onView(withText(R.string.error_result)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(
                    CoreMatchers.`is`(
                        activity!!.window.decorView
                    )
                )
            )
        ).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }
    @Test
    fun test19() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("factor"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("1+1+2^2"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 2^2")))
    }
    @Test
    fun test20() {
        Espresso.onView(withId(R.id.operation)).perform(ViewActions.typeText("log"))
        Espresso.onView(withId(R.id.expression)).perform(ViewActions.typeText("7|49"))
        Espresso.onView(withId(R.id.buttonResult)).perform(ViewActions.click())
        Thread.sleep(3000)
        Espresso.onView(withId(R.id.textViewResult))
            .check(ViewAssertions.matches(withText("Ответ: 2")))
    }
}