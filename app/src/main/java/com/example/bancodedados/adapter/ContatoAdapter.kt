package com.example.bancodedados.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bancodedados.AtualizarUsuario
import com.example.bancodedados.databinding.ActivityMainBinding
import com.example.bancodedados.databinding.ContatoItemBinding
import com.example.bancodedados.model.Usuario

class ContatoAdapter(private val context: Context, private val listaUsuarios: MutableList<Usuario>):
    RecyclerView.Adapter<ContatoAdapter.ContatoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val itemLista = ContatoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return  ContatoViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.txtNome.text = listaUsuarios[position].nome
        holder.txtSobrenome.text = listaUsuarios[position].sobrenome
        holder.txtIdade.text = listaUsuarios[position].idade
        holder.txtcelular.text = listaUsuarios[position].celular

        holder.btAtualizar.setOnClickListener{
            val intent = Intent(context, AtualizarUsuario::class.java)
            intent.putExtra("nome", listaUsuarios[position].nome)
            intent.putExtra("sobrenome", listaUsuarios[position].sobrenome)
            intent.putExtra("idade", listaUsuarios[position].idade)
            intent.putExtra("celular", listaUsuarios[position].celular)
            intent.putExtra("uid", listaUsuarios[position].uid)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = listaUsuarios.size

    inner class ContatoViewHolder(binding: ContatoItemBinding): RecyclerView.ViewHolder(binding.root) {

        val txtNome = binding.txtNome
        val txtSobrenome = binding.txtSobrenome
        val txtIdade = binding.txtIdade
        val txtcelular = binding.txtTelefone
        val btAtualizar = binding.btAtualizar
        val btDeletar = binding.btdeletar
    }
}