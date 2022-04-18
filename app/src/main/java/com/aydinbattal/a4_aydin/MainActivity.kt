package com.aydinbattal.a4_aydin

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aydinbattal.a4_aydin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBookNow.setOnClickListener{

            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val passport = binding.edtPassport.text.toString()
            val traveller:Traveller = Traveller(name,email,passport, mutableListOf<Flight>())
            var isFlightBooked:Boolean? = null

            if (binding.btnRadioFirst.isChecked){
                val flight:Flight = Flight("Pearson Airport", "Vancouver Airport", 1100.5)
                isFlightBooked = traveller.bookFlight(flight)
            } else if (binding.btnRadioFirst.isChecked){
                val flight:Flight = Flight("Pearson Airport", "Vancouver Airport", 1000.0)
                isFlightBooked = traveller.bookFlight(flight)
            } else if (binding.btnRadioFirst.isChecked){
                val flight:Flight = Flight("Pearson Airport", "Vancouver Airport", 900.0)
                isFlightBooked = traveller.bookFlight(flight)
            }


            if (isFlightBooked==true){
                binding.bookingResultLabel.visibility = View.VISIBLE
                binding.bookingResultLabel.text = "Flight booked!"
                binding.numberOfReservationsLabel.visibility = View.VISIBLE
                binding.numberOfReservationsLabel.text = "Total number of reservations: ${traveller.bookings.size}"
            } else if (isFlightBooked==false) {
                binding.bookingResultLabel.visibility = View.VISIBLE
                binding.bookingResultLabel.text = "Sorry, you must provide a passport"
            }



        }

    }
}
