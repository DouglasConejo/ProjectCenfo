package FacadeStrategy.Strategy.Base;
import SwingTablero.JuegoTablero;

public abstract class AbstractPrefa implements iPrefa{
    private String msj;
    @Override
    public abstract boolean shape(int forma, String columna, int renglon, String color);

    @Override
    public String mensaje() {
        return msj;
    }
    public void setMsj(String msj) {
        this.msj = msj;
    }

    public abstract  boolean validateShape(int forma, String columna, int renglon, String color);

    public void imprimirPrefa(int forma, String columna, int renglon, String color){
        if (validateShape(forma, columna, renglon, color)){
            if (shape(forma, columna, renglon, color)) {
                setMsj("Figura impresa exitosamente");
            } else
                setMsj("La figura no puede exceder las casillas del tablero");
        } else {
            setMsj("Debes conectar tu camino y no construir uno donde ya existe.");
        }
    }

    /**
     * Funcion para sumar o restar letras, se utiliza para pintar las figuras. Retorna "" si la letra excede el tablero
     * @param letra Se ingresa la letra a la cual restarle
     * @param operacion Sumar o restar unicamente
     * @return retorna la letra una vez aplicada la operacion
     */
    static public String sumaRestaLetras(String letra, int operacion){
        String returnLetra = "";
        String[] array = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T" };
        int indice = JuegoTablero.buscarColumna(letra);
        indice = indice + operacion;
        if (indice >= array.length || indice < 0)
            return "Z";
        else {
            returnLetra = array[indice];
            return returnLetra;
        }
    }
}