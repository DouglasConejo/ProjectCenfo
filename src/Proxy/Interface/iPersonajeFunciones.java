package Proxy.Interface;
import Decorador.Componente.Personaje;
import javax.swing.*;

public interface iPersonajeFunciones {
    public void cargarImagen(ImageIcon icon);
    public void setTipoPersonaje(Personaje tipoPersonaje);
    public void setLibreOcupado(boolean ocupado);
}