package FabricaAbstracta.gestor;

import FabricaAbstracta.fabrica_Abstracta.iDadoJuego;
import FabricaAbstracta.fabrica_Concreta.Fabrica_DadoAccion;
import FabricaAbstracta.fabrica_Concreta.Fabrica_DadoInvocacion;
import FabricaAbstracta.fabrica_Concreta.Fabrica_DadoMovimiento;
import FabricaAbstracta.producto_Abstracto.iDado;

public class Fabrica_de_Dados {

	public static String CrearFabricaDado(iDadoJuego p) {
		iDado obj = p.crearDado();
		var resul = obj.roll();
		return resul;
	}

	public String procesarFuncion(int pOpc) {
		String sMensaje = "";
		iDadoJuego moVeh;

		switch (pOpc) {

			case 1:
				moVeh = new Fabrica_DadoAccion();
				sMensaje = CrearFabricaDado(moVeh);
				break;

			case 2:
				moVeh = new Fabrica_DadoInvocacion();
				sMensaje = CrearFabricaDado(moVeh);
				break;

			case 3:
				moVeh = new Fabrica_DadoMovimiento();
				sMensaje = CrearFabricaDado(moVeh);
				break;
			default:
				sMensaje = "Opcion invalida";
				break;
		}

		return sMensaje;

	}

}
