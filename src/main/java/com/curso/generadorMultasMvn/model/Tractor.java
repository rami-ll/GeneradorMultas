package com.curso.generadorMultasMvn.model;

import sensorclima.TipoClima;

public class Tractor implements Vehiculo{
	
	public int getLimiteVelocidad (TipoClima clima) {
		return 60;
	}

}
