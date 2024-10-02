package com.jah.estudiarinformatica;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spCiclo, spPoblacion, spTipo;
    TextView txtMostrar;
    Button btnBorrar;
    private String ciclo = "", poblacion = "", tipo = "", mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        spCiclo = findViewById(R.id.spCiclo);
        ArrayAdapter<CharSequence> adaptadorCiclo = ArrayAdapter.createFromResource(this, R.array.ciclo, android.R.layout.simple_spinner_dropdown_item);
        adaptadorCiclo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCiclo.setAdapter(adaptadorCiclo);

        spPoblacion = findViewById(R.id.spPoblacion);
        ArrayAdapter<CharSequence> adaptadorPoblacion = ArrayAdapter.createFromResource(this, R.array.poblacion, android.R.layout.simple_spinner_dropdown_item);
        adaptadorPoblacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPoblacion.setAdapter(adaptadorPoblacion);


        spTipo = findViewById(R.id.spTipo);
        ArrayAdapter<CharSequence> adaptadorTipo = ArrayAdapter.createFromResource(this, R.array.tipo, android.R.layout.simple_spinner_dropdown_item);
        adaptadorTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adaptadorTipo);

        txtMostrar = findViewById(R.id.txtMostrar);
        btnBorrar = findViewById(R.id.btnBorrar);

        spCiclo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciclo = spCiclo.getSelectedItem().toString();
                updateMostrar();
                Log.i("DAM", ciclo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spPoblacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               poblacion = spPoblacion.getSelectedItem().toString();
                updateMostrar();
                Log.i("DAM", poblacion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                tipo = spTipo.getSelectedItem().toString();
                updateMostrar();
                Log.i("DAM", tipo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar = "";
                txtMostrar.setText(mostrar);
                spCiclo.setAdapter(adaptadorCiclo);
                spPoblacion.setAdapter(adaptadorPoblacion);
                spTipo.setAdapter(adaptadorTipo);
            }
        });
    }

    private void updateMostrar() {
        mostrar = ciclo + " en " + poblacion + " " + tipo + ".";
        txtMostrar.setText(mostrar);
    }

}