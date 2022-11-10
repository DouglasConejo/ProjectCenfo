package Decorador.Decorador;

import Decorador.Componente.Personaje;

/**
 * En esta clase, es donde se estara conectando lo que son los 3 componentes concretos con los ataques
 * **/

public abstract class ObjDecorado extends Personaje {
    /**
     * Atributo que llama al personaje
     * **/
    protected Personaje pArmada;

    /**
     * Metodo para obtener al personaje
     * **/
    public Personaje getPersonaje(){
        return pArmada;
    }
}