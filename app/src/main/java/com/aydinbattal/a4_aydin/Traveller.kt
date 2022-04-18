package com.aydinbattal.a4_aydin

/**
 * A4-Aydin created by aydin
 * student ID : 991521740
 * on 2022-04-17 */
class Traveller(val name:String, val email:String, val passport:String? = null, val bookings:MutableList<Flight>) {
    val totalCost: Double
        get() {
            var sum = 0.0
            for (i in bookings){
                sum += i.cost
            }
            return sum
        }

    fun bookFlight(flight: Flight): Boolean {
        if (!this.passport.isNullOrEmpty()){
            this.bookings.add(flight)
            return true
        }
        return false
    }
}