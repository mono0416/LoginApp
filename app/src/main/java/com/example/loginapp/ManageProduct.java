package com.example.loginapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginapp.controladores.LibroBD;
import com.example.loginapp.modelos.Libro;

public class ManageProduct extends AppCompatActivity implements View.OnClickListener {

    Context context;
    EditText txttitulo,txtsubtitulo,txtisbn,txtautor,txtprecio;
    int id;
    LibroBD libroBD;

    Button btnguardar, btnactualizar,btnborrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);
        init();
    }
    private void init(){
        context = getApplicationContext();
        txttitulo = findViewById(R.id.ges_txttitulo);
        txtsubtitulo = findViewById(R.id.ges_txtsubtitulo);
        txtautor = findViewById(R.id.ges_txtautor);
        txtisbn = findViewById(R.id.ges_txtisbn);
        txtprecio = findViewById(R.id.ges_txtprecio);

        btnactualizar = findViewById(R.id.ges_btnactualizar);
        btnguardar = findViewById(R.id.ges_btnguardar);
        btnborrar = findViewById(R.id.ges_btnborrar);

        Intent i = getIntent();
        Bundle bolsa = i.getExtras();
        id = bolsa.getInt("id");
        if( id != 0){
            txttitulo.setText(bolsa.getString("titulo"));
            txtsubtitulo.setText(bolsa.getString("subtitulo"));
            txtautor.setText(bolsa.getString("autor"));
            txtisbn.setText(bolsa.getString("isbn"));
            txtprecio.setText(bolsa.getDouble("precio") + "");
            btnguardar.setEnabled(false);

        }else{
            btnactualizar.setEnabled(false);
            btnborrar.setEnabled(false);

        }

    }

    private void limpiarCampos(){
        id = 0;
        txttitulo.setText("");
        txtsubtitulo.setText("");
        txtautor.setText("");
        txtisbn.setText("");
        txtprecio.setText("");
    }

    private  Libro llenarDatosLibro(){
        Libro libro = new Libro();
        String t = txttitulo.getText().toString();
        String s = txtsubtitulo.getText().toString();
        String i = txtisbn.getText().toString();
        String a = txtautor.getText().toString();
        String p = txtprecio.getText().toString();

        libro.setId( id );
        libro.setTitulo( t );
        libro.setSubtitulo( s );
        libro.setIsbn( i );
        libro.setAutor( a );
        libro.setPrecio(Double.parseDouble( p ) );
        return libro;
    }

    private void guardar(){
        libroBD = new LibroBD(context, "LibrosBD.db",null,1);
        Libro libro = llenarDatosLibro();
        if( id == 0){
            libroBD.agregar(libro);
            Toast.makeText(context,"Se ha Guardado correctamente OK", Toast.LENGTH_LONG).show();
        } else {
            libroBD.actualizar(id, libro);
            btnactualizar.setEnabled(false);
            btnborrar.setEnabled(false);
            Toast.makeText(context, "Se ha Actualizado correctamente OK", Toast.LENGTH_LONG).show();
        }
    }


    private void borrar(){
        libroBD = new LibroBD(context, "LibrosBD.db",null,1);
        Libro libro = llenarDatosLibro();
        if( id == 0){
            Toast.makeText(context,"No se ha podido borrar", Toast.LENGTH_LONG).show();
        } else {
            libroBD.borrar(id);
            limpiarCampos();
            btnguardar.setEnabled(true);
            btnactualizar.setEnabled(false);
            btnborrar.setEnabled(false);
            Toast.makeText(context, "Se ha borrado correctamente OK", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.ges_btnguardar) {
            guardar();
        } else if (id == R.id.ges_btnborrar) {
            borrar();
        } else if (id == R.id.ges_btnactualizar) {
            guardar();
        }
    }
}