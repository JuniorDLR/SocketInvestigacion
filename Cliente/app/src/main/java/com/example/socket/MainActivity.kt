package com.example.socket

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.io.PrintWriter
import java.net.Socket

class MainActivity : AppCompatActivity() {
    private var socket: Socket? = null
    private var printWriter: PrintWriter? = null
    private var Nombre: EditText? = null
    private var Edad: EditText? = null
    private var Mensaje: EditText? = null
    var buttonEnviar: Button? = null
    var puerto = 8000
    var mensaje: String? = null
    var nombre: String? = null
    var edad: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Nombre = findViewById<EditText>(R.id.editTextnombre)
        Edad = findViewById<EditText>(R.id.editTextEdad)
        Mensaje = findViewById<EditText>(R.id.editTextMensaje)
        buttonEnviar = findViewById<Button>(R.id.buttonEnciar)
        buttonEnviar!!.setOnClickListener {
            mensaje = Mensaje!!.text.toString()
            nombre = Nombre!!.text.toString()
            edad = Edad!!.text.toString()
            Thread {
                try {
                    socket = Socket(" 192.168.1.9", puerto)
                    printWriter = PrintWriter(socket!!.getOutputStream())
                    printWriter!!.write("nombre: $nombre Edad: $edad mensaje: $mensaje")
                    printWriter!!.flush()
                    printWriter!!.close()
                    socket!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }.start()
            Nombre!!.setText(null)
            Edad!!.setText(null)
            Mensaje!!.setText(null)
        }
    }

}