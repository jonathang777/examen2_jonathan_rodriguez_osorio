package com.example.examen2_jonathan_rodriguez_osorio.data

import android.database.sqlite.SQLiteDatabase

open class ClaseBase {

    public fun CadenaConexion():String
    {
        return  "/data/data/com.example.examen2_jonathan_rodriguez_osorio/examen.db"
    }

    public fun CrearBaseDatos()
    {
        var odb: SQLiteDatabase = SQLiteDatabase.openDatabase(
            CadenaConexion(),
            null,
            SQLiteDatabase.CREATE_IF_NECESSARY)
        odb.execSQL("CREATE TABLE IF NOT EXISTS Paciente(Codigo int, DNI varchar(8), " +
                "Nombre varchar(500)," +
                "Motivo varchar(500),"+
                "Doctor varchar(500),"+
                "Costo varchar(500),"+
                "Fecha varchar(500))")
    }

}