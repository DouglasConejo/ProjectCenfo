package Proxy.Implementacion;
import Decorador.Componente.Personaje;
import Proxy.Interface.iPersonajeFunciones;
import javax.swing.*;

public class PersonajeFuncionesProxy implements iPersonajeFunciones {
    PersonajeFunciones pf = new PersonajeFunciones();

    public PersonajeFuncionesProxy(){}

    @Override
    public void cargarImagen(ImageIcon icon) {
        if (icon != null){
            pf.cargarImagen(icon);
            getLabel().setIcon(icon);
        }
    }

    @Override
    public void setTipoPersonaje(Personaje tipoPersonaje) {
        if (tipoPersonaje != null){
            pf.setTipoPersonaje(tipoPersonaje);
        }
    }

    @Override
    public void setLibreOcupado(boolean ocupado) {
        pf.setLibreOcupado(ocupado);
    }

    public void setLabel(JLabel in){
        pf.setPanelPressed(in);
    }
    public JLabel getLabel(){
        return pf.getPanelPressed();
    }
}