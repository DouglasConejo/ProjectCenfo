package BuilderPrototipo.constructores;
import BuilderPrototipo.objetos.Locacion;
import BuilderPrototipo.objetos.IComponenteTablero;
import BuilderPrototipo.objetos.helperObjetos.File;


public class BuilderLocacion extends AComponenteTablero{

    public BuilderLocacion() {
        this.setIndice(2);
    }

    @Override
    public void construirComponente(IComponenteTablero[][] cuadrados) throws Exception {
        throw new Exception("La función no está soportada.");
    }

    @Override
    public void construirComponente(IComponenteTablero _location) throws Exception {
        throw new Exception("La función no está soportada.");

    }
    @Override
    public void construirComponente(File _file, int _rank) throws Exception {
        this.setComponente(new Locacion(_file, _rank));
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
