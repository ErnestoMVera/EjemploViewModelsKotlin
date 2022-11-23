package uabc.ic.pruebaviewmodels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider

class botonesDos : Fragment(), View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    lateinit var model : SharedViewModel
    lateinit var checkBox : CheckBox
    lateinit var sliderBar : SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_botones_dos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        checkBox = view.findViewById(R.id.checkBox)
        sliderBar = view.findViewById(R.id.seekBar)
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            model.setChecked(isChecked)
        }
        sliderBar.setOnSeekBarChangeListener(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() = botonesDos()
    }

    override fun onClick(v: View?) {

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        model.setSlidebarValue(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        model.setSlidebarValue(-1)
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}