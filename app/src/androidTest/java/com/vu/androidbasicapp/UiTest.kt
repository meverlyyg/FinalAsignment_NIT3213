package com.vu.androidbasicapp

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLoginButtonClick() {
        // Enter username
        onView(withId(R.id.usernameEditText)).perform(typeText("testuser"))

        // Enter password
        onView(withId(R.id.passwordEditText)).perform(typeText("password123"))

        // Click on the login button
        onView(withId(R.id.loginButton)).perform(click())

        // Check if it navigates to the HomeScreenFragment by verifying the screen title
        onView(withId(R.id.screenTitle)).check(matches(withText("Travel")))
    }
}