package com.curso.generadorMultasMvn.persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.springframework.stereotype.Component;

import jdk.nashorn.internal.runtime.Context.ThrowErrorManager;
import com.curso.generadorMultasMvn.model.Ticket;
import com.google.gson.Gson;

@Component
public class GeneradorTicketFileJson implements IGeneradorTicket{

	private final String savePath = "C:\\tickets\\";
	
	public void generarTicket(Ticket ticket) {
		System.out.println("Se escribe archivo para el ticket con id: " + ticket.getId());
		String jsonString = new Gson().toJson(ticket);
		write((savePath + ticket.getId()) + ".json", jsonString);
	}
	
	private void write (String path, String jsonToWrite) {
		try {
			FileWriter file = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(file);
			writer.write(jsonToWrite);
			writer.flush();
			writer.close();
		} catch (Throwable ex) {
			System.out.println("No se pudo grabar el archivo. Error: " + ex.getMessage());
		}
		
	}


}
