package com.example.banco

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var bt: Button
    private lateinit var dao: PessoaDAO
    private lateinit var txtBuscarId: EditText
    private lateinit var btnBuscarId: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = PessoaDAO(this)

        this.bt = findViewById(R.id.button)

        this.txtBuscarId = findViewById(R.id.txtBuscarId)
        this.btnBuscarId = findViewById(R.id.btnBuscarId)

        this.btnBuscarId.setOnClickListener{
            val pessoa = this.dao.getId(this.txtBuscarId.text.toString().toInt())
            Log.i("APP_BANCO", pessoa.toString())
        }

        this.bt.setOnClickListener{
            var edit = EditText(this)
            val popup = AlertDialog.Builder(this).apply {
                setTitle("Nova Pessoa")
                setMessage("Informe o nome: ")
                setView(edit)
                setPositiveButton("Salvar", DialogInterface.OnClickListener{ dialog, which ->
                    val pessoa = Pessoa(edit.text.toString())
                    this@MainActivity.dao.add(pessoa)
                    Log.i("APP_BANCO", this@MainActivity.dao.get().toString())
                })
                setNegativeButton("Cancelar", null)
            }
            popup.create().show()
        }

        this.bt.setOnLongClickListener{
            val pessoas = this.dao.get()
            val pessoa = pessoas.get(0)
            pessoa.nome = "outro nome"
            Log.i("APP_BANCO", pessoas.toString())

            this.dao.update(pessoa)
            Log.i("APP_BANCO", this@MainActivity.dao.get().toString())

            this.dao.delete(pessoa)
            Log.i("APP_BANCO", this@MainActivity.dao.get().toString())
            return@setOnLongClickListener true
        }
    }
}