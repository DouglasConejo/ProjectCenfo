package FacadeStrategy.Strategy.Implementacion;
import FacadeStrategy.Strategy.Base.AbstractPrefa;
import FacadeStrategy.Strategy.Clases.*;

public class GestorPrefas {
    private AbstractPrefa prefa;

    public String imprimirFigura(String nombrePrefa, int forma, String columna, int renglon, String color){
        return switch (nombrePrefa) {
            case "Cruz" -> impCruz(forma, columna, renglon, color);
            case "Ele" -> impEle(forma, columna, renglon, color);
            case "Pe" -> impPe(forma, columna, renglon, color);
            case "Te" -> impTe(forma, columna, renglon, color);
            case "U" -> impU(forma, columna, renglon, color);
            case "Zeta" -> impZeta(forma, columna, renglon, color);
            default -> "Prefa no existe";
        };
    }

    public int cantOpciones(String nPrefa){
        return switch (nPrefa) {
            case "Cruz" -> 1;
            case "Zeta" -> 2;
            default -> 4;
        };
    }

    public String impCruz(int forma, String columna, int renglon, String color){
        prefa = new Cruz();
        prefa.imprimirPrefa(forma, columna, renglon, color);
        return prefa.mensaje();
    }

    public String impEle(int forma, String columna, int renglon, String color){
        prefa = new Ele();
        prefa.imprimirPrefa(forma, columna, renglon, color);
        return prefa.mensaje();
    }

    public String impPe(int forma, String columna, int renglon, String color){
        prefa = new Pe();
        prefa.imprimirPrefa(forma, columna, renglon, color);
        return prefa.mensaje();
    }

    public String impTe(int forma, String columna, int renglon, String color){
        prefa = new Te();
        prefa.imprimirPrefa(forma, columna, renglon, color);
        return prefa.mensaje();
    }

    public String impU(int forma, String columna, int renglon, String color){
        prefa = new U();
        prefa.imprimirPrefa(forma, columna, renglon, color);
        return prefa.mensaje();
    }

    public String impZeta(int forma, String columna, int renglon, String color){
        prefa = new Zeta();
        prefa.imprimirPrefa(forma, columna, renglon, color);
        return prefa.mensaje();
    }

    public void imprimirMensaje(){
        System.out.println(prefa.mensaje());
    }
}