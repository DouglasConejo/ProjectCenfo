package FacadeStrategy.Strategy.Clases;
import FacadeStrategy.Strategy.Base.AbstractPrefa;

import static SwingTablero.JuegoTablero.*;

public class Cruz extends AbstractPrefa {
    @Override
    public boolean shape(int forma, String columna, int renglon, String color) {
        pintarCuadrado(columna, renglon, color);//Pinta el eje
        pintarCuadrado(sumaRestaLetras(columna, -1), renglon, color);
        pintarCuadrado(sumaRestaLetras(columna, 1), renglon, color);
        pintarCuadrado(columna, renglon + 1, color);
        pintarCuadrado(columna, renglon - 1, color);
        return true;
    }

    @Override
    public boolean validateShape(int forma, String columna, int renglon, String color) {
        boolean caminoConectado = false;
        boolean espacioDisponible = false;
        if (getColorCasilla(columna, renglon - 2).equalsIgnoreCase(color) ||
                getColorCasilla(sumaRestaLetras(columna, -2), renglon).equalsIgnoreCase(color) ||
                getColorCasilla(sumaRestaLetras(columna, 2), renglon).equalsIgnoreCase(color) ||
                getColorCasilla(columna, renglon + 2).equalsIgnoreCase(color) ||
                getColorCasilla(sumaRestaLetras(columna, -1), renglon - 1).equalsIgnoreCase(color) ||
                getColorCasilla(sumaRestaLetras(columna, 1), renglon - 1).equalsIgnoreCase(color) ||
                getColorCasilla(sumaRestaLetras(columna, -1), renglon + 1).equalsIgnoreCase(color)) { //2 arriba
            caminoConectado = true;
        }

        if ((renglon > 0 && renglon < 19) && (!columna.equals("A") && !columna.equals("T"))) {
            if (getColorCasilla(sumaRestaLetras(columna, -1), renglon).equalsIgnoreCase("White") &&//1 iz
            getColorCasilla(sumaRestaLetras(columna, 1), renglon).equalsIgnoreCase("White") &&//1 der
            getColorCasilla(columna, renglon - 1).equalsIgnoreCase("White") &&//1 arriba
            getColorCasilla(columna, renglon + 1).equalsIgnoreCase("White") &&//1 abajo
            getColorCasilla(columna, renglon).equalsIgnoreCase("White")) {//Eje
                espacioDisponible = true;
            }
        }
        return caminoConectado && espacioDisponible;
        //return true;
    }
}