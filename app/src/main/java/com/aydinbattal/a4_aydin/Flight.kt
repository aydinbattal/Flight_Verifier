package com.aydinbattal.a4_aydin

/**
 * A4-Aydin created by aydin
 * student ID : 991521740
 * on 2022-04-17 */
class Flight(val departingAirport:String, val arrivingAirport:String, val distance:Double) {
    val cost: Double
        get() = when {
            this.distance >= 1000 -> 1200+(0.35*this.distance)
            else -> 350+(0.75*this.distance)
        }
}