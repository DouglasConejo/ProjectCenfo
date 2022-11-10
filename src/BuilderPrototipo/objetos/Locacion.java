package BuilderPrototipo.objetos;
import BuilderPrototipo.objetos.helperObjetos.File;

public class Locacion implements IComponenteTablero {
    private File file;
    private int rank;

    public Locacion(File _file, int _rank) {
        this.setFile(_file);
        this.setRank(_rank);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "" + file + "" + rank + "";
    }

    @Override
    public void agregarComponente(IComponenteTablero pComponente) throws Exception {
        throw new Exception("La función no está soportada.");

    }

    @Override
    public String mostrarInformacion() {
        return "La locación es "+this.getFile()+this.getRank();
    }
}
