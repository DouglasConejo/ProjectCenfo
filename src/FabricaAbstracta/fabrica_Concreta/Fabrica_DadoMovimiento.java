package FabricaAbstracta.fabrica_Concreta;

import FabricaAbstracta.fabrica_Abstracta.iDadoJuego;
import FabricaAbstracta.producto_Concreto.DadoMovimiento;

//Fabrica Concreta

public class Fabrica_DadoMovimiento implements iDadoJuego{

	@Override
	public DadoMovimiento crearDado() {
		DadoMovimiento dado =  new DadoMovimiento();
		return dado;
	}

}