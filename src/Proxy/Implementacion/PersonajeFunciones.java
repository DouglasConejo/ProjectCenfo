package Proxy.Implementacion;
import Decorador.Componente.Personaje;
import Proxy.Interface.iPersonajeFunciones;
import javax.swing.*;

public class PersonajeFunciones implements iPersonajeFunciones {
    ImageIcon icon;
    Personaje personaje;
    boolean ocupado;
    JLabel panelPressed;

    public PersonajeFunciones(){}

    @Override
    public void cargarImagen(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public void setTipoPersonaje(Personaje tipoPersonaje) {
        this.personaje = tipoPersonaje;
    }

    @Override
    public void setLibreOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public JLabel getPanelPressed() {
        return panelPressed;
    }
    public void setPanelPressed(JLabel panelPressed) {
        this.panelPressed = panelPressed;
    }
}