package FabricaAbstracta.fabrica_Concreta;

import FabricaAbstracta.fabrica_Abstracta.iDadoJuego;
import FabricaAbstracta.producto_Concreto.DadoAccion;

//Fabrica Concreta

public class Fabrica_DadoAccion implements iDadoJuego{

	@Override
	public DadoAccion crearDado() {
		DadoAccion dado =  new DadoAccion();
		return dado;
	}

}