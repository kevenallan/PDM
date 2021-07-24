package com.example.prtica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvModelo;
    private TextView tvSobre;
    private Button btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvModelo = findViewById(R.id.tvModelo);
        this.tvSobre = findViewById(R.id.tvSobre);
        this.btnSobre = findViewById(R.id.btnSobre);

        this.tvModelo.setText(Build.MODEL);
        this.btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sobre(v);
            }
        });

    }

    public void sobre(View v){
        this.tvSobre.setText("- Device: "+Build.DEVICE+"\n- Display: "+ Build.DISPLAY+ "\n- HardWare: "+ Build.HARDWARE +"\n- Product: "+ Build.PRODUCT +"\n- Cpu: "+ Build.CPU_ABI);
    }


}