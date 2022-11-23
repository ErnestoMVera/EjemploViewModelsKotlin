package uabc.ic.pruebaviewmodels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var switchText : TextView
    lateinit var checkedText : TextView
    lateinit var progressText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame1, BotonesUno())
        ft.replace(R.id.frame2, botonesDos())
        ft.commit()
        switchText = findViewById(R.id.switchText)
        checkedText = findViewById(R.id.checkText)
        progressText = findViewById(R.id.sliderText)
        val viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        //Log.i("viewModel", if (viewModel == null) "true" else "false")
        viewModel.presionado.observe(this, Observer<Boolean> { _ ->
            val t = Toast.makeText(applicationContext, "presionado bro", Toast.LENGTH_SHORT).show()
        })
        viewModel.activado.observe(this, Observer<Boolean> { estaActivado ->
            switchText.text = getString(R.string.valorSwitch, if(estaActivado) "true" else "false")
        })

        viewModel.slidebarValue.observe(this, Observer { progreso ->
            sliderText.text = getString(R.string.slider, progreso)
        })
        viewModel.checked.observe(this, Observer<Boolean> { estaActivado ->
            checkedText.text = getString(R.string.valorCheckbox, if(estaActivado) "true" else "false")
        })
    }

}