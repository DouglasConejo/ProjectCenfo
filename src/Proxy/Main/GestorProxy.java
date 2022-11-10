package Proxy.Main;
import Decorador.Componente_Concreto.Artillero;
import Decorador.Componente_Concreto.Infanteria;
import Decorador.Componente_Concreto.Tanque;
import Decorador.Gestor_Decorador.GestorAtaque;
import Proxy.Implementacion.PersonajeFuncionesProxy;
import SwingTablero.JuegoTablero;
import javax.swing.*;
import java.util.Objects;

public class GestorProxy {
    PersonajeFuncionesProxy pfp = new PersonajeFuncionesProxy();
    GestorAtaque gestorAtaque = new GestorAtaque();

    public void iniciarIcon(String color, String tipoPersonaje){
        switch (tipoPersonaje){
            case "ARTILLERO":
                if (color.equalsIgnoreCase("gray")){
                    pfp.cargarImagen(new ImageIcon(Objects.requireNonNull(JuegoTablero.class.getResource("grayA.png"))));
                } else {
                    pfp.cargarImagen(new ImageIcon(Objects.requireNonNull(JuegoTablero.class.getResource("brownA.png"))));
                }
                break;
            case "TANQUE":
                if (color.equalsIgnoreCase("gray")){
                    pfp.cargarImagen(new ImageIcon(Objects.requireNonNull(JuegoTablero.class.getResource("grayT.png"))));
                } else {
                    pfp.cargarImagen(new ImageIcon(Objects.requireNonNull(JuegoTablero.class.getResource("brownT.png"))));
                }
                break;
            case "INFANTERIA":
                if (color.equalsIgnoreCase("gray")){
                    pfp.cargarImagen(new ImageIcon(Objects.requireNonNull(JuegoTablero.class.getResource("grayI.png"))));
                } else {
                    pfp.cargarImagen(new ImageIcon(Objects.requireNonNull(JuegoTablero.class.getResource("brownI.png"))));
                }
                break;
        }
    }

    public void pintarPersonaje(String columna, int renglon, String personaje, int player){
        JLabel panelPressed = JuegoTablero.getPanel(columna, renglon);
        pfp.setLabel(panelPressed);
        if (player == 1){
            iniciarIcon("BROWN", personaje);
        } else {
            iniciarIcon("GRAY", personaje);
        }

        switch (personaje) {
            case "ARTILLERO" -> {
                JuegoTablero.getCuadrado(columna, renglon).setArtillero((Artillero) gestorAtaque.nuevaPersona(1, 1));
                JuegoTablero.getCuadrado(columna, renglon).setOcupado(true);
                JuegoTablero.getCuadrado(columna, renglon).setPersonaje("ARTILLERO");
            }
            case "TANQUE" -> {
                JuegoTablero.getCuadrado(columna, renglon).setTanque((Tanque) gestorAtaque.nuevaPersona(3, 3));
                JuegoTablero.getCuadrado(columna, renglon).setOcupado(true);
                JuegoTablero.getCuadrado(columna, renglon).setPersonaje("TANQUE");
            }
            case "INFANTERIA" -> {
                JuegoTablero.getCuadrado(columna, renglon).setInfanteria((Infanteria) gestorAtaque.nuevaPersona(2, 2));
                JuegoTablero.getCuadrado(columna, renglon).setOcupado(true);
                JuegoTablero.getCuadrado(columna, renglon).setPersonaje("INFANTERIA");
            }
        }
    }
}