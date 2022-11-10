package FacadeStrategy.Facade.Main;
import FacadeStrategy.Facade.Objetos.UImensaje;
import FacadeStrategy.Facade.Objetos.UIprefas;
import FacadeStrategy.Strategy.Implementacion.GestorPrefas;

public class Fachada_Prefas {
    private GestorPrefas gestorPrefas;
    private UIprefas uIprefas;
    private String mensaje;
    private UImensaje uImensaje;

    public Fachada_Prefas(){
        gestorPrefas = new GestorPrefas();
    }

    public void llamarUI(){
        uIprefas = new UIprefas();
    }

    public void imprimirPrefa(String prefa, int inclinacion, String columnaEje, int renglonEje, String color){
        mensaje = gestorPrefas.imprimirFigura(prefa, inclinacion, columnaEje, renglonEje, color);
        if (!mensaje.equals("Figura impresa exitosamente")){
            imprimirMensaje(mensaje);
        }
    }

    public void imprimirMensaje(String msj){
        uImensaje = new UImensaje(msj);
    }
}