package FacadeStrategy.Strategy.Clases;
import FacadeStrategy.Strategy.Base.AbstractPrefa;

import static SwingTablero.JuegoTablero.*;
import static SwingTablero.JuegoTablero.getColorCasilla;

public class Te extends AbstractPrefa {
    @Override
    public boolean shape(int forma, String columna, int renglon, String color) {
        String parseLocation = columna + renglon;
        boolean figuraAgregada = true;
        switch (forma) {
            case 1 -> {
                pintarCuadrado(columna, renglon, color);//Pintar el eje
                pintarCuadrado(columna, renglon - 1, color);
                pintarCuadrado(columna, renglon + 1, color);
                pintarCuadrado(sumaRestaLetras(columna, -1), renglon + 1, color);
                pintarCuadrado(sumaRestaLetras(columna, 1), renglon + 1, color);
            }
            case 2 -> {
                pintarCuadrado(columna, renglon, color);//Pintar el eje
                pintarCuadrado(sumaRestaLetras(columna, 1), renglon, color);
                pintarCuadrado(sumaRestaLetras(columna, -1), renglon, color);
                pintarCuadrado(sumaRestaLetras(columna, -1), renglon - 1, color);
                pintarCuadrado(sumaRestaLetras(columna, -1), renglon + 1, color);
            }
            case 3 -> {
                pintarCuadrado(columna, renglon, color);//Pintar el eje
                pintarCuadrado(columna, renglon + 1, color);
                pintarCuadrado(columna, renglon - 1, color);
                pintarCuadrado(sumaRestaLetras(columna, -1), renglon - 1, color);
                pintarCuadrado(sumaRestaLetras(columna, 1), renglon - 1, color);

            }
            case 4 -> {
                pintarCuadrado(columna, renglon, color);//Pintar el eje
                pintarCuadrado(sumaRestaLetras(columna, -1), renglon, color);
                pintarCuadrado(sumaRestaLetras(columna, 1), renglon, color);
                pintarCuadrado(sumaRestaLetras(columna, 1), renglon + 1, color);
                pintarCuadrado(sumaRestaLetras(columna, 1), renglon - 1, color);
            }
            default -> figuraAgregada = false;
        }
        return figuraAgregada;
    }

