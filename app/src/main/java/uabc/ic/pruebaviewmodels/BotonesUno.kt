package uabc.ic.pruebaviewmodels

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BotonesUno : Fragment(), View.OnClickListener {
    lateinit var model : SharedViewModel
    lateinit var boton : Button
    lateinit var interruptor : Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_botones1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        boton = view.findViewById(R.id.button)
        boton.setOnClickListener(this)
        interruptor = view.findViewById(R.id.switch1)
        interruptor.setOnCheckedChangeListener { _, isChecked ->
            model.setActivado(isChecked)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BotonesUno()
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.button) {
            model.botonPresionado()
        }
    }
}