package Decorador.Gestor_Decorador;

import Decorador.Componente.Personaje;
import Decorador.Componente_Concreto.Artillero;
import Decorador.Componente_Concreto.Infanteria;
import Decorador.Componente_Concreto.Tanque;
import Decorador.Decorador.ObjDecorado;
import Decorador.Decorador_Concreto.Ataque_Especial.Artillero_Concreto.Ataca2CasillasDistancia;
import Decorador.Decorador_Concreto.Ataque_Especial.Artillero_Concreto.DobleAtaque;
import Decorador.Decorador_Concreto.Ataque_Especial.Artillero_Concreto.DobleDefensa;
import Decorador.Decorador_Concreto.Ataque_Especial.Infanteria_Concreto.Healer;
import Decorador.Decorador_Concreto.Ataque_Especial.Infanteria_Concreto.Suma3PuntosAtaque;
import Decorador.Decorador_Concreto.Ataque_Especial.Infanteria_Concreto.Suma3PuntosDefensa;
import Decorador.Decorador_Concreto.Ataque_Especial.Tanque_Concreto.*;
import Decorador.Decorador_Concreto.Ataque_Normal.Ataque;
import Decorador.Decorador_Concreto.Ataque_Normal.Defensa;

import java.util.ArrayList;

public class GestorAtaque {
    private ArrayList<Personaje> global_array_persona;
    private static ArrayList<Personaje> personajesArr = new ArrayList();
    private static ArrayList<Personaje> personajesArrEnemigo = new ArrayList();



    public GestorAtaque(){
        setGlobal_array_persona(new ArrayList<Personaje>());
    }

    /**
     * Llamamos a los 3 constructores que estan en componente concreto con el ID que tiene
     * **/
    public Personaje nuevaPersona (int pID, int pTipo) {
        Personaje p = null;
        switch(pTipo) {
            case 1:
                p = new Artillero(pID);
                break;
            case 2:
                p = new Infanteria(pID);
                break;
            case 3:
                p = new Tanque(pID);
                break;

        }
        getGlobal_array_persona().add(p);

        return p;
    }


    public void decorarCategoria (int pIdCategoria, int pTipoDecoracion) {
        Personaje p = this.getPersona(pIdCategoria);
        switch(pTipoDecoracion) {
            case 1:
                replacePersona_Array(pIdCategoria,new Ataque(p));
                break;

            case 2:
                replacePersona_Array(pIdCategoria,new Defensa(p));
                break;
            case 3:
                replacePersona_Array(pIdCategoria,new Ataca2CasillasDistancia(p));
                break;
            case 4:
                replacePersona_Array(pIdCategoria,new DobleAtaque(p));
                break;
            case 5:
                replacePersona_Array(pIdCategoria,new DobleDefensa(p));
                break;
            case 6:
                replacePersona_Array(pIdCategoria,new Healer(p));
                break;
            case 7:
                replacePersona_Array(pIdCategoria,new Suma3PuntosAtaque(p));
                break;
            case 8:
                replacePersona_Array(pIdCategoria,new Suma3PuntosDefensa(p));
                break;
            case 9:
                replacePersona_Array(pIdCategoria,new AtaqueBomba(p));
                break;
            case 10:
                replacePersona_Array(pIdCategoria,new DobleVidaMovimiento(p));
                break;
            case 11:
                replacePersona_Array(pIdCategoria,new ProteccionAliado(p));
                break;
            case 12:
                replacePersona_Array(pIdCategoria,new InfanteriaBajarDefensa(p));
                break;
            case 13:
                replacePersona_Array(pIdCategoria,new ArtilleroBajarDefensa(p));
                break;


        }

    }

    public void QuitarDecorarPersona (int pICategoria) {
        ObjDecorado pDecorada = (ObjDecorado) this.getPersona(pICategoria);
        Personaje personaL = pDecorada.getPersonaje();
        replacePersona_Array(pICategoria,personaL);
    }

