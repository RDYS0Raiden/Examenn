package com.example.examenn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProcesar.setOnClickListener {
        SW()
        }
    }

    private fun SW() {

        binding.apply {
            if (SW.isChecked) {

            PasarPantalla()
            } else {
                AVISO()
            }
        }

    }
    private fun PasarPantalla(){
        var NombreP=binding.pltxtnombre.text
        var PrecioP=binding.pltxtprecio.text
        var Pnombre=NombreP
        var Pprecio=PrecioP
        val intent= Intent(this,pantalla2::class.java)

        intent.apply {
            putExtra("NombreP",Pnombre)
            putExtra("PrecioP",Pprecio)
        }

        startActivity(intent)
    }
    private fun AVISO(){
        Toast.makeText(this,"NO FALTAN DATOS", Toast.LENGTH_SHORT).show()
    }

}