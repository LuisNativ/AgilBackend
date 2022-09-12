package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseObjetoDto;
import com.example.demo.services.MailService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/mail")
public class MailController {
	
	@Autowired
	private MailService mailService;
	

	@PostMapping("/sendMail/{alumno}/{nota}")
	ResponseObjetoDto listarSolicitudesPago(@PathVariable String alumno,@PathVariable String nota){
		return mailService.sendMail(alumno, nota);
	}
}
