package com.curso.generadorMultasMvn.model;

import java.util.Date;
import java.util.UUID;

import sensorvelocidad.DatosVehiculo;

public class Ticket {

	String id;
	int monto;
	String placa;
	Date fecha;
	
	
	public Ticket(int monto, String placa, Date fecha) {
			this.monto = monto;
			this.placa = placa;
			this.fecha = fecha;
			this.id = UUID.randomUUID().toString();
		}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
