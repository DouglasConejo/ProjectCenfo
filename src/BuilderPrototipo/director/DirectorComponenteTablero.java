package BuilderPrototipo.director;

import java.util.ArrayList;

import BuilderPrototipo.constructores.*;
import BuilderPrototipo.objetos.*;
import BuilderPrototipo.objetos.helperObjetos.File;


public class DirectorComponenteTablero {
    private AComponenteTablero builder;
    private ArrayList<AComponenteTablero> builders = new ArrayList<AComponenteTablero>();

    public DirectorComponenteTablero(){
        builders.add(new BuilderTablero());
        builders.add(new BuilderCuadrado());
        builders.add(new BuilderLocacion());

        for(int i=0; i <this.builders.size(); i++){
            switchBuilder(i);
            this.getBuilder().inicializarArreglo();
        }
    }

    public AComponenteTablero getBuilder() {
        return builder;
    }

    private void setBuilder(AComponenteTablero builder) {
        this.builder = builder;
    }

    private void switchBuilder(int ind){
        this.setBuilder(builders.get(ind));
    }

    //Funciones para construcción de TableroBuilderPrototipo.objetos

    public IComponenteTablero construirTablero(IComponenteTablero[][] _cuadrado) throws Exception{
        // IComponenteTablero _cuadrado= construirCuadrado(cuadrado);
        switchBuilder(0);
        this.getBuilder().construirComponente(_cuadrado);
        return this.getBuilder().getComponente();
    }

    public IComponenteTablero construirCuadradoVacioBlanco(File _file, int _rank) throws Exception{
        IComponenteTablero locacionn=construirLocacion(_file, _rank);
        switchBuilder(1);
        this.getBuilder().construirComponente(locacionn);
        return this.getBuilder().getComponente();
    }

    public IComponenteTablero construirLocacion(File _file, int _rank) throws Exception{
        switchBuilder(2);
        this.getBuilder().construirComponente(_file, _rank);
        return this.getBuilder().getComponente();
    }
}

