package FabricaAbstracta.producto_Concreto;

import java.util.Hashtable;
import FabricaAbstracta.producto_Abstracto.iDado;

public class DadoInvocacion implements iDado {
	private String value;
	private Hashtable<String,String>dict= new Hashtable<>();

    public DadoInvocacion(){
		value="1";
		asignarLados();
    };


	public void setValue(String pValue) {
		this.value= pValue;
	}

	
	public int getNumCaras() {
		return  NUM_CARAS;
	}

	public String getValue() {
		return value;
	}

/********** Seccion para implementar funciones de la interface ***************/
	@Override
	public Hashtable<String,String> asignarLados(){
		dict.put("1","Infanteria");
		dict.put("2","Infanteria");
		dict.put("3","Infanteria");
		dict.put("4","Artilleros");
		dict.put("5","Artilleros");
		dict.put("6","Tanque");
		return dict;
	}

	@Override
	public String roll() {
		String val= Integer.toString((int)(Math.random()*NUM_CARAS)+1);
		value= dict.get(val);
		return value;
	}
}
