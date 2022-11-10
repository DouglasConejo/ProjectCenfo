package BuilderPrototipo.gestor;
import BuilderPrototipo.director.DirectorComponenteTablero;
import BuilderPrototipo.objetos.*;
import BuilderPrototipo.objetos.helperObjetos.File;
import BuilderPrototipo.objetos.patronPrototipoCuadrado.prototipo.CuadradoBlancoVacio;

public class Gestor {
    static DirectorComponenteTablero director = new DirectorComponenteTablero();
    private static IComponenteTablero componente;
    private static IComponenteTablero cuadrados[][] = new IComponenteTablero[20][20];

    public static IComponenteTablero construccionTablero(IComponenteTablero[][] cuadrados) throws Exception {
        return director.construirTablero(cuadrados);
    }

    public static IComponenteTablero construccionCuadradoBlancoVacio(File _file, int _rank)
            throws Exception {
        return director.construirCuadradoVacioBlanco(_file, _rank);
    }

    public static IComponenteTablero construccionLocacion(File _file, int _rank) throws Exception {
        return director.construirLocacion(_file, _rank);
    }

    public IComponenteTablero[][] tableroPrincipal() {
        for (int i = 0; i < 20; i++) {
            int row = 0;
            for (File file : File.values()) {
                if (i == 0) {
                    try {
                        componente = construccionCuadradoBlancoVacio(file, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    componente = ((CuadradoBlancoVacio) componente).clone();
                    try {
                        ((CuadradoBlancoVacio) componente).setLocacion((Locacion) construccionLocacion(file, i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                cuadrados[row][i] = componente;
                row++;
            }
        }
        try {
            componente = construccionTablero(cuadrados);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return ((Tablero) componente).getBoardSquares();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
