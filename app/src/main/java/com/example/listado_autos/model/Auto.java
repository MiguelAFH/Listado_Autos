package com.example.listado_autos.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class Auto implements Serializable {

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "marca")
    private String marca;

    @ColumnInfo(name = "modelo")
    private String modelo;

    @ColumnInfo(name = "anio")
    private String anio;

    @ColumnInfo(name = "km")
    private String km;

    public Auto(long id, String marca, String modelo, String anio, String km) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.km = km;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }
}
