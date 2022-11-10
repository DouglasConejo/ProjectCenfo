package Decorador.Componente_Concreto;

import Decorador.Componente.Personaje;

import java.awt.*;

public class Artillero extends Personaje {

    /**
     * Este panel pressed, es para hacer la conexion con el tablero, lo cual se podra ver
     * en la clase juegoTablero
     * **/
    public static Component panelPressed;
    /**
     * Atributos
     * **/
    protected int ID;
    protected int vida;
    protected double ataque;
    protected double defensa;
    protected int movimiento;
    protected  String tipo;
    protected String ataqueEspecial;
    protected int rango;
    protected int puntos;
    protected double proteccion;
    protected String color;

    /**
     * Constructor con sus atributos y datos
     *
     * @param ID**/
    public Artillero(int ID ){
        this.ID = ID;
        this.vida = 4;
        this.ataque = 6;
        this.defensa = 10;
        this.movimiento = 4;
        this.tipo = "Artilleria";
        this.ataqueEspecial = ataqueEspecial;
        this.rango = 1;
        this.puntos = 0;
        this.proteccion =0;
        this.color=" ";
    }

    /**
     * Heredan de Personaje estas acciones
     * **/
    @Override
    public String getNombre() {
        return "Artillero";
    }

    @Override
    public double getAtaque() {
        return 6;
    }

    @Override
    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    @Override
    public double getDefensa() {
        return 10;
    }

    @Override
    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    @Override
    public int getVida() {
        return this.vida;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public int getMovimiento() {
        return 4;
    }

    @Override
    public void setMovimiento(int movimiento) {

    }

    @Override
    public int getPuntos() {
        return 0;
    }

    @Override
    public void setPunto(int puntos) {

    }

    @Override
    public double getProteccion() {
        return 0;
    }

    @Override
    public void setProteccion(double proteccion) {

    }

    @Override
    public int getRango() {
        return 0;
    }

    @Override
    public int setRanqo(int rango) {
        return 0;
    }

    @Override
    public String getAtaqueEspecial() {
        return null;
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void setID(int ID) {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
