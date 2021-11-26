package com.example.imc.ui.activitys

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.imc.ImcApplication
import com.example.imc.R
import com.example.imc.models.Imc
import java.time.LocalDate.*
import java.util.*

class FormularioIMC : AppCompatActivity(R.layout.activity_formulario_imc) {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configBotaoSalvar()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun configBotaoSalvar(){
        val btnSalvar = findViewById<Button>(R.id.form_btn_salvar)
        btnSalvar.setOnClickListener {
            salvarTarefa()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun salvarTarefa(){
        val textTitulo = findViewById<EditText>(R.id.form_nome)
        val textAltura = findViewById<EditText>(R.id.form_altura)
        val textPeso = findViewById<EditText>(R.id.form_peso)
        val nome = textTitulo.text.toString()
        val alturaEmMetros = textAltura.text.toString()
        val pesoEmKg = textPeso.text.toString()



        val imc = (pesoEmKg.toFloat().div((alturaEmMetros.toFloat() * alturaEmMetros.toFloat())))

        val registroIMC =  Imc(id = UUID.randomUUID().toString(), nomePessoa = nome, alturaEmMetros = alturaEmMetros, pesoEmKg = pesoEmKg, imc = imc , dataRegistro = now().toString())

        val logBanco = ImcApplication.database?.imcDao()?.salvar(registroIMC)
//        ImcDao().salvar(registroIMC)

        Log.i("FormularioIMC", "Pessoa: $nome")
        Log.i("FormularioIMC", "Altura: $alturaEmMetros")
        Log.i("FormularioIMC", "Peso: $pesoEmKg")
        Log.i("FormularioIMC", "Resgistro IMC $registroIMC")
        Log.i("FormularioIMC", "Registro do banco ${logBanco.toString()}")



        AlertDialog.Builder(this)
            .setTitle("Adicionado com sucesso")
            .setMessage("IMC de $nome adicionado com sucesso")
            .setPositiveButton("Ok"){_,_ ->  finish() }
            .show()

    }
}