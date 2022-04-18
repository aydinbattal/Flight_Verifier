package com.aydinbattal.a4_aydin

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * A4-Aydin created by aydin
 * student ID : 991521740
 * on 2022-04-17 */
class FlightTest {
    @Test
    fun `flight over 1000km`(){

//        GIVEN: A flight that is more than 1000 km in distance
        val flight:Flight = Flight("Pearson Airport", "Vancouver Airport", 1100.5)
//        WHEN: The cost of the flight is requested
        val cost = flight.cost
//        THEN: The cost should be computed at $1200 + 0.35 * distance in km
        //1200+(0.35*1100.5) = 1585.175
        assertThat(cost).isEqualTo(1585.175)
    }

    @Test
    fun `Flight equal to 1000km`(){
//        ● GIVEN: A flight that is equal to 1000 km in distance
        val flight:Flight = Flight("Pearson Airport", "Vancouver Airport", 1000.0)
//        ● WHEN: The cost of the flight is requested
        val cost = flight.cost
//        ● THEN: The cost should be computed at $1200 + 0.35 * distance in km
        //1200+(0.35*1000) = 1550
        assertThat(cost).isEqualTo(1550.0)
    }

    @Test
    fun `Flight under 1000km`() {
//    ● GIVEN: A flight that is less than 1000 km in distance
        val flight:Flight = Flight("Pearson Airport", "Vancouver Airport", 900.0)

//    ● WHEN: The cost of the flight is requested
        val cost = flight.cost

//    ● THEN: The cost should be computed at $350 + 0.75 * distance in km
        //350+(0.75*900) = 1025
        assertThat(cost).isEqualTo(1025.0)

    }

}