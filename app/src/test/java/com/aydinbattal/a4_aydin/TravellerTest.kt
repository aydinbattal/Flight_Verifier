package com.aydinbattal.a4_aydin

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * A4-Aydin created by aydin
 * student ID : 991521740
 * on 2022-04-17 */
class TravellerTest {
    @Test
    fun `Traveller books a flight with a passport`(){
//    ● GIVEN: A Traveller with a passport
//    AND a valid flight
        val traveller:Traveller = Traveller("Joe", "joe@gmail.com", "CAN123321", listOf<Flight>())
        val flight:Flight = Flight("Pearson Airport", "Vancouver Airport", 1000.0)
//    ● WHEN: The traveller attempts to book the flight
//    ● THEN: The flight is booked
//    AND the flight is added to their list of flight reservations
        assertThat(traveller.bookFlight(flight)).isTrue()
    }

    @Test
    fun `Traveller books a flight with no passport`() {
//    ● GIVEN: A Traveller with no passport
//    AND a valid flight
        val traveller:Traveller = Traveller("Joe", "joe@gmail.com", null, listOf<Flight>())
        val flight:Flight = Flight("Pearson Airport", "Vancouver Airport", 1000.0)
//    ● WHEN: The traveller attempts to book the flight
//    ● THEN: The flight is is not booked
//    AND the flight is not added to their list of flight reservations
        assertThat(traveller.bookFlight(flight)).isFalse()
    }

    @Test
    fun `Traveller has no bookings and wants the price of their reservations`() {
//        ● GIVEN: A Traveller with no bookings
        val traveller:Traveller = Traveller("Joe", "joe@gmail.com", "CAN123321", listOf<Flight>())
//        ● WHEN: The ttraveller checks the amount owed for their flights
//        ● THEN: The cost is 0
        assertThat(traveller.totalCost == 0).isTrue()
    }

    @Test
    fun `Traveller has one bookings and wants the price of their reservations`() {
//    ● GIVEN: A Traveller has 1 booking
        val traveller:Traveller = Traveller("Joe", "joe@gmail.com", "CAN123321", listOf<Flight>(
            Flight("Pearson Airport", "Vancouver Airport", 1000.0)))
//    ● WHEN: The ttraveller checks the amount owed for their flights
//    ● THEN: The cost is is the price of the single flight
        //1200+(0.35*1000) = 1550
        //traveller.bookings.last().cost
        assertThat(traveller.totalCost == 1550.0).isTrue()
    }

    @Test
    fun `Traveller has multiple bookings and wants the price of their reservations`() {
//    ● GIVEN: A Traveller has more than 1 booking (example, 3)
        val traveller:Traveller = Traveller("Joe", "joe@gmail.com", "CAN123321", listOf<Flight>(
            Flight("Pearson Airport", "Vancouver Airport", 1000.0),
            Flight("Pearson Airport", "Vancouver Airport", 1100.5),
            Flight("Pearson Airport", "Vancouver Airport", 900.0)))
//    ● WHEN: The ttraveller checks the amount owed for their flights
//    ● THEN: The cost is is the sum of all flight costs
        //sum: 1585.175 + 1550.0 + 1025.0 = 4160.175
        assertThat(traveller.totalCost == 4160.175).isTrue()
    }
}