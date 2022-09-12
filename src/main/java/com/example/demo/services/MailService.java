package com.example.demo.services;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseObjetoDto;


@Service
public class MailService {

	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private JavaMailSender emailSender;
	
	public ResponseObjetoDto sendMail(String nombreAlumno, String nota) {
		ResponseObjetoDto salida = new ResponseObjetoDto();
		try {
			simpleTextMessage(nombreAlumno,nota);
			salida.setCodigo("0");
			salida.setDescripcion("Correo Enviado Exitosamente");
			salida.setMensaje("Mensaje Enviado Satisfactoriamente");
			salida.setObject(null);
		} catch (Exception e) {
			logger.error("Error: "+e);
			salida.setCodigo("-1");
			salida.setDescripcion("Correo Enviado Exitosamente");
			salida.setMensaje("Mensaje Enviado Satisfactoriamente");
			salida.setObject(null);
		}
		return salida;
	}
	
	private void simpleTextMessage(String nombreAlumno,String nota){
		//String bodyMessage = "Este es un ejemplo de correo ID=" + UUID.randomUUID().toString();
		String bodyMessage = 
				"Estimado Alumno: "+nombreAlumno+ "\n" +
				"Se ha Registrado su nota correspondiente a la Practica Calificada N°1:" + "\n" +
				"NOTA = "+nota + "\n" +
				"Para mas detalle ingrese a su Aula Virtual. " + "\n"+ "\n"+ "\n"+
				"Este es un mensaje automático. Favor de no Responder ni Reenviar.";

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("u202218470@upc.edu.pe");
		message.setFrom("luchoguitar11@gmail.com");
		message.setSubject("Registro de Nota");
		message.setText(bodyMessage);

		emailSender.send(message);
	}
}
