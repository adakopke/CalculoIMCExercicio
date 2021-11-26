package com.example.imc.ui.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.imc.ImcApplication
import com.example.imc.R
import com.example.imc.models.Imc
import com.example.imc.ui.components.ListaIMCAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaIMC : AppCompatActivity(R.layout.activity_lista_imc) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        configRecycleView()
        configBotaoSalvar()
    }

    fun configRecycleView(){
         val listaTarefaView = findViewById<RecyclerView>(R.id.lista_pessoas)



          val imcMedicoes: List<Imc>? = ImcApplication.database?.imcDao()?.buscarMedicoes()

          Log.i("FormularioIMC", "Lista medicoes: $imcMedicoes")


         listaTarefaView.adapter = imcMedicoes?.let { ListaIMCAdapter(it, this) }
    }
    fun configBotaoSalvar(){
        val btnAdd = findViewById<FloatingActionButton>(R.id.btn_add_imc)
        btnAdd.setOnClickListener {
            val intent = Intent(this, FormularioIMC::class.java)
            startActivity(intent)
        }
    }
}