package com.example.examen2_jonathan_rodriguez_osorio.Bean

class PacienteBean{
    public enum class  CAMPOS {
    Codigo,
    DNI,
    Nombre,
    Motivo,
    Doctor,
    Costo,
    Fecha,
}
var Codigo:Int=0
var DNI:String=""
var Nombre:String =""
var Motivo:String =""
var Doctor:String=""
var Costo:String = ""
var Fecha:String =""

public constructor()
{
    this.Codigo=0
    this.DNI=""
    this.Nombre=""
    this.Motivo=""
    this.Doctor=""
    this.Costo=""
    this.Fecha=""
}


constructor(tCodigo:Int,tDNI:String,tNombre:String,tMotivo:String,tDoctor:String,tCosto:String,tFecha:String)
{
    this.Codigo=tCodigo
    this.DNI=tDNI
    this.Nombre=tNombre
    this.Motivo=tMotivo
    this.Doctor=tDoctor
    this.Costo=tCosto
    this.Fecha=tFecha
}

}