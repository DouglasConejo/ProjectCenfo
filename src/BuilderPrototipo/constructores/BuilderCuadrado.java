package BuilderPrototipo.constructores;
import BuilderPrototipo.objetos.IComponenteTablero;
import BuilderPrototipo.objetos.Locacion;
import BuilderPrototipo.objetos.helperObjetos.File;
import BuilderPrototipo.objetos.patronPrototipoCuadrado.prototipo.CuadradoBlancoVacio;

public class BuilderCuadrado extends AComponenteTablero{

    public BuilderCuadrado() {
        this.setIndice(1);
    }

    @Override
    public void construirComponente(IComponenteTablero[][] cuadrados) throws Exception {
        throw new Exception("La función no está soportada.");
    }

    @Override
    public void construirComponente(IComponenteTablero _locacion) throws Exception {
        this.setComponente(new CuadradoBlancoVacio((Locacion)_locacion));
    }

    @Override
    public void construirComponente(File _file, int _rank) throws Exception {
        throw new Exception("La función no está soportada.");
    }

    @Override
    public void setComponente(IComponenteTablero pComponente) {
        this.componentes.set(getIndice(),pComponente);
    }

    @Override
    public IComponenteTablero getComponente() {
        return this.componentes.get(getIndice());
    }
}
