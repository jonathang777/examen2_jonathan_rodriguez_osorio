package com.example.examen2_jonathan_rodriguez_osorio.data

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.examen2_jonathan_rodriguez_osorio.Bean.PacienteBean

class PacienteDAL:ClaseBase() {

    val NOMBRE_TABLA="Paciente"
    init {
        super.CrearBaseDatos()
    }
    public fun RegistraModifica(pPaci:PacienteBean,pAccion:String)
    {
        var odb: SQLiteDatabase = SQLiteDatabase.openDatabase(this.CadenaConexion(),null,
            SQLiteDatabase.CREATE_IF_NECESSARY)

        var oRegistro: ContentValues = ContentValues()
        oRegistro.put("Codigo",pPaci.Codigo)
        oRegistro.put("Dni",pPaci.DNI)
        oRegistro.put("Nombre",pPaci.Nombre)
        oRegistro.put("Motivo",pPaci.Motivo)
        oRegistro.put("Doctor",pPaci.Doctor)
        oRegistro.put("Costo",pPaci.Costo)
        oRegistro.put("Fecha",pPaci.Fecha)
        if(pAccion =="N"){
            var oresult =odb.insert(NOMBRE_TABLA,null,oRegistro).toInt()
            if(oresult == -1){

            }
        }

        else if (pAccion=="A"){
            var oresult = odb.update(
                NOMBRE_TABLA,
                oRegistro,
                "Codigo="+pPaci.Codigo.toString(),
                null).toInt()
            if(oresult == -1){

            }
        }
        odb.close()
    }

    public fun Lista(pPaci: PacienteBean):ArrayList<PacienteBean>
    {
        var oLista=ArrayList<PacienteBean>()
        var odb: SQLiteDatabase = SQLiteDatabase.openDatabase(this.CadenaConexion(),null,
            SQLiteDatabase.CREATE_IF_NECESSARY)
        var oTabla: Cursor =odb.rawQuery("Select * from " + NOMBRE_TABLA, null)
        if(oTabla.moveToFirst())
        {
            do{
                oLista.add(
                    PacienteBean(
                        oTabla.getInt(0),
                        oTabla.getString(1),
                        oTabla.getString(2),
                        oTabla.getString(3),
                        oTabla.getString(4),
                        oTabla.getString(5),
                        oTabla.getString(6)
                    )
                )
            }while (oTabla.moveToNext())
        }
        return oLista
    }

}