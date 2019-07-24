package com.curso.generadorMultasMvn;

import com.curso.generadorMultasMvn.calculador.CalculadorMultas;
import com.curso.generadorMultasMvn.persistencia.GeneradorTicketFileJson;
import sensorclima.*;
import sensorvelocidad.*;
import com.curso.generadorMultasMvn.status.*;;

public class Sensador {


	public static void main(String[] args) {
		
		StatusController controller = new StatusController();
		CalculadorMultas calculador = controller.getCalculadorIntance();
		calculador.agregarGenerador(new GeneradorTicketFileJson());
		
		DatosVehiculo datos;
		TipoClima clima;		
			
		while(true) {
			clima = controller.getClima();
			datos = controller.getDatosVehiculoSensado();
			System.out.println(clima);
			System.out.println(datos.patente);
			System.out.println(datos.velocidadMedida);
			System.out.println(datos.tipoVehiculo.toString());
			System.out.println("Monto: " +
					calculador.calcularMulta(datos, clima));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			



	}

}
