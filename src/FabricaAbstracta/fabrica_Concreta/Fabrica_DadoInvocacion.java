package FabricaAbstracta.fabrica_Concreta;

import FabricaAbstracta.fabrica_Abstracta.iDadoJuego;
import FabricaAbstracta.producto_Concreto.DadoInvocacion;

public class Fabrica_DadoInvocacion implements iDadoJuego{

	@Override
	public DadoInvocacion crearDado() {
		DadoInvocacion dado =  new DadoInvocacion();
		return dado;
	}

}
