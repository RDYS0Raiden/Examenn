package com.example.examenn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.examenn.databinding.ActivityPantalla2Binding

class pantalla2 : AppCompatActivity() {

    private lateinit var binding: ActivityPantalla2Binding
    private lateinit var myHandler:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPantalla2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        myHandler=Handler(mainLooper)


        binding.btnProcesar.setOnClickListener {
            IniciarHilo()
        }


    }

    private fun IniciarHilo(){
        Thread{
            try {
                for(i in 0..10){
                    Thread.sleep(1000)
                    myHandler.post{
                        //va a comunicarse con la UI Thread
                        binding.apply{
                            txtcontador.text="$i%"
                            PBR.progress=i * 10
                        }
                    }
                }
                runOnUiThread{
                    Thread.sleep(1000)
                    binding.txtcontador.text="PRODUCTO CARGADO CORRECTAMENTE"
                    DATOS()
                }


            }catch (e:InterruptedException){
                e.printStackTrace()
            }

        }.start()
    }


    private fun DATOS(){
        //se generara letras
        var numero1 =(1..9).random()
        var numero2 =(0..9).random()

        val Pnombre1 ="${intent.getStringArrayExtra("NombreP")}"
        val Pprecio2 ="${intent.getStringArrayExtra("PrecioP")}"

        binding.txtcodigo.text="""
            Nombre del producto:CELULAR XIAOMI
            precio del producto:1200bs
            codigo: $numero1$numero2
        """.trimIndent()
        }



}