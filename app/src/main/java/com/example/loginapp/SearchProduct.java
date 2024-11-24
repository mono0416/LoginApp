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

public class SearchProduct extends AppCompatActivity implements View.OnClickListener {

    Context context;
    EditText txttitulo;
    Button btnbuscar;
    LibroBD libroBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        init();
    }

    private void init(){
        context = getApplicationContext();
        txttitulo = findViewById(R.id.bus_txttitulo);
        btnbuscar = findViewById(R.id.bus_btnbuscar);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bus_btnbuscar){
            String titulo = txttitulo.getText().toString();
            Libro libro = buscarLibro( titulo );
            if ( libro != null ){
                Bundle bolsa = new Bundle();
                bolsa.putInt( "id", libro.getId() );
                bolsa.putString( "titulo", libro.getTitulo() );
                bolsa.putString( "subtitulo", libro.getSubtitulo() );
                bolsa.putString( "autor", libro.getAutor() );
                bolsa.putString( "isbn", libro.getIsbn() );
                bolsa.putDouble( "precio", libro.getPrecio() );

                Intent i = new Intent(context, ManageProduct.class );
                i.putExtras( bolsa );
                startActivity( i );

            } else {
                Toast.makeText(context,"No existe el libro con ese titulo", Toast.LENGTH_LONG).show();
            }
        }
    }

    private Libro buscarLibro(String titulo) {
        libroBD = new LibroBD(context,"LibrosBD.db", null,1);
        Libro libro = libroBD.elemento(titulo);

        return  libro;
    }
}