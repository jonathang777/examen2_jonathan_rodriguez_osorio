package com.example.examen2_jonathan_rodriguez_osorio.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen2_jonathan_rodriguez_osorio.Bean.PacienteBean
import com.example.examen2_jonathan_rodriguez_osorio.R
import kotlinx.android.synthetic.main.registropaciente.view.*

class AdaptadorPaciente(val ListaInterna:List<PacienteBean>, val clickListener:(PacienteBean) -> Unit):
    RecyclerView.Adapter<AdaptadorPaciente.PacienteBeanHolder>(){

    var onItemClick: ((PacienteBean)->Unit)? = null
    public class  PacienteBeanHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oPacienteBean: PacienteBean)
        {
            val tvCodigoPaci = itemView.findViewById(R.id.TVCODIGO_ITEM) as TextView
            val tvDni = itemView.findViewById(R.id.TVDNI_ITEM) as TextView
            val tvNombre = itemView.findViewById(R.id.TVNOMBRE_ITEM) as TextView
            val tvMotivo = itemView.findViewById(R.id.TVMOTIVO_ITEM) as TextView
            val tvDoctor = itemView.findViewById(R.id.TVDOCTOR_ITEM) as TextView
            val tvCosto = itemView.findViewById(R.id.TVCOSTO_ITEM) as TextView
            val tvFecha = itemView.findViewById(R.id.TVFECHA_ITEM) as TextView

            tvCodigoPaci.text = oPacienteBean.Codigo.toString()
            tvDni.text = oPacienteBean.DNI
            tvNombre.text = oPacienteBean.Nombre
            tvMotivo.text = oPacienteBean.Motivo
            tvDoctor.text = oPacienteBean.Doctor
            tvCosto.text = oPacienteBean.Costo
            tvFecha.text = oPacienteBean.Fecha
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorPaciente.PacienteBeanHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.registropaciente,parent,false)
        return PacienteBeanHolder(v)
    }

    override fun getItemCount(): Int {
        return ListaInterna.size
    }

    override fun onBindViewHolder(holder: PacienteBeanHolder, position: Int) {
        holder?.itemView.TVCODIGO_ITEM?.text = ListaInterna.get(position).Codigo.toString()
        holder?.itemView.TVDNI_ITEM?.text = ListaInterna.get(position).DNI
        holder?.itemView.TVNOMBRE_ITEM?.text = ListaInterna.get(position).Nombre
        holder?.itemView.TVMOTIVO_ITEM?.text = ListaInterna.get(position).Motivo
        holder?.itemView.TVDOCTOR_ITEM?.text = ListaInterna.get(position).Doctor
        holder?.itemView.TVCOSTO_ITEM?.text =ListaInterna.get(position).Costo
        holder?.itemView.TVFECHA_ITEM?.text = ListaInterna.get(position).Fecha
        holder?.itemView.setOnClickListener()
        {
            clickListener(ListaInterna.get(position))
        }
    }
    inner class viewHolder(tVista: View):RecyclerView.ViewHolder(tVista), View.OnClickListener
    {
        init {
            tVista.setOnClickListener()
            {
                onItemClick?.invoke(ListaInterna[adapterPosition])
            }
        }

        override fun onClick(v: View?) {
            onItemClick?.invoke(ListaInterna[adapterPosition])
        }
    }
}