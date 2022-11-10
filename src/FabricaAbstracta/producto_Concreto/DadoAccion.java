package FabricaAbstracta.producto_Concreto;

import java.util.Hashtable;
import FabricaAbstracta.producto_Abstracto.iDado;

public class DadoAccion implements iDado {
	private String value;
	private Hashtable<String,String>dict= new Hashtable<>();

    public DadoAccion(){
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
	
	public Hashtable<String,String> asignarLados(){
		dict.put("1","Movimiento");
		dict.put("2","Movimiento");
		dict.put("3","Ataque");
		dict.put("4","Ataque");
		dict.put("5","AtaqueEspecial");
		dict.put("6","AtaqueEspecial");
		return dict;
	}

	@Override
	public String roll() {
		String val= Integer.toString((int)(Math.random()*NUM_CARAS)+1);
		value= dict.get(val);
		return value;
	}
}

