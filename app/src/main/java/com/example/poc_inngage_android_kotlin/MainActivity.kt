package com.example.poc_inngage_android_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import br.com.inngage.sdk.InngageIntentService
import br.com.inngage.sdk.InngageUtils

class MainActivity : AppCompatActivity() {
    private val appToken = "1fadc3dba74047d9916fa18155fbeeba"
    private val env = "prod"
    private val identifier = "saulo_inngage"
    private val provider = "FCM"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InngageIntentService.startInit(this, appToken, env, provider, identifier)
        InngageUtils.handleNotification(this, intent, appToken, env)
        enviarEvento()
    }

    private fun enviarEvento(){
        val botaoEnviar = findViewById<Button>(R.id.button)
        botaoEnviar.setOnClickListener {
            InngageIntentService.sendEvent(appToken, identifier, "evento_de_teste")
        }
    }
}