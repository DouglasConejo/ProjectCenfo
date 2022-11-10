package Decorador.Componente_Concreto;

import Decorador.Componente.Personaje;

import java.awt.*;

public class Tanque extends Personaje {
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
     * **/
    public Tanque( int ID) {
        this.ID = ID;
        this.vida = 2;
        this.ataque = 10;
        this.defensa = 10;
        this.movimiento = 2;
        this.tipo = "Tanque";
        this.ataqueEspecial = ataqueEspecial;
        this.rango = 1;
        this.puntos = 0;
        this.proteccion =0;
        this.color =" ";

    }

    /**
     * Heredan de Personaje estas acciones
     * **/
    @Override
    public String getNombre() {
        return "Tanque";
    }

    @Override
    public double getAtaque() {
        return 10;
    }

    @Override
    public void setAtaque(double ataque) {
    this.ataque=ataque;
    }

    @Override
    public double getDefensa() {
        return 10;
    }

    @Override
    public void setDefensa(double defensa) {
    this.defensa=defensa;
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
        return 2;
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
        return 1;
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
