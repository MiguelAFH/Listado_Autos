package com.example.listado_autos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listado_autos.model.Auto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Llenado extends AppCompatActivity {

    Spinner spinnerMarca;
    EditText etModelo, etAnio, etKm;
    String[] marcas;
    Calendar hoy;
    int anioHoy, minId=1, maxId=4000;
    ArrayList<Auto> autos = new ArrayList<>();
    Auto nuevoAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenado);

        spinnerMarca = (Spinner) findViewById(R.id.spinnerMarca);
        etModelo = findViewById(R.id.etModelo);
        etAnio = findViewById(R.id.etAnio);
        etKm = findViewById(R.id.etKm);

        marcas = getResources().getStringArray(R.array.marcas);

        hoy = Calendar.getInstance();
        anioHoy = hoy.get(Calendar.YEAR);
    }

    public void clicAgregar(View view) {
        if (validar() == true){
            long id = (new Random()).nextInt(maxId) + minId;
            nuevoAuto = new Auto(id,
                    spinnerMarca.getSelectedItem().toString(),
                    etModelo.getText().toString(),
                    etAnio.getText().toString(),
                    etKm.getText().toString()
                    );
            autos.add(nuevoAuto);

            etModelo.setText("");
            etAnio.setText("");
            etKm.setText("");

            Toast.makeText(this, getString(R.string.agregado), Toast.LENGTH_SHORT).show();

        }

    }

    public void clicEnviar(View view) {

        if (autos.size() > 0) {
            Intent intent = new Intent(this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("autos", autos);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, getString(R.string.errorValidar), Toast.LENGTH_SHORT).show();
        }

    }

    public boolean validar(){

        boolean ok = true;

        if (spinnerMarca.getSelectedItem().toString().equals(marcas[0])){
            ok = false;
            Toast.makeText(this, getString(R.string.errorMarca), Toast.LENGTH_SHORT).show();
        }

        if (etModelo.getText().toString().equals("")){
            ok = false;
            etModelo.setError(getString(R.string.errorModelo));
        }


        if (etAnio.getText().toString().equals("")){
            ok = false;
            etAnio.setError(getString(R.string.errorAnio));
        }else{
            int anioAuto = Integer.parseInt(etAnio.getText().toString());
            if (anioAuto > anioHoy +1){
                ok = false;
                etAnio.setError(getString(R.string.errorAnio));
            }
        }

        if (etKm.getText().toString().equals("")){
            ok = false;
            etKm.setError(getString(R.string.errorKm));
        }

        return ok;

    }
}