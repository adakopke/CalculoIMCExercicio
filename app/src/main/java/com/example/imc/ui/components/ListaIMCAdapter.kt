package com.example.imc.ui.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imc.R
import com.example.imc.models.Imc

class ListaIMCAdapter(
    private val imcs: List<Imc>,
    private val context: Context
) : RecyclerView.Adapter<ListaIMCAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun vincular(imc: Imc){
            val pessoaNome = itemView.findViewById<TextView>(R.id.nome)
            pessoaNome.text = imc.nomePessoa

            val descricao = itemView.findViewById<TextView>(R.id.imc)
            descricao.text = imc.imc.toString().subSequence(0,5)

            val valor = itemView.findViewById<TextView>(R.id.data_registro)
            valor.text = imc.dataRegistro.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.imc_pessoa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imc =  imcs[position]
        holder.vincular(imc)
    }

    override fun getItemCount(): Int = imcs.size
}