package com.aydinbattal.a4_aydin

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

/**
 * A4-Aydin created by aydin
 * student ID : 991521740
 * on 2022-04-17 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun test_TheUserBooksWithoutProvidingAPassport() {
//        ● GIVEN: The user is on the main screen of the application
//        AND fills in the name and email fields
//                AND selects a flight
//                BUT does not provide a passport
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.edtName)).perform(typeText("Joe"))
        onView(withId(R.id.edtEmail)).perform(typeText("joe@gmail.com"))
        onView(withId(R.id.btnRadioFirst)).perform(click())
//        ● WHEN: The user presses the BOOK NOW button
        onView(withId(R.id.btnBookNow)).perform(click())
//        ● THEN: The UI should display an error message that says: “Sorry, you must provide a
//        passport”
        onView(withId(R.id.bookingResultLabel)).check(matches(withEffectiveVisibility((ViewMatchers.Visibility.VISIBLE))))
        onView(withId(R.id.bookingResultLabel)).check(matches(withText("Sorry, you must provide a passport")))
    }

    @Test
    fun test_TheUserBooksAFlightWithAPassport()
    {
//        ● GIVEN: The user is on the main page of the application
//        AND does not have prior bookings
//                AND fills in all fields(name, email flight, passport)
//        AND selects a flight
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.edtName)).perform(typeText("Joe"))
        onView(withId(R.id.edtEmail)).perform(typeText("joe@gmail.com"))
        onView(withId(R.id.edtPassport)).perform(typeText("CAN123321"))
        onView(withId(R.id.btnRadioFirst)).perform(click())
//        ● WHEN: The user presses the BOOK NOW button
        onView(withId(R.id.btnBookNow)).perform(click())
//        ● THEN: The UI displays “Flight booked!” message
//        AND display the total number of reservations as 1
        onView(withId(R.id.bookingResultLabel)).check(matches(withEffectiveVisibility((ViewMatchers.Visibility.VISIBLE))))
        onView(withId(R.id.bookingResultLabel)).check(matches(withText("Flight booked!")))
        onView(withId(R.id.numberOfReservationsLabel)).check(matches(withEffectiveVisibility((ViewMatchers.Visibility.VISIBLE))))
        onView(withId(R.id.numberOfReservationsLabel)).check(matches(withText("Total number of reservations: 1")))
    }
}

