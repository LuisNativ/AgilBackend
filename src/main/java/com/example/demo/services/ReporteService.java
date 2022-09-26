package com.example.demo.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ReporteAsistenciaDto;
import com.example.demo.dto.ReporteDto;


@Service
public class ReporteService {
	

	@Transactional
	public ByteArrayInputStream generarExcelReporte(List<ReporteDto> lstReporteDto) throws Exception {
		List<String> headers = Arrays.asList("Código","Nombres","Práctica 1","Práctica 2",
											 "Práctica 3","Práctica 4","Examen Final");
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();){
			
			 Sheet sheet = workbook.createSheet("Reporte");
			 
			 /**************Begin: Titulo Cabecera***********************/
			 //Creación del Tipo de Fuente de la Cabecera
			 Font headerFont = workbook.createFont();
			 headerFont.setBold(true);
			 headerFont.setColor(IndexedColors.WHITE.getIndex());
			 //Creación del estilo de la Celda de la Cabecera
			 CellStyle headerCellStyle = workbook.createCellStyle();
			 headerCellStyle.setFont(headerFont);
			 headerCellStyle.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
			 headerCellStyle.setFillPattern((short) FillPatternType.SOLID_FOREGROUND.ordinal());
			
			 headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			 headerCellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
			 
			 //Creacion de la Fila
			 Row row = sheet.createRow(0);
			 Cell title = row.createCell(0);
			 title.setCellValue("REPORTE ACADÉMICO");
	         title.setCellStyle(headerCellStyle);
	         sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.size() - 1)); //Para Juntar celdas
	         
	         ///////////////////////
	         Row rowEmpresa = sheet.createRow(3);
	         Cell empresa = rowEmpresa.createCell(0);
	         empresa.setCellValue("CURSO");
	         empresa.setCellStyle(headerCellStyle);
	         Cell descripcionEmpresa = rowEmpresa.createCell(1);
	         descripcionEmpresa.setCellValue("CÁLCULO 1");
	         
	         Cell fechaCorte = rowEmpresa.createCell(3);
	         fechaCorte.setCellValue("CICLO");
	         fechaCorte.setCellStyle(headerCellStyle);
	         Cell descripcionFechaCorte = rowEmpresa.createCell(4);
	         descripcionFechaCorte.setCellValue("2022-2");
	         
	         Row rowMoneda = sheet.createRow(4);
	         Cell moneda = rowMoneda.createCell(0);
	         moneda.setCellValue("SECCIÓN ");
	         moneda.setCellStyle(headerCellStyle);
	         Cell descripcionMoneda = rowMoneda.createCell(1);
	         descripcionMoneda.setCellValue("E32A");
	         /**************End: Titulo Cabecera***********************/
	         
	         /**************Begin: Estilos Tabla***********************/
	         //Estilo de la Celda del Header de la Tabla
	         CellStyle headerCellTable = workbook.createCellStyle();
	         headerCellTable.setFont(headerFont);
	         headerCellTable.setAlignment(CellStyle.ALIGN_CENTER);
	         headerCellTable.setVerticalAlignment(CellStyle.ALIGN_CENTER);
	         headerCellTable.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
	         headerCellTable.setFillPattern((short) FillPatternType.SOLID_FOREGROUND.ordinal());
	         headerCellTable.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	         headerCellTable.setBorderTop(HSSFCellStyle.BORDER_THIN);
	         
	         headerCellTable.setBorderRight(HSSFCellStyle.BORDER_THIN);
	         headerCellTable.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	         //Estilo de la Celda del Body de la Tabla
	         CellStyle cellTableBody = workbook.createCellStyle();
	         cellTableBody.setAlignment(CellStyle.ALIGN_CENTER);
	         cellTableBody.setVerticalAlignment(CellStyle.ALIGN_CENTER);
	         cellTableBody.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	         cellTableBody.setBorderTop(HSSFCellStyle.BORDER_THIN);
	         cellTableBody.setBorderRight(HSSFCellStyle.BORDER_THIN);
	         cellTableBody.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	                  
	         int rowInit = 9;
	         
	         Row rowReporteHeader = sheet.createRow(rowInit++);
	         int c= 0;

	         for (String header : headers) {
                 Cell cellCod = rowReporteHeader.createCell(c);
                 cellCod.setCellValue(header);
                 cellCod.setCellStyle(headerCellTable);
                 sheet.autoSizeColumn(c);
                 c++;
             }
	         int init = rowInit++;
	         for (int i=0;i<lstReporteDto.size();i++) {
	        	Row rowTrabajador = sheet.createRow(init++);
	        	int b=0;
	        	for (String header : headers) {
	        		 Cell cellCred = rowTrabajador.createCell(b);	 
	        		 if(b==0) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getCodigo());
	        		 }
	        		 if(b==1) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getNombres());
	        		 }
	        		 if(b==2) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getPractica1());
	        		 }
	        		 if(b==3) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getPractica2());
	        		 }
	        		 if(b==4) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getPractica3());
	        		 }
	        		 if(b==5) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getPractica4());
	        		 }
	        		 if(b==6) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getExamenFinal());
	        		 }
	     		
	        		 
	        		 cellCred.setCellStyle(cellTableBody);
                     sheet.autoSizeColumn(b);
                     b++;
	        	}

				
			}
	         /**************End: Estilos Tabla***********************/
	         workbook.write(out);
	         return new ByteArrayInputStream(out.toByteArray());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
		}
		
		
		return null;
	}
	
	@Transactional
	public ByteArrayInputStream generarExcelReporteAsistencia(List<ReporteAsistenciaDto> lstReporteDto) throws Exception {
		List<String> headers = Arrays.asList("Nro.","Código","Nombres","Clases Dictadas","Clases Asistidas",
											 "Clases Inasistidas");
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();){
			
			 Sheet sheet = workbook.createSheet("Reporte");
			 
			 /**************Begin: Titulo Cabecera***********************/
			 //Creación del Tipo de Fuente de la Cabecera
			 Font headerFont = workbook.createFont();
			 headerFont.setBold(true);
			 headerFont.setColor(IndexedColors.WHITE.getIndex());
			 //Creación del estilo de la Celda de la Cabecera
			 CellStyle headerCellStyle = workbook.createCellStyle();
			 headerCellStyle.setFont(headerFont);
			 headerCellStyle.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
			 headerCellStyle.setFillPattern((short) FillPatternType.SOLID_FOREGROUND.ordinal());
			
			 headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			 headerCellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
			 
			 //Creacion de la Fila
			 Row row = sheet.createRow(0);
			 Cell title = row.createCell(0);
			 title.setCellValue("REPORTE ACADÉMICO DE ASISTENCIAS");
	         title.setCellStyle(headerCellStyle);
	         sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.size() - 1)); //Para Juntar celdas
	         
	         ///////////////////////
	         Row rowEmpresa = sheet.createRow(3);
	         Cell empresa = rowEmpresa.createCell(0);
	         empresa.setCellValue("CURSO");
	         empresa.setCellStyle(headerCellStyle);
	         Cell descripcionEmpresa = rowEmpresa.createCell(1);
	         descripcionEmpresa.setCellValue("CÁLCULO 1");
	         
	         Cell fechaCorte = rowEmpresa.createCell(3);
	         fechaCorte.setCellValue("CICLO");
	         fechaCorte.setCellStyle(headerCellStyle);
	         Cell descripcionFechaCorte = rowEmpresa.createCell(4);
	         descripcionFechaCorte.setCellValue("2022-2");
	         
	         Row rowMoneda = sheet.createRow(4);
	         Cell moneda = rowMoneda.createCell(0);
	         moneda.setCellValue("SECCIÓN ");
	         moneda.setCellStyle(headerCellStyle);
	         Cell descripcionMoneda = rowMoneda.createCell(1);
	         descripcionMoneda.setCellValue("E32A");
	         /**************End: Titulo Cabecera***********************/
	         
	         /**************Begin: Estilos Tabla***********************/
	         //Estilo de la Celda del Header de la Tabla
	         CellStyle headerCellTable = workbook.createCellStyle();
	         headerCellTable.setFont(headerFont);
	         headerCellTable.setAlignment(CellStyle.ALIGN_CENTER);
	         headerCellTable.setVerticalAlignment(CellStyle.ALIGN_CENTER);
	         headerCellTable.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
	         headerCellTable.setFillPattern((short) FillPatternType.SOLID_FOREGROUND.ordinal());
	         headerCellTable.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	         headerCellTable.setBorderTop(HSSFCellStyle.BORDER_THIN);
	         
	         headerCellTable.setBorderRight(HSSFCellStyle.BORDER_THIN);
	         headerCellTable.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	         //Estilo de la Celda del Body de la Tabla
	         CellStyle cellTableBody = workbook.createCellStyle();
	         cellTableBody.setAlignment(CellStyle.ALIGN_CENTER);
	         cellTableBody.setVerticalAlignment(CellStyle.ALIGN_CENTER);
	         cellTableBody.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	         cellTableBody.setBorderTop(HSSFCellStyle.BORDER_THIN);
	         cellTableBody.setBorderRight(HSSFCellStyle.BORDER_THIN);
	         cellTableBody.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	                  
	         int rowInit = 9;
	         
	         Row rowReporteHeader = sheet.createRow(rowInit++);
	         int c= 0;

	         for (String header : headers) {
                 Cell cellCod = rowReporteHeader.createCell(c);
                 cellCod.setCellValue(header);
                 cellCod.setCellStyle(headerCellTable);
                 sheet.autoSizeColumn(c);
                 c++;
             }
	         int init = rowInit++;
	         for (int i=0;i<lstReporteDto.size();i++) {
	        	Row rowTrabajador = sheet.createRow(init++);
	        	int b=0;
	        	for (String header : headers) {
	        		 Cell cellCred = rowTrabajador.createCell(b);	 
	        		 if(b==0) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getNro());
	        		 }
	        		 if(b==1) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getCodigo());
	        		 }
	        		 if(b==2) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getNombres());
	        		 }
	        		 if(b==3) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getDictadas());
	        		 }
	        		 if(b==4) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getAsistidas());
	        		 }
	        		 if(b==5) {
	        			 cellCred.setCellValue(lstReporteDto.get(i).getNoasistida());
	        		 }
	        		 
	        		 cellCred.setCellStyle(cellTableBody);
                     sheet.autoSizeColumn(b);
                     b++;
	        	}

				
			}
	         /**************End: Estilos Tabla***********************/
	         workbook.write(out);
	         return new ByteArrayInputStream(out.toByteArray());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
		}
		
		
		return null;
	}

}
