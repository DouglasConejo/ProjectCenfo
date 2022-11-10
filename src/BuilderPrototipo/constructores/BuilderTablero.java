package BuilderPrototipo.constructores;
import BuilderPrototipo.objetos.*;
import BuilderPrototipo.objetos.helperObjetos.File;

public class BuilderTablero extends AComponenteTablero{

    public BuilderTablero() {
        this.setIndice(0);
    }

    @Override
    public void construirComponente(IComponenteTablero[][] cuadrados) throws Exception {
        this.setComponente(new Tablero(cuadrados));
    }

    @Override
    public void construirComponente(IComponenteTablero _location) throws Exception {
        throw new Exception("La función no está soportada.");

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
