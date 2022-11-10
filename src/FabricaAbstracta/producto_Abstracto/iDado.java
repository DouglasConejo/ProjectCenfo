package FabricaAbstracta.producto_Abstracto;
//Interfaz Abstracta Objetos Concretos
//Producto Abstracto

import java.util.Hashtable;

public interface iDado {
	public static final int NUM_CARAS=6;
	public String roll ();
	public Hashtable<String,String> asignarLados();
}