    @Override
    public boolean validateShape(int forma, String columna, int renglon, String color) {
        boolean caminoConectado = false;
        boolean espacioDisponible = false;
        switch (forma) {
            case 1 -> {
                if (getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase(color) || // 1 iz
                getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase(color) || // 1 der
                getColorCasilla(sumaRestaLetras(columna, -1), renglon-1).equalsIgnoreCase(color) || // 1 iz-arriba
                getColorCasilla(sumaRestaLetras(columna, 1), renglon-1).equalsIgnoreCase(color) || //1 der-arriba
                getColorCasilla(columna, renglon-2).equalsIgnoreCase(color) || // 2 arriba
                getColorCasilla(columna, renglon+2).equalsIgnoreCase(color) || // 2 abajo
                getColorCasilla(sumaRestaLetras(columna, -1), renglon+2).equalsIgnoreCase(color) || // 2 abajo-iz
                getColorCasilla(sumaRestaLetras(columna, 1), renglon+2).equalsIgnoreCase(color) || // 2 abajo-der
                getColorCasilla(sumaRestaLetras(columna, -2), renglon+1).equalsIgnoreCase(color) || // 2 iz-abajo
                getColorCasilla(sumaRestaLetras(columna, 2), renglon+1).equalsIgnoreCase(color)){// 2 der-abajo
                    caminoConectado = true;
                }
                if ((renglon < 19 && renglon > 0) && (!columna.equals("A") && !columna.equals("T"))) {
                    if (getColorCasilla(columna, renglon-1).equalsIgnoreCase("White") &&
                    getColorCasilla(columna, renglon + 1).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, -1), renglon+1).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 1), renglon+1).equalsIgnoreCase("White") &&
                    getColorCasilla(columna, renglon).equalsIgnoreCase("White")){//Eje
                        espacioDisponible = true;
                    }
                }
            }
            case 2 -> {
                if (getColorCasilla(columna, renglon-1).equalsIgnoreCase(color) || // 1 arriba
                getColorCasilla(columna, renglon+1).equalsIgnoreCase(color) || // 1 abajo
                getColorCasilla(sumaRestaLetras(columna, 1), renglon-1).equalsIgnoreCase(color) || //1 der-arriba
                getColorCasilla(sumaRestaLetras(columna, 1), renglon+1).equalsIgnoreCase(color) || //1 der-abajo
                getColorCasilla(sumaRestaLetras(columna, 2), renglon).equalsIgnoreCase(color) || // 2 der
                getColorCasilla(sumaRestaLetras(columna, -2), renglon).equalsIgnoreCase(color) || // 2 iz
                getColorCasilla(sumaRestaLetras(columna, -2), renglon-1).equalsIgnoreCase(color) || // 2 iz-arriba
                getColorCasilla(sumaRestaLetras(columna, -2), renglon+1).equalsIgnoreCase(color) || // 2 iz-abajo
                getColorCasilla(sumaRestaLetras(columna, -1), renglon-2).equalsIgnoreCase(color) || //2 arriba-iz
                getColorCasilla(sumaRestaLetras(columna, -1), renglon+2).equalsIgnoreCase(color)){// 2 abajo-iz
                    caminoConectado = true;
                }
                if ((renglon > 0 && renglon < 19) && (!columna.equals("T") && !columna.equals("A"))) {
                    if (getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, -1), renglon-1).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, -1), renglon+1).equalsIgnoreCase("White") &&
                    getColorCasilla(columna, renglon).equalsIgnoreCase("White")){//Eje
                        espacioDisponible = true;
                    }
                }
            }
            case 3 -> {
                if (getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase(color) || // 1 der
                getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase(color) || // 1 iz
                getColorCasilla(sumaRestaLetras(columna, -1), renglon+1).equalsIgnoreCase(color) || // 1 iz-abajo
                getColorCasilla(sumaRestaLetras(columna, 1), renglon+1).equalsIgnoreCase(color) || //1 der-abajo
                getColorCasilla(columna, renglon+2).equalsIgnoreCase(color) || // 2 abajo
                getColorCasilla(columna, renglon-2).equalsIgnoreCase(color) || // 2 arriba
                getColorCasilla(sumaRestaLetras(columna, -1), renglon-2).equalsIgnoreCase(color) || // 2 arriba-iz
                getColorCasilla(sumaRestaLetras(columna, 1), renglon-2).equalsIgnoreCase(color) || // 2 arriba-der
                getColorCasilla(sumaRestaLetras(columna, -2), renglon-1).equalsIgnoreCase(color) || // 2 iz-arriba
                getColorCasilla(sumaRestaLetras(columna, 2), renglon-1).equalsIgnoreCase(color)){// 2 der-arriba
                    caminoConectado = true;
                }
                if ((renglon > 0 && renglon < 19) && (!columna.equals("T") && !columna.equals("A"))) {
                    if (getColorCasilla(columna, renglon+1).equalsIgnoreCase("White") &&
                    getColorCasilla(columna, renglon-1).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, -1), renglon-1).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 1), renglon-1).equalsIgnoreCase("White") &&
                    getColorCasilla(columna, renglon).equalsIgnoreCase("White")){//Eje
                        espacioDisponible = true;
                    }
                }
            }
            case 4 -> {
                if (getColorCasilla(columna, renglon+1).equalsIgnoreCase(color) || // 1 abajo
                getColorCasilla(columna, renglon-1).equalsIgnoreCase(color) || // 1 arriba
                getColorCasilla(sumaRestaLetras(columna, -1), renglon-1).equalsIgnoreCase(color) || //1 iz-arriba
                getColorCasilla(sumaRestaLetras(columna, -1), renglon+1).equalsIgnoreCase(color) || //1 iz-abajo
                getColorCasilla(sumaRestaLetras(columna, -2), renglon).equalsIgnoreCase(color) || // 2 iz
                getColorCasilla(sumaRestaLetras(columna, 2), renglon).equalsIgnoreCase(color) || // 2 der
                getColorCasilla(sumaRestaLetras(columna, 2), renglon-1).equalsIgnoreCase(color) || // 2 der-arriba
                getColorCasilla(sumaRestaLetras(columna, 2), renglon+1).equalsIgnoreCase(color) || // 2 der-abajo
                getColorCasilla(sumaRestaLetras(columna, 1), renglon-2).equalsIgnoreCase(color) || //2 arriba-der
                getColorCasilla(sumaRestaLetras(columna, 1), renglon+2).equalsIgnoreCase(color)){// 2 abajo-der
                    caminoConectado = true;
                }
                if ((renglon > 0 && renglon < 19) && (!columna.equals("T") && !columna.equals("A"))) {
                    if (getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 1), renglon+1).equalsIgnoreCase("White") &&
                    getColorCasilla(sumaRestaLetras(columna, 1), renglon-1).equalsIgnoreCase("White") &&
                    getColorCasilla(columna, renglon).equalsIgnoreCase("White")){//Eje
                        espacioDisponible = true;
                    }
                }
            }
            default -> System.out.println("Error");
        }
        return caminoConectado && espacioDisponible;
    }
}