    /** Para la impresion en el main de prueba  **/

    public String printPersonaje(int pId) {
        Personaje pPA = this.getPersona(pId);

        return pPA.getNombre() + "\n Tiene una vida de " + pPA.getVida() + " \n" + "Un ataque de  " + pPA.getAtaque()+ "\n" +"Una defensa de "+ pPA.getDefensa()+
                "\n" + "Y sus movimientos "+pPA.getMovimiento()+ " \n" + "Y su rango  " + pPA.getRango();}


    private void eliminarEnemigos(ArrayList<Personaje> enemigues){
        for(int i=0; i<personajesArrEnemigo.size(); i++){
            for (Personaje enemigue : enemigues) {
                if (personajesArrEnemigo.get(i) == enemigue) {
                    personajesArrEnemigo.remove(enemigue);
                }
            }
        }
    }


    private ArrayList<Personaje> enemiguesRandom() {
        int divisor = 0;
        if(personajesArrEnemigo.size()<8){
            divisor = 2;
        } else{
            divisor = 4;
        }
        ArrayList<Personaje> pAbstract = new ArrayList<>();
        int cant = (int) Math.floor(personajesArrEnemigo.size()/divisor);
        int cont=0;
        for(Personaje p: personajesArrEnemigo){
            if(cont==cant){
                break;
            }
            pAbstract.add(p);
            cont++;
        }
        return pAbstract;
    }

//Variable en la cual se podra eliminar un jugador

    public String matarPersonaje(int idPersonajeAtacado){
        int arrayAbuscar=1;
        Personaje pAtacado= null;
        pAtacado= retornarPersonajeDecoradorEnemigue(idPersonajeAtacado);
        if(pAtacado==null){
            pAtacado= retornarPersonajeDecorador(idPersonajeAtacado);
            arrayAbuscar=2;
        }
        switch (arrayAbuscar){
            case 1:
                personajesArrEnemigo.remove(pAtacado);
                break;
            case 2:
                personajesArr.remove(pAtacado);
                break;
        }
        return "La unidad de batalla fue destruida.";
    }


    public Personaje retornarPersonajeDecorador(int idPersonajes){
        for(Personaje p: personajesArr){
            if(p.getID() == idPersonajes){
                return p;
            }
        }
        return null;
    }

    public Personaje retornarPersonajeDecoradorEnemigue(int idPersonajes){
        for(Personaje p: personajesArrEnemigo){
            if(p.getID() == idPersonajes){
                return p;
            }
        }
        return null;
    }

    public int obtenerIndexPersonaje(Personaje p){
        for(int i = 0; i<personajesArr.size(); i++){
            if(personajesArr.get(i) == p){
                return i;
            }
        }
        return 0;
    }
    public int obtenerIndexPersonajeEnemigue(Personaje p){
        for(int i = 0; i<personajesArrEnemigo.size(); i++){
            if(personajesArrEnemigo.get(i) == p){
                return i;
            }
        }
        return 0;
    }

    private void eliminarPersonaje(int idPropietarie) {
        Personaje personajeAbstracto = retornarPersonajeDecorador(idPropietarie);
        int indexPersonaje = obtenerIndexPersonaje(personajeAbstracto);
        personajesArr.remove(indexPersonaje);
    }



    public Personaje getPersona(int pId) {
        return global_array_persona.get(pId);
    }

    public ArrayList<Personaje> getGlobal_array_persona() {
        return global_array_persona;
    }

    public void setGlobal_array_persona(ArrayList<Personaje> global_array_persona) {
        this.global_array_persona = global_array_persona;
    }

    public void replacePersona_Array(int pId, ObjDecorado pP) {
        this.global_array_persona.set(pId, pP);
    }

    public void replacePersona_Array(int pId, Personaje pP) {
        this.global_array_persona.set(pId, pP);
    }


}