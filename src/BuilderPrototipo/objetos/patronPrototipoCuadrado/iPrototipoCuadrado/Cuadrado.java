package BuilderPrototipo.objetos.patronPrototipoCuadrado.iPrototipoCuadrado;

import Decorador.Componente_Concreto.Artillero;
import Decorador.Componente_Concreto.Infanteria;
import Decorador.Componente_Concreto.Tanque;
import BuilderPrototipo.objetos.IComponenteTablero;
import BuilderPrototipo.objetos.Locacion;
import BuilderPrototipo.objetos.helperObjetos.ColorCuadrado;

public abstract class Cuadrado implements IComponenteTablero {
    private ColorCuadrado squareColor;
    private Locacion locacion;
    private boolean ocupado;
    private String personaje;

    //Creacion del llamado de las 3 categorias y llama al gestor
    private Infanteria infanteria;
    private Artillero artillero;
    private Tanque tanque;
    private int idPersonaje;

    public boolean getOcupado() {
        return ocupado;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Locacion getLocacion() {
        return locacion;
    }

    public void setLocacion(Locacion locacion) {
        this.locacion = locacion;
    }

    public ColorCuadrado getSquareColor() {
        return squareColor;
    }

    public void setSquareColor(ColorCuadrado squareColor) {
        this.squareColor = squareColor;
    }

    public void reset() {
        this.setOcupado(false);
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public Infanteria getInfanteria() {
        return infanteria;
    }

    public void setInfanteria(Infanteria infanteria) {
        this.infanteria = infanteria;
    }

    public Artillero getArtillero() {
        return artillero;
    }

    public void setArtillero(Artillero artillero) {
        this.artillero = artillero;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String toStringLocacion() {
        return "" + locacion;
    }

    @Override
    public void agregarComponente(IComponenteTablero pComponente) throws Exception {
        this.setLocacion((Locacion) pComponente);
    }

    @Override
    public String mostrarInformacion() {
        return "El cuadrado: " + toString();
    }

    public abstract Cuadrado clone();

    @Override
    public String toString() {
        return "Cuadrado [locacion=" + locacion + ", ocupado=" + ocupado + ", personaje=" + personaje + ", squareColor="
                + squareColor + "]";
    }

}
