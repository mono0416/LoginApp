package com.example.loginapp;

import static android.widget.Toast.makeText;

import static com.example.loginapp.R.id.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Context context;
    Button btnListar, btnRegistrar, btnBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        context = getApplicationContext();
        btnRegistrar = findViewById(R.id.btnregistrar);
        btnBuscar = findViewById(R.id.btnbuscar);
        btnListar = findViewById(R.id.btnlistar);

        btnRegistrar.setOnClickListener(this);
        btnBuscar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnregistrar) {
            Toast.makeText(this, "Registrar", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, ManageProduct.class);
            Bundle bolsa = new Bundle();
            bolsa.putInt("id", 0);
            i.putExtras(bolsa);
            startActivity(i);
        } else if (id == R.id.btnlistar) {
            Toast.makeText(this, "Listar", Toast.LENGTH_LONG).show();
            Intent ia = new Intent(this, ProductList.class);
            startActivity(ia);
        } else if (id == R.id.btnbuscar) {
            Toast.makeText(this, "Buscar", Toast.LENGTH_LONG).show();
            Intent ib = new Intent(this, SearchProduct.class);
            startActivity(ib);
        }
    }
}
