package FacadeStrategy.Strategy.Base;

public interface iPrefa {
    /**
     * Funcion para validar o imprimir una forma o figura, segun su implementacion.
     * @param forma Debido a que una misma figura puede ser rotada, requiere de un int con la forma
     * @param columna La columna donde se encuentra el eje de la figura
     * @param renglon El renglon donde se encuentra el eje de la figura
     * @param color El color es necesario para saber cual jugador esta ejecutando la accion
     * @return Retorna un true en caso de que todo haya salido correcto
     */
    boolean shape(int forma, String columna, int renglon, String color);

    /**
     * Esta funcion se utilizara principalmente cuando la figura no pueda ser colocada en donde el jugador lo indica
     * @return Retorna un String, indicando la razon del error, o bien el exito del proceso
     */
    String mensaje();
}