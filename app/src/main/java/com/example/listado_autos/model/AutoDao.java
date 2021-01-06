package com.example.listado_autos.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.listado_autos.model.Auto;
import java.util.List;

@Dao
public interface AutoDao {
    @Query("SELECT * FROM auto")
    List<Auto> getAll();

    @Query("SELECT * FROM auto WHERE id IN (:userIds)")
    List<Auto> loadAllByIds(long[] userIds);

    @Query("SELECT * FROM auto WHERE marca LIKE :marca AND " +
            "modelo LIKE :modelo AND " + "anio LIKE :anio AND " + "km LIKE :km LIMIT 1")
    Auto findByName(String marca, String modelo, String anio, String km);

    @Insert
    void insertAll(Auto... autos);

    @Insert
    void insert(Auto auto);

    @Delete
    void delete(Auto auto);


}
