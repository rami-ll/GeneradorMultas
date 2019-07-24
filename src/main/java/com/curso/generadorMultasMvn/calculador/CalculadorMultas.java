package com.curso.generadorMultasMvn.calculador;

import sensorclima.TipoClima;
import com.curso.generadorMultasMvn.persistencia.*;
import sensorvelocidad.DatosVehiculo;
import com.curso.generadorMultasMvn.status.StatusController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.curso.generadorMultasMvn.model.*;

public class CalculadorMultas {
	
	private Auto auto = new Auto();
	private Moto moto = new Moto();
	private Camion camion = new Camion();
	private Tractor tractor = new Tractor();
	private List<IGeneradorTicket> generadores = new ArrayList();
	
	public int calcularMulta(DatosVehiculo vehiculo, TipoClima clima) {
		int montoMulta = 0;
		float limite = 0;
		switch (vehiculo.tipoVehiculo) {
			case Auto:
				limite = auto.getLimiteVelocidad(clima);
				break;
			case Camion:
				limite = camion.getLimiteVelocidad(clima);
				break;
			case Tractor:
				limite = tractor.getLimiteVelocidad(clima);
				break;
			case Moto:
				limite = moto.getLimiteVelocidad(clima);
				break;
		}
		float exceso = (vehiculo.velocidadMedida/limite);
		if(StatusController.esDomingo(new Date())) {
			exceso += 0.1;
			System.out.println("Es domingo hay tolerancia del 10%");
		}
		System.out.println(String.format("Limite: %f", limite));
		System.out.println("Exceso: " + exceso);
		if(exceso > 1.1) {
			montoMulta = 1000;
		} 
		if (exceso > 1.2) {
			montoMulta = 5000;
		}
		if (montoMulta > 0) {
			enviarTicket(montoMulta, vehiculo.patente);
		}
		return montoMulta;
	}
	
	private void enviarTicket(int monto, String placa) {
		Ticket t = new Ticket(monto, placa, new Date());
		generadores.forEach((IGeneradorTicket gen) -> gen.generarTicket(t));

	}
	
	public void agregarGenerador(IGeneradorTicket generadorNuevo) {
		generadores.add(generadorNuevo);
	}

}
