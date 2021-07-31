package com.example.pratica_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText itens;
    private Button adicionar;
    private ListView lista;
    private ArrayList<String> lista2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.itens = findViewById(R.id.itens);
        this.adicionar = findViewById(R.id.adicionar);
        this.lista = findViewById(R.id.lista);

        this.adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarItem(v);
            }
        });
    }

    private void adicionarItem(View view) {
        this.lista2.add(this.itens.getText().toString());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.lista2);
        this.lista.setAdapter(adapter);
    }

}