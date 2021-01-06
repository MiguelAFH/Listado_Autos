package com.example.listado_autos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listado_autos.model.AppDatabase;
import com.example.listado_autos.model.Auto;
import com.example.listado_autos.model.AutoDao;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Auto> autos = new ArrayList<>();
    List<Auto> autosList;
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contexto = this;
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            AppDatabase dbAuto = Room.databaseBuilder(this, AppDatabase.class, "database-name").allowMainThreadQueries().build();
            AutoDao autoDao = dbAuto.autoDao();
            lv = findViewById(R.id.lv);
            autos = (ArrayList<Auto>) bundle.getSerializable("autos");
            Log.e("Error", "Prueba");
            for (int i = 0; i < autos.size(); i++){
                autoDao.insert(autos.get(i));
            }
            Log.e("Error", "Prueba2");
            autosList = autoDao.getAll();
            autos = new ArrayList<Auto>(autosList);

            Adaptador adaptador = new Adaptador(this, autos);
            lv.setAdapter(adaptador);
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(contexto, getString(R.string.id)+ Long.toString(id), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
