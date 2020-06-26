package com.example.examen2_jonathan_rodriguez_osorio

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen2_jonathan_rodriguez_osorio.Adaptador.AdaptadorPaciente
import com.example.examen2_jonathan_rodriguez_osorio.Bean.PacienteBean
import com.example.examen2_jonathan_rodriguez_osorio.Tools.Constantes
import com.example.examen2_jonathan_rodriguez_osorio.data.PacienteDAL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var oListaPaciente:ArrayList<PacienteBean>
    lateinit var oAdaptadorPaciente: AdaptadorPaciente
    lateinit var oNuevoPAciente: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oListaPaciente= ArrayList<PacienteBean>()
        oListaPaciente.add(PacienteBean(1,"71656481","Jonathan","Rodriguez",
            "DR.Rodriguez","400","25/06/2020"))

        var oPacienteDAL:PacienteDAL=PacienteDAL()
        oListaPaciente=oPacienteDAL.Lista(PacienteBean())
        oAdaptadorPaciente = AdaptadorPaciente(oListaPaciente.toList())
        {
            Toast.makeText(this,"PAciente Seleccionado"+it.DNI, Toast.LENGTH_LONG).show()
        }
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        lvListaPaciente.setLayoutManager(llm)
        lvListaPaciente.setHasFixedSize(true)
        lvListaPaciente.setAdapter(oAdaptadorPaciente)


    }

    public fun btnCargarDialogo_onclick(v:View)
    {
        oNuevoPAciente = Dialog(this)
        oNuevoPAciente.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoPAciente.setCancelable(false)
        oNuevoPAciente.setContentView(R.layout.activity_nuevo_paciente)
        val obtnagregarNuevopaci = oNuevoPAciente.findViewById(R.id.btnagregarNuevopaci) as Button
        val obtnCancelarNuevopaci = oNuevoPAciente.findViewById(R.id.btnCancelarNuevopaci) as Button
        obtnagregarNuevopaci.setOnClickListener{
            GrabarRegistro()
            oNuevoPAciente.dismiss() }
        obtnCancelarNuevopaci.setOnClickListener { oNuevoPAciente.dismiss() }
        oNuevoPAciente.show()
    }

    private fun GrabarRegistro()
    {
        var oedtdninuevo:EditText =(oNuevoPAciente.findViewById(R.id.edtdninuevo) as EditText)
        var oedtnombrenuevo:EditText =(oNuevoPAciente.findViewById(R.id.edtnombrenuevo) as EditText)
        var oedtmotivonuevo:EditText =(oNuevoPAciente.findViewById(R.id.edtmotivonuevo) as EditText)
        var oedtdoctornuevo:EditText =(oNuevoPAciente.findViewById(R.id.edtdoctornuevo) as EditText)
        var oedtcostonuevo:EditText =(oNuevoPAciente.findViewById(R.id.edtcostonuevo) as EditText)
        var oedtfechanuevo:EditText =(oNuevoPAciente.findViewById(R.id.edtfechanuevo) as EditText)
        var oPacienteBean:PacienteBean= PacienteBean(oListaPaciente.size,
            oedtdninuevo.text.toString(),
            oedtnombrenuevo.text.toString(),
            oedtmotivonuevo.text.toString(),
            oedtdoctornuevo.text.toString(),
            oedtcostonuevo.text.toString(),
            oedtfechanuevo.text.toString())

        var oPacienteDAL:PacienteDAL= PacienteDAL()
        oPacienteDAL.RegistraModifica(oPacienteBean,Constantes.NUEVO_REGISTRO)
        oListaPaciente.add(oPacienteBean)

        oAdaptadorPaciente= AdaptadorPaciente(oListaPaciente.toList())
        {
            Toast.makeText(this,"PAciente Seleccionado:"+it.DNI,Toast.LENGTH_LONG).show()
        }
        lvListaPaciente.setAdapter(oAdaptadorPaciente)
    }

}

