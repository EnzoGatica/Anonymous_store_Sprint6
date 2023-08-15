package com.example.anonymous_store_sprint6.vistas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.anonymous_store_sprint6.data.local.TelefonoEntity
import com.example.anonymous_store_sprint6.databinding.ItemCellBinding

class AdapterCell: RecyclerView.Adapter<AdapterCell.ItemTelefonoViewHolder>() {

    lateinit var binding: ItemCellBinding
    private val listItemCelulares = mutableListOf<TelefonoEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTelefonoViewHolder {
        binding = ItemCellBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ItemTelefonoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemCelulares.size
    }

    override fun onBindViewHolder(holder: ItemTelefonoViewHolder, position: Int) {
        val celulares = listItemCelulares[position]
        holder.bind(celulares)
    }

    fun setData(telefonoEntity: List<TelefonoEntity>){
        this.listItemCelulares.clear()
        this.listItemCelulares.addAll(telefonoEntity)
        notifyDataSetChanged()
    }

    class ItemTelefonoViewHolder(val celu : ItemCellBinding): RecyclerView.ViewHolder(celu.root) {

        fun bind(item_celu: TelefonoEntity){
            celu.txtNombre.text = item_celu.name
            celu.txtPrecio.text = item_celu.price.toString()
            celu.imgCell.load(item_celu.image)
        }

    }
}