package FacadeStrategy.Strategy.Clases;
import FacadeStrategy.Strategy.Base.AbstractPrefa;
import static SwingTablero.JuegoTablero.*;
import static SwingTablero.JuegoTablero.getColorCasilla;

public class Ele extends AbstractPrefa {
//Falta actualizar el equals en el resto de clases.
    @Override
    public boolean shape(int forma, String columna, int renglon, String color) {
        String parseLocation = columna + renglon;
        boolean figuraAgregada = false;
        switch (forma) {
            case 1 -> {
                pintarCuadrado(columna, renglon, color);//Pintar el eje
                pintarCuadrado(columna, renglon + 1, color);
                pintarCuadrado(columna, renglon + 2, color);
                pintarCuadrado(sumaRestaLetras(columna, 1), renglon + 2, color);
                pintarCuadrado(sumaRestaLetras(columna, 2), renglon + 2, color);
                figuraAgregada = true;
            }
            case 2 -> {
                pintarCuadrado(columna, renglon, color);//Pintar el eje
                pintarCuadrado(sumaRestaLetras(columna, -1), renglon, color);
                pintarCuadrado(sumaRestaLetras(columna, -2), renglon, color);
                pintarCuadrado(sumaRestaLetras(columna, -2), renglon + 1, color);
                pintarCuadrado(sumaRestaLetras(columna, -2), renglon + 2, color);
                figuraAgregada = true;
            }
            case 3 -> {
                pintarCuadrado(columna, renglon, color);//Pintar el eje
                pintarCuadrado(columna, renglon - 1, color);
                pintarCuadrado(columna, renglon - 2, color);
                pintarCuadrado(sumaRestaLetras(columna, -1), renglon - 2, color);
                pintarCuadrado(sumaRestaLetras(columna, -2), renglon - 2, color);
                figuraAgregada = true;
            }
            case 4 -> {
                pintarCuadrado(columna, renglon, color);//Pintar el eje
                pintarCuadrado(sumaRestaLetras(columna, 1), renglon, color);
                pintarCuadrado(sumaRestaLetras(columna, 2), renglon, color);
                pintarCuadrado(sumaRestaLetras(columna, 2), renglon - 1, color);
                pintarCuadrado(sumaRestaLetras(columna, 2), renglon - 2, color);
                figuraAgregada = true;
            }
            default -> System.out.println("Figura L no encontrada");
        }
        return figuraAgregada;
    }

