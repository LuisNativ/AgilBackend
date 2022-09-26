package com.example.demo.controllers;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReporteAsistenciaDto;
import com.example.demo.dto.ReporteDto;
import com.example.demo.services.ReporteService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reporte")
public class ReporteController {
	
	@Autowired
	private ReporteService reporteService;

	
	@PostMapping("/exportarReporte")
	ResponseEntity<InputStreamResource>  generarReporteExcel(@RequestBody List<ReporteDto> lstReporteDto) throws Exception  {
	    ByteArrayInputStream in = reporteService.generarExcelReporte(lstReporteDto);
	    HttpHeaders headers = new HttpHeaders();
	    long time = new Date().getTime();
	    String filename = "Reporte-".concat(String.valueOf(time));
	    headers.add("Content-Disposition", "attachment; filename=" + filename + ".xlsx");
	    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	
	@PostMapping("/expRepAsistencia")
	ResponseEntity<InputStreamResource>  generarReporteExcelAsistencia(@RequestBody List<ReporteAsistenciaDto> lstReporteDto) throws Exception  {
	    ByteArrayInputStream in = reporteService.generarExcelReporteAsistencia(lstReporteDto);
	    HttpHeaders headers = new HttpHeaders();
	    long time = new Date().getTime();
	    String filename = "Reporte-".concat(String.valueOf(time));
	    headers.add("Content-Disposition", "attachment; filename=" + filename + ".xlsx");
	    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
}
