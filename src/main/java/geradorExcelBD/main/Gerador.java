package geradorExcelBD.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import geradorExcelBD.dto.AtencionProcesoDTO;
import geradorExcelBD.dto.DetalleAtencionProcesoDTO;
import geradorExcelBD.dto.DetalleGestionAtencionDTO;
import geradorExcelBD.dto.EvaluacionAtencionDTO;
import geradorExcelBD.dto.ExcelDTO;
import geradorExcelBD.dto.MaestroGestionAtencionDTO;
import geradorExcelBD.dto.ResultadoEvaluacionDTO;

public class Gerador {

	public void BDtoExcel(ExcelDTO excelDTO, Integer id) {

		try (FileOutputStream outputStream = new FileOutputStream(
				"C:\\Quipux\\excelLeitura\\Arquivos\\EXTRACAO_COEF_" + id + ".xlsx")) {
			try (SXSSFWorkbook workbook = new SXSSFWorkbook()) {

				if (!excelDTO.getAtencionProcesoDTOs().isEmpty()) {
					int rowNum = 0;
					Sheet sheet = workbook.createSheet("ATENCION_PROCESO");
					List<String> titulos = Arrays.asList("ID_PROCESO_ATENCION", "ID_GESTION_ATENCION",
							"SOLICITUD_ATENCION", "NRO_ATENCION", "FECHA_ATENCION", "ID_SUBSEDE", "NOMBRE_SUBSEDE",
							"ID_ESTADO", "NOMBRE_ESTADO", "ID_USUARIO", "USUARIO_ACCESO", "NUMERO_DOCUMENTO", "NOMBRE",
							"APELLIDO_1", "FECHA_INICIAL", "FECHA_FINAL", "TIEMPO_PROCESO", "ACTIVO");

					Row row = sheet.createRow(rowNum++);
					for (int i = 0; i < titulos.size(); i++) {
						Cell cell = row.createCell(i);
						cell.setCellValue(titulos.get(i));
					}

					System.out.println(sheet.getSheetName() + ": " + rowNum);
					for (AtencionProcesoDTO atencionProcesoDTO : excelDTO.getAtencionProcesoDTOs()) {
						row = sheet.createRow(rowNum++);
						int colNum = 0;
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getIdProcesoAtencion());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getIdGestionAtencion());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getSolicitudAtencion());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getNroAtencion());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getFechaAtencion());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getIdSubsede());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getNombreSubsede());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getIdEstado());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getNombreEstado());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getIdUsuario());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getUsuarioAcceso());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getNumeroDocumento());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getNombre());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getApellido1());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getFechaInicial());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getFechaFinal());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getTiempoProceso());
						row.createCell(colNum++).setCellValue(atencionProcesoDTO.getActivo());
					}
					System.out.println(sheet.getSheetName() + ": " + rowNum);
				}

				if (!excelDTO.getDetalleAtencionProcesoDTOs().isEmpty()) {
					int rowNum = 0;
					Sheet sheet = workbook.createSheet("DETALLE_ATENCION_PROCESO");
					List<String> titulos = Arrays.asList("ID_DETALLE_ATENCION_PROCESO", "ID_DETALLE_GESTION_ATENCION",
							"ID_GESTION_ATENCION", "SOLICITUD_ATENCION", "NRO_ATENCION", "FECHA_ATENCION", "ID_SUBSEDE",
							"NOMBRE_SUBSEDE", "ID_SERVICIO", "NOMBRE_SERVICIO", "IDENTIFICADOR_ATENCION", "ID_ESTADO",
							"NOMBRE_ESTADO", "ID_TAQUILLA", "NOMBRE_TAQUILLA", "ATIENDE_SERVICIO", "ENCUESTA",
							"ID_USUARIO", "USUARIO_ACCESO", "NUMERO_DOCUMENTO", "NOMBRE", "APELLIDO_1", "FECHA_INICIAL",
							"FECHA_FINAL", "TIEMPO_PROCESO", "ACTIVO");

					Row row = sheet.createRow(rowNum++);
					for (int i = 0; i < titulos.size(); i++) {
						Cell cell = row.createCell(i);
						cell.setCellValue(titulos.get(i));
					}

					System.out.println(sheet.getSheetName() + ": " + rowNum);
					for (DetalleAtencionProcesoDTO detalleAtencionProcesoDTO : excelDTO
							.getDetalleAtencionProcesoDTOs()) {
						row = sheet.createRow(rowNum++);
						int colNum = 0;
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdDetalleAtencionProceso());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdDetalleGestionAtencion());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdGestionAtencion());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getSolicitudAtencion());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getNroAtencion());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getFechaAtencion());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdSubsede());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getNombreSubsede());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdServicio());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getNombreServicio());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdentificadorAtencion());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdEstado());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getNombreEstado());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdTaquilla());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getNombreTaquilla());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getAtiendeServicio());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getEncuesta());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getIdUsuario());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getUsuarioAcceso());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getNumeroDocumento());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getNombre());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getApellido1());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getFechaInicial());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getFechaFinal());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getTiempoProceso());
						row.createCell(colNum++).setCellValue(detalleAtencionProcesoDTO.getActivo());
					}
					System.out.println(sheet.getSheetName() + ": " + rowNum);
				}

				if (!excelDTO.getDetalleGestionAtencionDTOs().isEmpty()) {
					int rowNum = 0;
					Sheet sheet = workbook.createSheet("DETALLE_GESTION_ATENCION");
					List<String> titulos = Arrays.asList("ID_DETALLE_GESTION_ATENCION", "ID_GESTION_ATENCION",
							"SOLICITUD_ATENCION", "NRO_ATENCION", "FECHA_ATENCION", "ID_SUBSEDE", "NOMBRE_SUBSEDE",
							"ID_ENTIDAD_PRESTADORA", "ORGÃO_SETOR", "ID_SERVICIO", "NOMBRE_SERVICIO",
							"IDENTIFICADOR_ATENCION", "ID_ESTADO", "NOMBRE_ESTADO");

					Row row = sheet.createRow(rowNum++);
					for (int i = 0; i < titulos.size(); i++) {
						Cell cell = row.createCell(i);
						cell.setCellValue(titulos.get(i));
					}

					System.out.println(sheet.getSheetName() + ": " + rowNum);
					for (DetalleGestionAtencionDTO detalleGestionAtencionDTO : excelDTO
							.getDetalleGestionAtencionDTOs()) {
						row = sheet.createRow(rowNum++);
						int colNum = 0;
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getIdDetalleGestionAtencion());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getIdGestionAtencion());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getSolicitudAtencion());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getNroAtencion());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getFechaAtencion());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getIdSubsede());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getNombreSubsede());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getIdEntidadPrestadora());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getOrgaoSetor());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getIdServicio());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getNombreServicio());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getIdentificadorAtencion());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getIdEstado());
						row.createCell(colNum++).setCellValue(detalleGestionAtencionDTO.getNombreEstado());
					}
					System.out.println(sheet.getSheetName() + ": " + rowNum);
				}

				if (!excelDTO.getEvaluacionAtencionDTOs().isEmpty()) {
					int rowNum = 0;
					Sheet sheet = workbook.createSheet("EVALUACION_ATENCION");
					List<String> titulos = Arrays.asList("ID_EVALUACION_ATENCION", "ID_GESTION_ATENCION",
							"SOLICITUD_ATENCION", "NRO_ATENCION", "FECHA_ATENCION", "ID_SUBSEDE", "NOMBRE_SUBSEDE",
							"ID_DISPOSITIVO_ATENCION", "ID_TAQUILLA", "NOMBRE_TAQUILLA", "IDENTIFICADOR_DISPOSITIVO",
							"EVALUAR_ATENCION", "FECHA_INICIO", "FECHA_FIN");

					Row row = sheet.createRow(rowNum++);
					for (int i = 0; i < titulos.size(); i++) {
						Cell cell = row.createCell(i);
						cell.setCellValue(titulos.get(i));
					}

					System.out.println(sheet.getSheetName() + ": " + rowNum);
					for (EvaluacionAtencionDTO evaluacionAtencionDTO : excelDTO.getEvaluacionAtencionDTOs()) {
						row = sheet.createRow(rowNum++);
						int colNum = 0;
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getIdEvaluacionAtencion());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getIdGestionAtencion());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getSolicitudAtencion());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getNroAtencion());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getFechaAtencion());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getIdSubsede());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getNombreSubsede());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getIdDispositivoAtencion());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getIdTaquilla());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getNombreTaquilla());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getIdentificadorDispositivo());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getEvaluarAtencion());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getFechaInicio());
						row.createCell(colNum++).setCellValue(evaluacionAtencionDTO.getFechaFin());
					}
					System.out.println(sheet.getSheetName() + ": " + rowNum);
				}

				if (!excelDTO.getMaestroGestionAtencionDTOs().isEmpty()) {
					int rowNum = 0;
					Sheet sheet = workbook.createSheet("MAESTRO_GESTION_ATENCION");
					List<String> titulos = Arrays.asList("ID_SUBSEDE", "NOMBRE_SUBSEDE", "ID_GESTION_ATENCION",
							"SOLICITUD_ATENCION", "NRO_ATENCION", "NUMERO_RADICADO", "ID_PERSONA", "NUMERO_DOCUMENTO",
							"CIDADÃO", "SOBENOME", "FECHA_ATENCION", "ID_ESTADO", "NOMBRE_ESTADO");

					Row row = sheet.createRow(rowNum++);
					for (int i = 0; i < titulos.size(); i++) {
						Cell cell = row.createCell(i);
						cell.setCellValue(titulos.get(i));
					}

					System.out.println(sheet.getSheetName() + ": " + rowNum);
					for (MaestroGestionAtencionDTO maestroGestionAtencionDTO : excelDTO
							.getMaestroGestionAtencionDTOs()) {
						row = sheet.createRow(rowNum++);
						int colNum = 0;
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getIdSubsede());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getNombreSubsede());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getIdGestionAtencion());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getSolicitudAtencion());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getNroAtencion());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getNumeroRadicado());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getIdPersona());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getNumeroDocumento());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getCidadao());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getSobenome());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getFechaAtencion());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getIdEstado());
						row.createCell(colNum++).setCellValue(maestroGestionAtencionDTO.getNombreEstado());
					}
					System.out.println(sheet.getSheetName() + ": " + rowNum);
				}

				if (!excelDTO.getResultadoEvaluacionDTOs().isEmpty()) {
					int rowNum = 0;
					Sheet sheet = workbook.createSheet("RESULTADO_EVALUACION");
					List<String> titulos = Arrays.asList("ID_RESULTADO_ENCUESTA", "ID_EVALUACION_ATENCION",
							"ID_GESTION_ATENCION", "SOLICITUD_ATENCION", "NRO_ATENCION", "FECHA_ATENCION", "ID_SUBSEDE",
							"NOMBRE_SUBSEDE", "ID_TAQUILLA", "NOMBRE_TAQUILLA", "ID_PREGUNTA_CALIFICACION", "PREGUNTA",
							"ID_CALIFICACION_SERVICIO", "NOMBRE_CALIFICACION");

					Row row = sheet.createRow(rowNum++);
					for (int i = 0; i < titulos.size(); i++) {
						Cell cell = row.createCell(i);
						cell.setCellValue(titulos.get(i));
					}

					System.out.println(sheet.getSheetName() + ": " + rowNum);
					for (ResultadoEvaluacionDTO resultadoEvaluacionDTO : excelDTO.getResultadoEvaluacionDTOs()) {
						row = sheet.createRow(rowNum++);
						int colNum = 0;
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getIdResultadoEncuesta());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getIdEvaluacionAtencion());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getIdGestionAtencion());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getSolicitudAtencion());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getNroAtencion());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getFechaAtencion());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getIdSubsede());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getNombreSubsede());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getIdTaquilla());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getNombreTaquilla());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getIdPreguntaCalificacion());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getPregunta());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getIdCalificacionServicio());
						row.createCell(colNum++).setCellValue(resultadoEvaluacionDTO.getNombreCalificacion());
					}
					System.out.println(sheet.getSheetName() + ": " + rowNum);
				}

				workbook.write(outputStream);

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Arquivo Excel criado com sucesso!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