    @Override
    public boolean validateShape(int forma, String columna, int renglon, String color) {
        boolean caminoConectado = false;
        boolean espacioDisponible = false;
        switch (forma) {
            case 1 -> {
                if (getColorCasilla(columna, renglon-1).equalsIgnoreCase(color) || //1 arriba
                getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase(color) || //1 izq
                getColorCasilla(sumaRestaLetras(columna, -1), renglon + 1).equalsIgnoreCase(color) || //izq-abajo
                getColorCasilla(sumaRestaLetras(columna, -1), renglon + 2).equalsIgnoreCase(color) || //izq-2abajo
                getColorCasilla(columna, renglon + 3).toUpperCase().equalsIgnoreCase(color) || //3 abajo
                getColorCasilla(sumaRestaLetras(columna, 1), renglon + 3).equalsIgnoreCase(color) || // der-3abajo
                getColorCasilla(sumaRestaLetras(columna, 2), renglon + 3).equalsIgnoreCase(color) || //2der-3abajo
                getColorCasilla(sumaRestaLetras(columna, 3), renglon + 2).equalsIgnoreCase(color) || //2abajo-3der
                getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase(color) || //1 der
                getColorCasilla(sumaRestaLetras(columna, 1), renglon + 1).equalsIgnoreCase(color) || //1der-abajo
                getColorCasilla(sumaRestaLetras(columna, 2), renglon + 1).equalsIgnoreCase(color)) { //2der-abajo
                    caminoConectado = true;
                }
                if (renglon < 18 && (!columna.equalsIgnoreCase("T") && !columna.equals("S"))) {
                    if (getColorCasilla(columna, renglon + 1).equals("White") &&
                    getColorCasilla(columna, renglon + 2).equals("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 1), renglon + 2).equals("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 2), renglon + 2).equals("White") &&
                    getColorCasilla(columna, renglon).equals("White")) {//Eje
                        espacioDisponible = true;
                    }
                }
            }
            case 2 -> {
                if (getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase(color) || //1 der
                getColorCasilla(columna, renglon - 1).equalsIgnoreCase(color) || //1 arriba
                getColorCasilla(sumaRestaLetras(columna, -1), renglon - 1).equalsIgnoreCase(color) || //1 arriba-iz
                getColorCasilla(sumaRestaLetras(columna, -2), renglon - 1).equalsIgnoreCase(color) || //1 arriba-2 iz
                getColorCasilla(sumaRestaLetras(columna, -3), renglon).equalsIgnoreCase(color) || //3izq
                getColorCasilla(sumaRestaLetras(columna, -3), renglon + 1).equalsIgnoreCase(color) || //3 iz-1 abajo
                getColorCasilla(sumaRestaLetras(columna, -3), renglon + 2).equalsIgnoreCase(color) || // 3iz-2 abajo
                getColorCasilla(sumaRestaLetras(columna, -2), renglon + 3).equalsIgnoreCase(color) || //2iz-3abajo
                getColorCasilla(columna, renglon + 1).equalsIgnoreCase(color) || //1 abajo
                getColorCasilla(sumaRestaLetras(columna, -1), renglon + 1).equalsIgnoreCase(color) || //1 abajo-iz
                getColorCasilla(sumaRestaLetras(columna, -1), renglon + 2).equalsIgnoreCase(color)) {//1iz-2 abajo
                    caminoConectado = true;
                }
                if (renglon < 18 && (!columna.equalsIgnoreCase("A") && !columna.equalsIgnoreCase("B"))) {
                    if (getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase("White") &&
                            getColorCasilla(sumaRestaLetras(columna, -2), renglon).equalsIgnoreCase("White") &&
                            getColorCasilla(sumaRestaLetras(columna, -2), renglon + 1).equalsIgnoreCase("White") &&
                            getColorCasilla(sumaRestaLetras(columna, -2), renglon + 2).equalsIgnoreCase("White") &&
                            getColorCasilla(columna, renglon).equalsIgnoreCase(color)) {//Eje
                        espacioDisponible = true;
                    }
                }
            }
            case 3 -> {
                if (getColorCasilla(columna, renglon + 1).equalsIgnoreCase(color) || //1abajo
                        getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase(color) || //1 iz
                        getColorCasilla(sumaRestaLetras(columna, -1), renglon - 1).equalsIgnoreCase(color) || //1 arriba-1 iz
                        getColorCasilla(sumaRestaLetras(columna, -2), renglon - 1).equalsIgnoreCase(color) || //2 iz-arriba
                        getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase(color) || //1 der
                        getColorCasilla(sumaRestaLetras(columna, 1), renglon - 1).equalsIgnoreCase(color) || //1der-arriba
                        getColorCasilla(sumaRestaLetras(columna, 1), renglon - 2).equalsIgnoreCase(color) || //1der-2arriba
                        getColorCasilla(columna, renglon - 3).equalsIgnoreCase(color) || //3 arriba
                        getColorCasilla(sumaRestaLetras(columna, -1), renglon - 3).equalsIgnoreCase(color) || //3 arriba-iz
                        getColorCasilla(sumaRestaLetras(columna, -2), renglon - 3).equalsIgnoreCase(color) || //3 arriba-2 iz
                        getColorCasilla(sumaRestaLetras(columna, -3), renglon - 2).equalsIgnoreCase(color)) { //2 arriba-3iz
                    caminoConectado = true;
                }
                if (renglon > 1 && (!columna.equalsIgnoreCase("A") && !columna.equalsIgnoreCase("B"))) {
                    if (getColorCasilla(columna, renglon - 1).equalsIgnoreCase("White") &&
                            getColorCasilla(columna, renglon - 2).equalsIgnoreCase("White") &&
                            getColorCasilla(sumaRestaLetras(columna, -1), renglon - 2).equalsIgnoreCase("White") &&
                            getColorCasilla(sumaRestaLetras(columna, -2), renglon - 2).equalsIgnoreCase("White") &&
                            getColorCasilla(columna, renglon).equalsIgnoreCase("White")) {//Eje
                        espacioDisponible = true;
                    }
                }
            }
            case 4 -> {
                if (getColorCasilla(columna, renglon + 1).equalsIgnoreCase(color) || //1abajo
                getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase(color) || //1 iz
                getColorCasilla(sumaRestaLetras(columna, 1), renglon + 1).equalsIgnoreCase(color) || //1 abajo-der
                getColorCasilla(sumaRestaLetras(columna, 2), renglon + 1).equalsIgnoreCase(color) || //1 abajo-2der
                getColorCasilla(sumaRestaLetras(columna, 3), renglon).equalsIgnoreCase(color) || //3 der
                getColorCasilla(sumaRestaLetras(columna, 3), renglon - 1).equalsIgnoreCase(color) || //3der-arriba
                getColorCasilla(sumaRestaLetras(columna, 3), renglon - 2).equalsIgnoreCase(color) || //3der-2arriba
                getColorCasilla(sumaRestaLetras(columna, 2), renglon - 3).equalsIgnoreCase(color) || //2der-3arriba
                getColorCasilla(columna, renglon - 1).equalsIgnoreCase(color) || //1 arriba
                getColorCasilla(sumaRestaLetras(columna, -1), renglon - 1).equalsIgnoreCase(color) || //1 arriba-1 iz
                getColorCasilla(sumaRestaLetras(columna, -1), renglon - 2).equalsIgnoreCase(color)) { //2 arriba-iz
                    caminoConectado = true;
                }
                if (renglon > 1 && (!columna.equalsIgnoreCase("T") && !columna.equalsIgnoreCase("S"))) {
                    if (getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 2), renglon).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 2), renglon - 1).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 2), renglon - 2).equalsIgnoreCase("White") &&
                    getColorCasilla(columna, renglon).equalsIgnoreCase("White")) {//Eje
                        espacioDisponible = true;
                    }
                }
            }
            default -> System.out.println("Error");
        }
        return caminoConectado && espacioDisponible;
        //return true;
    }
}