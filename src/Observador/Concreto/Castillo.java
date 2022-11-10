package Observador.Concreto;

import Observador.Interfaces.ICastillo;
import Observador.Interfaces.IObservador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Castillo implements ICastillo {
    private IObservador observer;
    private int vidasCastillo1;
    private int vidasCastillo2;

    public Castillo(){
        this.vidasCastillo1=3;
        this.vidasCastillo2=3;
    }

    public int getVidasCatillo1() {
        return vidasCastillo1;
    }

    public void setVidasCatillo1(int vidasCatillo1) {
        this.vidasCastillo1 = vidasCatillo1;
    }

    public int getVidasCastillo2() {
        return vidasCastillo2;
    }

    public void setVidasCastillo2(int vidasCastillo2) {
        this.vidasCastillo2 = vidasCastillo2;
    }

    public void cambiarVidas(int a, int b){
        setVidasCatillo1(a);
        setVidasCastillo2(b);
        notificar();
    }
    public void enlazarObservador (IObservador o){
        this.observer=o;
    }
    @Override
    public void notificar() {
            observer.update(getVidasCatillo1(),getVidasCastillo2());
        }
    }





