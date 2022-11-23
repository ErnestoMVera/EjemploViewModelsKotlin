package uabc.ic.pruebaviewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Boolean> activado;
    private MutableLiveData<Boolean> presionado;
    private MutableLiveData<Integer> slidebarValue;
    private MutableLiveData<Boolean> checked;

    public MutableLiveData<Boolean> getActivado() {
        if(this.activado == null) {
            this.activado = new MutableLiveData<Boolean>();
            this.activado.setValue(false);
        }
        return activado;
    }

    public void setActivado(Boolean activado) {
        if(this.activado == null) {
            this.activado = new MutableLiveData<Boolean>();
            this.activado.setValue(false);
        }
        this.activado.setValue(activado);
    }

    public MutableLiveData<Boolean> getChecked() {
        if(this.checked == null) {
            this.checked = new MutableLiveData<Boolean>();
            this.checked.setValue(false);
        }
        return checked;
    }

    public void setChecked(Boolean checked) {
        if(this.checked == null) {
            this.checked = new MutableLiveData<Boolean>();
            this.checked.setValue(false);
        }
        this.checked.setValue(checked);
    }

    public MutableLiveData<Integer> getSlidebarValue() {
        if(this.slidebarValue == null) {
            this.slidebarValue = new MutableLiveData<Integer>();
            this.slidebarValue.setValue(0);
        }
        return slidebarValue;
    }

    public void setSlidebarValue(Integer slidebarValue) {
        if(this.slidebarValue == null) {
            this.slidebarValue = new MutableLiveData<Integer>();
            this.slidebarValue.setValue(0);
        }
        this.slidebarValue.setValue(slidebarValue);
    }

    public MutableLiveData<Boolean> getPresionado() {
        if(presionado == null) {
            presionado = new MutableLiveData<Boolean>();
            presionado.setValue(false);
        }
        return presionado;
    }

    public void botonPresionado() {
        if(presionado == null) {
            presionado = new MutableLiveData<Boolean>();
            presionado.setValue(false);
        }
        presionado.setValue(!presionado.getValue());
    }
}
