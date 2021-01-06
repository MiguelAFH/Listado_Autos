package com.example.listado_autos;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listado_autos.model.Auto;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    Context contexto;
    ArrayList<Auto> autos;
    private static LayoutInflater inflater = null;
    CargaImagen cargaImagen;

    public Adaptador(Context contexto, ArrayList<Auto> autos) {
        this.contexto = contexto;
        this.autos = autos;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        cargaImagen = new CargaImagen();
    }

    @Override
    public int getCount() {
        return autos.size();
    }

    @Override
    public Object getItem(int position) {
        //return null;
        return autos.get(position);
    }

    @Override
    public long getItemId(int position) {
        //return 0;
        return autos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_auto, null);

        TextView tvMarca = vista.findViewById(R.id.tvMarca);
        TextView tvModelo = vista.findViewById(R.id.tvModelo);
        TextView tvAnio = vista.findViewById(R.id.tvAnio);
        TextView tvKm = vista.findViewById(R.id.tvKm);
        ImageView ivMarca = vista.findViewById(R.id.ivMarca);

        tvMarca.setText(autos.get(position).getMarca());
        tvModelo.setText(autos.get(position).getModelo());
        tvAnio.setText(autos.get(position).getAnio());
        tvKm.setText(autos.get(position).getKm() + contexto.getString(R.string.km));

        int dimen = 200;

        if (autos.get(position).getMarca().equals(contexto.getString(R.string.audi))){
            ivMarca.setImageBitmap(
                    cargaImagen.decodeSampledBitmapFromResource(contexto.getResources(), R.drawable.logoaudi, dimen, dimen));
        } else if (autos.get(position).getMarca().equals(contexto.getString(R.string.bmw))){
            ivMarca.setImageBitmap(
                    cargaImagen.decodeSampledBitmapFromResource(contexto.getResources(), R.drawable.logobmw, dimen, dimen));
        } else if (autos.get(position).getMarca().equals(contexto.getString(R.string.ferrari))){
            ivMarca.setImageBitmap(
                    cargaImagen.decodeSampledBitmapFromResource(contexto.getResources(), R.drawable.logoferrari, dimen, dimen));
        } else if (autos.get(position).getMarca().equals(contexto.getString(R.string.lamborghini))){
            ivMarca.setImageBitmap(
                    cargaImagen.decodeSampledBitmapFromResource(contexto.getResources(), R.drawable.logolamborghini, dimen, dimen));
        } else if (autos.get(position).getMarca().equals(contexto.getString(R.string.mercedes))){
            ivMarca.setImageBitmap(
                    cargaImagen.decodeSampledBitmapFromResource(contexto.getResources(), R.drawable.logomercedes, dimen, dimen));
        } else if (autos.get(position).getMarca().equals(contexto.getString(R.string.porsche))){
            ivMarca.setImageBitmap(
                    cargaImagen.decodeSampledBitmapFromResource(contexto.getResources(), R.drawable.logoporsche, dimen, dimen));
        }

        return vista;
    }
}
