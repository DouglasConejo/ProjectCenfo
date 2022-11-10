package Decorador.Componente;

public abstract class Personaje {

    public abstract String 	getNombre() ;
    public abstract double 	getAtaque();
    public abstract void setAtaque(double ataque);
    public abstract double 	getDefensa();
    public abstract void setDefensa(double defensa);
    public abstract int 	getVida();
    public abstract void setVida(int vida);
    public abstract int 	getMovimiento();
    public abstract void setMovimiento(int movimiento);
    public abstract int 	getPuntos();
    public abstract void setPunto(int puntos);
    public abstract double 	getProteccion();
    public abstract void setProteccion(double proteccion);
    public abstract int 	getRango();
    public abstract int setRanqo(int rango);
    public abstract String getAtaqueEspecial();
    public abstract int 	getID();
    public abstract void setID(int ID);

}
