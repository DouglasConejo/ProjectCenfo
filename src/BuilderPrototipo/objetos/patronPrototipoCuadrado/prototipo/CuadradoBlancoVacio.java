package BuilderPrototipo.objetos.patronPrototipoCuadrado.prototipo;
import BuilderPrototipo.objetos.Locacion;
import BuilderPrototipo.objetos.helperObjetos.*;
import BuilderPrototipo.objetos.patronPrototipoCuadrado.iPrototipoCuadrado.Cuadrado;


public class CuadradoBlancoVacio extends Cuadrado{
    public CuadradoBlancoVacio(Locacion _locacion) {
        this.setSquareColor(ColorCuadrado.White);
        this.setLocacion(_locacion);
        this.setOcupado(false);
        this.setPersonaje("");
        this.setArtillero(null);
        this.setInfanteria(null);
        this.setTanque(null);
    }

    @Override
    public Cuadrado clone() {
        return new CuadradoBlancoVacio(this.getLocacion());
    }
}
