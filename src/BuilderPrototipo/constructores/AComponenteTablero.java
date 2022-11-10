package BuilderPrototipo.constructores;

import java.util.ArrayList;

import BuilderPrototipo.objetos.IComponenteTablero;
import BuilderPrototipo.objetos.helperObjetos.File;

public abstract class AComponenteTablero {
    protected ArrayList<IComponenteTablero> componentes;
    private int indice;

    public void inicializarArreglo(){
        componentes=new ArrayList<>();
        componentes.add(null);//Tablero
        componentes.add(null);//Cuadrado
        componentes.add(null);//Locacion
    }

    public int getIndice() {
        return indice;
    }

    protected void setIndice(int indice) {
        this.indice = indice;
    }

    //Métodos abstractos
    public abstract void construirComponente(IComponenteTablero[][] _cuadrado) throws Exception;//Contstruye Tablero
    public abstract void construirComponente(IComponenteTablero _location) throws Exception;//Construye Cuadrado
    public abstract void construirComponente(File _file, int _rank) throws Exception;//Construye Locacion
    public abstract void setComponente(IComponenteTablero pComponente);
    public abstract IComponenteTablero getComponente();

}
