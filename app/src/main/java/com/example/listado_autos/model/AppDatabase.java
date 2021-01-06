package com.example.listado_autos.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Auto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AutoDao autoDao();
}
