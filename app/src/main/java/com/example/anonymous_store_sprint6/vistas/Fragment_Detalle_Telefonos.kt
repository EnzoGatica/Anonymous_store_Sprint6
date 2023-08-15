package com.example.anonymous_store_sprint6.vistas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.anonymous_store_sprint6.databinding.FragmentDetalleTelefonoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"

class Fragment_Detalle_Telefonos : Fragment() {


    private val cellVM: CellViewModel by activityViewModels()
    lateinit var binding: FragmentDetalleTelefonoBinding
    private var param1: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleTelefonoBinding.inflate(layoutInflater,container,false)
        cellVM.getDetalleTelefonoVM(param1)
        //cellVM.getDetalleTelefonoVM(param1).invokeOnCompletion {}
        cellVM.detalleLiveData(param1).observe(viewLifecycleOwner){
            if(it != null) {
                binding.txtNombreDetalle.text = it.name
                binding.txtPrecioDetalle.text = it.price.toString()
                binding.txtUltimoPrecioDetalle.text = it.lastPrice.toString()
                binding.txtDescripcionDetalle.text = it.description
                if (!it.credit){
                    binding.txtCredit.text = "SOLO EFECTIVO"
                }else{
                    binding.txtCredit.text = "ACEPTA CREDITO"
                }
                binding.imgDetalle.load(it.image)
            }

        }

        //"buttonEmailMe" es el id del boton
        binding.editTextEmailBody.setText(
            "Hola \n" +
                    " Vi la propiedad {PRODUCT_NAME} de código {PRODUCT_ID} y me gustaría \n " +
                    "que me contactaran a este correo o " +
                    "al siguiente número Quedo atento."
        )

        binding.buttonEmailMe!!.setOnClickListener {
            //mail cliente
            val email = "miemail@gmail.com"
            val intentEmail = Intent(Intent.ACTION_SEND, Uri.parse(email))
            intentEmail.type = "plain/text"
            //Titulo Mail
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, binding.editTextEmail.text.toString())
            //Body Mail
            intentEmail.putExtra(Intent.EXTRA_TEXT, binding.editTextEmailBody.text.toString())
            //correo a donde llegan
            intentEmail.putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf("correo@gmail.com", "otrocorreo@gmail.com")
            )
            startActivity(Intent.createChooser(intentEmail, "Elige cliente de correo"))
        }

        return binding.root
    }


}