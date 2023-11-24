package geradorExcelBD.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import geradorExcelBD.dto.AtencionProcesoDTO;
import geradorExcelBD.dto.DetalleAtencionProcesoDTO;
import geradorExcelBD.dto.DetalleGestionAtencionDTO;
import geradorExcelBD.dto.EvaluacionAtencionDTO;
import geradorExcelBD.dto.MaestroGestionAtencionDTO;
import geradorExcelBD.dto.ResultadoEvaluacionDTO;

public class Generico {
	private String queryAtencionProceso = "SELECT     AP.ID_PROCESO_ATENCION,     AP.ID_GESTION_ATENCION,     MGA.SOLICITUD_ATENCION,     MGA.NRO_ATENCION,     MGA.FECHA_ATENCION,     MGA.ID_SUBSEDE,     TES.NOMBRE_SUBSEDE,     AP.ID_ESTADO,     TEA.NOMBRE_ESTADO,     AP.ID_USUARIO,     US.USUARIO_ACCESO,     PI.NUMERO_DOCUMENTO,     MP.NOMBRE,     MPN.APELLIDO_1,     AP.FECHA_INICIAL,     AP.FECHA_FINAL,     AP.TIEMPO_PROCESO,     AP.ACTIVO FROM TURNOS.ATENCION_PROCESO AP LEFT JOIN TURNOS.MAESTRO_GESTION_ATENCION MGA ON MGA.ID_GESTION_ATENCION = AP.ID_GESTION_ATENCION LEFT JOIN TURNOS.TIPO_ESTADO_ATENCION TEA ON TEA.ID_ESTADO = AP.ID_ESTADO LEFT JOIN CORE.TIPO_ENTIDAD_SUBSEDE TES ON TES.ID_SUBSEDE = MGA.ID_SUBSEDE LEFT JOIN CORE.USUARIO_SISTEMA US ON US.ID_USUARIO = AP.ID_USUARIO LEFT JOIN CORE.MAESTRO_PERSONA MP ON MP.ID_PERSONA = US.ID_PERSONA_NATURAL LEFT JOIN CORE.PERSONA_IDENTIFICACION PI ON PI.ID_PERSONA = MP.ID_PERSONA LEFT JOIN CORE.MAESTRO_PERSONA_NATURAL MPN ON MPN.ID_PERSONA = MP.ID_PERSONA WHERE MGA.FECHA_ATENCION BETWEEN ? AND ? AND MGA.ID_SUBSEDE = ?";
	private String queryDetalleAtencionProceso = "SELECT     DAP.ID_DETALLE_ATENCION_PROCESO,     DAP.ID_DETALLE_GESTION_ATENCION,     DGA.ID_GESTION_ATENCION,     MGA.SOLICITUD_ATENCION,     MGA.NRO_ATENCION,     MGA.FECHA_ATENCION,     MGA.ID_SUBSEDE,     TES.NOMBRE_SUBSEDE,     DGA.ID_SERVICIO,     TSA.NOMBRE_SERVICIO,     DGA.IDENTIFICADOR_ATENCION,     DAP.ID_ESTADO,     TEA.NOMBRE_ESTADO,     DAP.ID_TAQUILLA,     TA.NOMBRE_TAQUILLA,     TA.ATIENDE_SERVICIO,     TA.ENCUESTA,     DAP.ID_USUARIO,     US.USUARIO_ACCESO,     PI.NUMERO_DOCUMENTO,     MP.NOMBRE,     MPN.APELLIDO_1,     DAP.FECHA_INICIAL,     DAP.FECHA_FINAL,     DAP.TIEMPO_PROCESO,     DAP.ACTIVO FROM TURNOS.DETALLE_ATENCION_PROCESO DAP LEFT JOIN TURNOS.DETALLE_GESTION_ATENCION DGA ON DGA.ID_DETALLE_GESTION_ATENCION = DAP.ID_DETALLE_GESTION_ATENCION LEFT JOIN TURNOS.MAESTRO_GESTION_ATENCION MGA ON MGA.ID_GESTION_ATENCION = DGA.ID_GESTION_ATENCION LEFT JOIN TURNOS.TIPO_ESTADO_ATENCION TEA ON TEA.ID_ESTADO = DAP.ID_ESTADO LEFT JOIN TURNOS.TIPO_SERVICIO_ATENCION TSA ON TSA.ID_SERVICIO = DGA.ID_SERVICIO LEFT JOIN CORE.TIPO_ENTIDAD_SUBSEDE TES ON TES.ID_SUBSEDE = MGA.ID_SUBSEDE LEFT JOIN TURNOS.TAQUILLA_ATENCION TA ON TA.ID_TAQUILLA = DAP.ID_TAQUILLA LEFT JOIN CORE.USUARIO_SISTEMA US ON US.ID_USUARIO = DAP.ID_USUARIO LEFT JOIN CORE.MAESTRO_PERSONA MP ON MP.ID_PERSONA = US.ID_PERSONA_NATURAL LEFT JOIN CORE.PERSONA_IDENTIFICACION PI ON PI.ID_PERSONA = MP.ID_PERSONA LEFT JOIN CORE.MAESTRO_PERSONA_NATURAL MPN ON MPN.ID_PERSONA = MP.ID_PERSONA WHERE MGA.FECHA_ATENCION BETWEEN ? AND ? AND MGA.ID_SUBSEDE = ?";
	private String queryDetalleGestionAtencion = "SELECT     DGA.ID_DETALLE_GESTION_ATENCION,     DGA.ID_GESTION_ATENCION,     MGA.SOLICITUD_ATENCION,     MGA.NRO_ATENCION,     MGA.FECHA_ATENCION,     MGA.ID_SUBSEDE,     TES.NOMBRE_SUBSEDE,     TSA.ID_ENTIDAD_PRESTADORA,     EPS.NOMBRE_ENTIDAD,     DGA.ID_SERVICIO,     TSA.NOMBRE_SERVICIO,     DGA.IDENTIFICADOR_ATENCION,     DGA.ID_ESTADO,     TEA.NOMBRE_ESTADO FROM TURNOS.DETALLE_GESTION_ATENCION DGA LEFT JOIN TURNOS.MAESTRO_GESTION_ATENCION MGA ON MGA.ID_GESTION_ATENCION = DGA.ID_GESTION_ATENCION LEFT JOIN TURNOS.TIPO_ESTADO_ATENCION TEA ON TEA.ID_ESTADO = DGA.ID_ESTADO LEFT JOIN TURNOS.TIPO_SERVICIO_ATENCION TSA ON TSA.ID_SERVICIO = DGA.ID_SERVICIO LEFT JOIN CORE.TIPO_ENTIDAD_SUBSEDE TES ON TES.ID_SUBSEDE = MGA.ID_SUBSEDE LEFT JOIN TURNOS.TIPO_ENTIDAD_PRESTADORA_SERVI EPS ON EPS.ID_ENTIDAD_PRESTADORA = TSA.ID_ENTIDAD_PRESTADORA WHERE MGA.FECHA_ATENCION BETWEEN ? AND ? AND MGA.ID_SUBSEDE = ?";
	private String queryEvaluacionAtencion = "SELECT 	EV.ID_EVALUACION_ATENCION, 	EV.ID_GESTION_ATENCION, 	MGA.SOLICITUD_ATENCION, 	MGA.NRO_ATENCION, 	MGA.FECHA_ATENCION, 	MGA.ID_SUBSEDE, 	TES.NOMBRE_SUBSEDE, 	EV.ID_DISPOSITIVO_ATENCION, 	MDA.ID_TAQUILLA, 	TA.NOMBRE_TAQUILLA, 	MDA.IDENTIFICADOR_DISPOSITIVO, 	EV.EVALUAR_ATENCION, 	EV.FECHA_INICIO, 	EV.FECHA_FIN FROM TURNOS.EVALUACION_ATENCION EV LEFT JOIN TURNOS.MAESTRO_GESTION_ATENCION MGA ON MGA.ID_GESTION_ATENCION = EV.ID_GESTION_ATENCION LEFT JOIN TURNOS.MAESTRO_DISPOSITIVO_ATENCION MDA ON MDA.ID_DISPOSITIVO_ATENCION =  EV.ID_DISPOSITIVO_ATENCION LEFT JOIN TURNOS.TAQUILLA_ATENCION TA ON TA.ID_TAQUILLA = MDA.ID_TAQUILLA LEFT JOIN CORE.TIPO_ENTIDAD_SUBSEDE TES ON TES.ID_SUBSEDE = MGA.ID_SUBSEDE WHERE MGA.FECHA_ATENCION BETWEEN ? AND ? AND MGA.ID_SUBSEDE = ?";
	private String queryMaestroGestionAtencion = "SELECT     MGA.ID_SUBSEDE,     TES.NOMBRE_SUBSEDE,     MGA.ID_GESTION_ATENCION,     MGA.SOLICITUD_ATENCION,     MGA.NRO_ATENCION,     MGA.NUMERO_RADICADO,     MGA.ID_PERSONA,     PI.NUMERO_DOCUMENTO,     MP.NOMBRE,     MPN.APELLIDO_1,     MGA.FECHA_ATENCION,     MGA.ID_ESTADO,     TEA.NOMBRE_ESTADO FROM TURNOS.MAESTRO_GESTION_ATENCION MGA LEFT JOIN TURNOS.TIPO_ESTADO_ATENCION TEA ON TEA.ID_ESTADO = MGA.ID_ESTADO LEFT JOIN CORE.TIPO_ENTIDAD_SUBSEDE TES ON TES.ID_SUBSEDE = MGA.ID_SUBSEDE LEFT JOIN CORE.MAESTRO_PERSONA MP ON MP.ID_PERSONA = MGA.ID_PERSONA LEFT JOIN TURNOS.GESTION_ATENCION_PERSONA GAP ON GAP.ID_GESTION_ATENCION = MGA.ID_GESTION_ATENCION LEFT JOIN CORE.PERSONA_IDENTIFICACION PI ON PI.ID_PERSONA_IDENTIFICACION = GAP.ID_PERSONA_IDENTIFICACION LEFT JOIN CORE.MAESTRO_PERSONA_NATURAL MPN ON MPN.ID_PERSONA = MGA.ID_PERSONA WHERE MGA.FECHA_ATENCION BETWEEN ? AND ? AND MGA.ID_SUBSEDE = ?";
	private String queryResultadoEvaluacion = "SELECT 	RE.ID_RESULTADO_ENCUESTA, 	RE.ID_EVALUACION_ATENCION, 	EV.ID_GESTION_ATENCION, 	MGA.SOLICITUD_ATENCION, 	MGA.NRO_ATENCION, 	MGA.FECHA_ATENCION, 	MGA.ID_SUBSEDE, 	TES.NOMBRE_SUBSEDE, 	MDA.ID_TAQUILLA, 	TA.NOMBRE_TAQUILLA, 	RE.ID_PREGUNTA_CALIFICACION, 	TPC.PREGUNTA, 	RE.ID_CALIFICACION_SERVICIO, 	TCS.NOMBRE_CALIFICACION FROM TURNOS.RESULTADO_ENCUESTA RE LEFT JOIN TURNOS.EVALUACION_ATENCION EV ON EV.ID_EVALUACION_ATENCION = RE.ID_EVALUACION_ATENCION LEFT JOIN TURNOS.TIPO_PREGUNTA_CALIFICACION TPC ON TPC.ID_PREGUNTA_CALIFICACION = RE.ID_PREGUNTA_CALIFICACION LEFT JOIN TURNOS.TIPO_CALIFICACION_SERVICIO TCS ON TCS.ID_CALIFICACION_SERVICIO = RE.ID_CALIFICACION_SERVICIO LEFT JOIN TURNOS.MAESTRO_GESTION_ATENCION MGA ON MGA.ID_GESTION_ATENCION = EV.ID_GESTION_ATENCION LEFT JOIN TURNOS.MAESTRO_DISPOSITIVO_ATENCION MDA ON MDA.ID_DISPOSITIVO_ATENCION =  EV.ID_DISPOSITIVO_ATENCION LEFT JOIN TURNOS.TAQUILLA_ATENCION TA ON TA.ID_TAQUILLA = MDA.ID_TAQUILLA LEFT JOIN CORE.TIPO_ENTIDAD_SUBSEDE TES ON TES.ID_SUBSEDE = MGA.ID_SUBSEDE WHERE MGA.FECHA_ATENCION BETWEEN ? AND ? AND MGA.ID_SUBSEDE = ?";
	
	public List<AtencionProcesoDTO> findAtencionProceso(Integer id, Date dataInicio, Date dataFim,
			Connection connection) throws SQLException {
		ResultSet resultado = null;
		PreparedStatement preparedStatement = null;
		List<AtencionProcesoDTO> atencionProcesoDTOs = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(queryAtencionProceso);

			int index = 1;
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataInicio));
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataFim));
			preparedStatement.setInt(index++, id);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				AtencionProcesoDTO atencionProcesoDTO = new AtencionProcesoDTO();
				atencionProcesoDTO.setIdProcesoAtencion(resultado.getString("ID_PROCESO_ATENCION"));
				atencionProcesoDTO.setIdGestionAtencion(resultado.getString("ID_GESTION_ATENCION"));
				atencionProcesoDTO.setSolicitudAtencion(resultado.getString("SOLICITUD_ATENCION"));
				atencionProcesoDTO.setNroAtencion(resultado.getString("NRO_ATENCION"));
				atencionProcesoDTO.setFechaAtencion(resultado.getString("FECHA_ATENCION"));
				atencionProcesoDTO.setIdSubsede(resultado.getString("ID_SUBSEDE"));
				atencionProcesoDTO.setNombreSubsede(resultado.getString("NOMBRE_SUBSEDE"));
				atencionProcesoDTO.setIdEstado(resultado.getString("ID_ESTADO"));
				atencionProcesoDTO.setNombreEstado(resultado.getString("NOMBRE_ESTADO"));
				atencionProcesoDTO.setIdUsuario(resultado.getString("ID_USUARIO"));
				atencionProcesoDTO.setUsuarioAcceso(resultado.getString("USUARIO_ACCESO"));
				atencionProcesoDTO.setNumeroDocumento(resultado.getString("NUMERO_DOCUMENTO"));
				atencionProcesoDTO.setNombre(resultado.getString("NOMBRE"));
				atencionProcesoDTO.setApellido1(resultado.getString("APELLIDO_1"));
				atencionProcesoDTO.setFechaInicial(resultado.getString("FECHA_INICIAL"));
				atencionProcesoDTO.setFechaFinal(resultado.getString("FECHA_FINAL"));
				atencionProcesoDTO.setTiempoProceso(resultado.getString("TIEMPO_PROCESO"));
				atencionProcesoDTO.setActivo(resultado.getString("ACTIVO"));
				
				atencionProcesoDTOs.add(atencionProcesoDTO);
			}

		} finally {
			this.closeResources(preparedStatement, resultado);
		}

		return atencionProcesoDTOs;
	}
	
	public List<DetalleAtencionProcesoDTO> findDetalleAtencionProceso(Integer id, Date dataInicio, Date dataFim,
			Connection connection) throws SQLException {
		ResultSet resultado = null;
		PreparedStatement preparedStatement = null;
		List<DetalleAtencionProcesoDTO> detalleAtencionProcesoDTOs = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(queryDetalleAtencionProceso);

			int index = 1;
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataInicio));
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataFim));
			preparedStatement.setInt(index++, id);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				DetalleAtencionProcesoDTO detalleAtencionProcesoDTO = new DetalleAtencionProcesoDTO();
				detalleAtencionProcesoDTO.setIdDetalleAtencionProceso(resultado.getString("ID_DETALLE_ATENCION_PROCESO"));
				detalleAtencionProcesoDTO.setIdDetalleGestionAtencion(resultado.getString("ID_DETALLE_GESTION_ATENCION"));
				detalleAtencionProcesoDTO.setIdGestionAtencion(resultado.getString("ID_GESTION_ATENCION"));
				detalleAtencionProcesoDTO.setSolicitudAtencion(resultado.getString("SOLICITUD_ATENCION"));
				detalleAtencionProcesoDTO.setNroAtencion(resultado.getString("NRO_ATENCION"));
				detalleAtencionProcesoDTO.setFechaAtencion(resultado.getString("FECHA_ATENCION"));
				detalleAtencionProcesoDTO.setIdSubsede(resultado.getString("ID_SUBSEDE"));
				detalleAtencionProcesoDTO.setNombreSubsede(resultado.getString("NOMBRE_SUBSEDE"));
				detalleAtencionProcesoDTO.setIdServicio(resultado.getString("ID_SERVICIO"));
				detalleAtencionProcesoDTO.setNombreServicio(resultado.getString("NOMBRE_SERVICIO"));
				detalleAtencionProcesoDTO.setIdentificadorAtencion(resultado.getString("IDENTIFICADOR_ATENCION"));
				detalleAtencionProcesoDTO.setIdEstado(resultado.getString("ID_ESTADO"));
				detalleAtencionProcesoDTO.setNombreEstado(resultado.getString("NOMBRE_ESTADO"));
				detalleAtencionProcesoDTO.setIdTaquilla(resultado.getString("ID_TAQUILLA"));
				detalleAtencionProcesoDTO.setNombreTaquilla(resultado.getString("NOMBRE_TAQUILLA"));
				detalleAtencionProcesoDTO.setAtiendeServicio(resultado.getString("ATIENDE_SERVICIO"));
				detalleAtencionProcesoDTO.setEncuesta(resultado.getString("ENCUESTA"));
				detalleAtencionProcesoDTO.setIdUsuario(resultado.getString("ID_USUARIO"));
				detalleAtencionProcesoDTO.setUsuarioAcceso(resultado.getString("USUARIO_ACCESO"));
				detalleAtencionProcesoDTO.setNumeroDocumento(resultado.getString("NUMERO_DOCUMENTO"));
				detalleAtencionProcesoDTO.setNombre(resultado.getString("NOMBRE"));
				detalleAtencionProcesoDTO.setApellido1(resultado.getString("APELLIDO_1"));
				detalleAtencionProcesoDTO.setFechaInicial(resultado.getString("FECHA_INICIAL"));
				detalleAtencionProcesoDTO.setFechaFinal(resultado.getString("FECHA_FINAL"));
				detalleAtencionProcesoDTO.setTiempoProceso(resultado.getString("TIEMPO_PROCESO"));
				detalleAtencionProcesoDTO.setActivo(resultado.getString("ACTIVO"));
				
				detalleAtencionProcesoDTOs.add(detalleAtencionProcesoDTO);
			}

		} finally {
			this.closeResources(preparedStatement, resultado);
		}

		return detalleAtencionProcesoDTOs;
	}
	
	public List<DetalleGestionAtencionDTO> findDetalleGestionAtencion(Integer id, Date dataInicio, Date dataFim,
			Connection connection) throws SQLException {
		ResultSet resultado = null;
		PreparedStatement preparedStatement = null;
		List<DetalleGestionAtencionDTO> detalleGestionAtencionDTOs = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(queryDetalleGestionAtencion);

			int index = 1;
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataInicio));
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataFim));
			preparedStatement.setInt(index++, id);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				DetalleGestionAtencionDTO detalleGestionAtencionDTO = new DetalleGestionAtencionDTO();
				detalleGestionAtencionDTO.setIdDetalleGestionAtencion(resultado.getString("ID_DETALLE_GESTION_ATENCION"));
				detalleGestionAtencionDTO.setIdGestionAtencion(resultado.getString("ID_GESTION_ATENCION"));
				detalleGestionAtencionDTO.setSolicitudAtencion(resultado.getString("SOLICITUD_ATENCION"));
				detalleGestionAtencionDTO.setNroAtencion(resultado.getString("NRO_ATENCION"));
				detalleGestionAtencionDTO.setFechaAtencion(resultado.getString("FECHA_ATENCION"));
				detalleGestionAtencionDTO.setIdSubsede(resultado.getString("ID_SUBSEDE"));
				detalleGestionAtencionDTO.setNombreSubsede(resultado.getString("NOMBRE_SUBSEDE"));
				detalleGestionAtencionDTO.setIdEntidadPrestadora(resultado.getString("ID_ENTIDAD_PRESTADORA"));
				detalleGestionAtencionDTO.setOrgaoSetor(resultado.getString("NOMBRE_ENTIDAD"));
				detalleGestionAtencionDTO.setIdServicio(resultado.getString("ID_SERVICIO"));
				detalleGestionAtencionDTO.setNombreServicio(resultado.getString("NOMBRE_SERVICIO"));
				detalleGestionAtencionDTO.setIdentificadorAtencion(resultado.getString("IDENTIFICADOR_ATENCION"));
				detalleGestionAtencionDTO.setIdEstado(resultado.getString("ID_ESTADO"));
				detalleGestionAtencionDTO.setNombreEstado(resultado.getString("NOMBRE_ESTADO"));
				
				detalleGestionAtencionDTOs.add(detalleGestionAtencionDTO);
			}

		} finally {
			this.closeResources(preparedStatement, resultado);
		}

		return detalleGestionAtencionDTOs;
	}
	
	public List<EvaluacionAtencionDTO> findEvaluacionAtencion(Integer id, Date dataInicio, Date dataFim,
			Connection connection) throws SQLException {
		ResultSet resultado = null;
		PreparedStatement preparedStatement = null;
		List<EvaluacionAtencionDTO> evaluacionAtencionDTOs = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(queryEvaluacionAtencion);

			int index = 1;
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataInicio));
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataFim));
			preparedStatement.setInt(index++, id);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				EvaluacionAtencionDTO evaluacionAtencionDTO = new EvaluacionAtencionDTO();
				evaluacionAtencionDTO.setIdEvaluacionAtencion(resultado.getString("ID_EVALUACION_ATENCION"));
				evaluacionAtencionDTO.setIdGestionAtencion(resultado.getString("ID_GESTION_ATENCION"));
				evaluacionAtencionDTO.setSolicitudAtencion(resultado.getString("SOLICITUD_ATENCION"));
				evaluacionAtencionDTO.setNroAtencion(resultado.getString("NRO_ATENCION"));
				evaluacionAtencionDTO.setFechaAtencion(resultado.getString("FECHA_ATENCION"));
				evaluacionAtencionDTO.setIdSubsede(resultado.getString("ID_SUBSEDE"));
				evaluacionAtencionDTO.setNombreSubsede(resultado.getString("NOMBRE_SUBSEDE"));
				evaluacionAtencionDTO.setIdDispositivoAtencion(resultado.getString("ID_DISPOSITIVO_ATENCION"));
				evaluacionAtencionDTO.setIdTaquilla(resultado.getString("ID_TAQUILLA"));
				evaluacionAtencionDTO.setNombreTaquilla(resultado.getString("NOMBRE_TAQUILLA"));
				evaluacionAtencionDTO.setIdentificadorDispositivo(resultado.getString("IDENTIFICADOR_DISPOSITIVO"));
				evaluacionAtencionDTO.setEvaluarAtencion(resultado.getString("EVALUAR_ATENCION"));
				evaluacionAtencionDTO.setFechaInicio(resultado.getString("FECHA_INICIO"));
				evaluacionAtencionDTO.setFechaFin(resultado.getString("FECHA_FIN"));
				
				evaluacionAtencionDTOs.add(evaluacionAtencionDTO);
			}

		} finally {
			this.closeResources(preparedStatement, resultado);
		}

		return evaluacionAtencionDTOs;
	}
	
	public List<MaestroGestionAtencionDTO> findMaestroGestionAtencion(Integer id, Date dataInicio, Date dataFim,
			Connection connection) throws SQLException {
		ResultSet resultado = null;
		PreparedStatement preparedStatement = null;
		List<MaestroGestionAtencionDTO> maestroGestionAtencionDTOs = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(queryMaestroGestionAtencion);

			int index = 1;
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataInicio));
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataFim));
			preparedStatement.setInt(index++, id);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				MaestroGestionAtencionDTO maestroGestionAtencionDTO = new MaestroGestionAtencionDTO();
				maestroGestionAtencionDTO.setIdSubsede(resultado.getString("ID_SUBSEDE"));
				maestroGestionAtencionDTO.setNombreSubsede(resultado.getString("NOMBRE_SUBSEDE"));
				maestroGestionAtencionDTO.setIdGestionAtencion(resultado.getString("ID_GESTION_ATENCION"));
				maestroGestionAtencionDTO.setSolicitudAtencion(resultado.getString("SOLICITUD_ATENCION"));
				maestroGestionAtencionDTO.setNroAtencion(resultado.getString("NRO_ATENCION"));
				maestroGestionAtencionDTO.setNumeroRadicado(resultado.getString("NUMERO_RADICADO"));
				maestroGestionAtencionDTO.setIdPersona(resultado.getString("ID_PERSONA"));
				maestroGestionAtencionDTO.setNumeroDocumento(resultado.getString("NUMERO_DOCUMENTO"));
				maestroGestionAtencionDTO.setCidadao(resultado.getString("NOMBRE"));
				maestroGestionAtencionDTO.setSobenome(resultado.getString("APELLIDO_1"));
				maestroGestionAtencionDTO.setFechaAtencion(resultado.getString("FECHA_ATENCION"));
				maestroGestionAtencionDTO.setIdEstado(resultado.getString("ID_ESTADO"));
				maestroGestionAtencionDTO.setNombreEstado(resultado.getString("NOMBRE_ESTADO"));
				
				maestroGestionAtencionDTOs.add(maestroGestionAtencionDTO);
			}

		} finally {
			this.closeResources(preparedStatement, resultado);
		}

		return maestroGestionAtencionDTOs;
	}

	public List<ResultadoEvaluacionDTO> findResultadoEvaluacion(Integer id, Date dataInicio, Date dataFim,
			Connection connection) throws SQLException {
		ResultSet resultado = null;
		PreparedStatement preparedStatement = null;
		List<ResultadoEvaluacionDTO> resultadoEvaluacionDTOs = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(queryResultadoEvaluacion);

			int index = 1;
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataInicio));
			preparedStatement.setTimestamp(index++, this.convertToSqlTimestamp(dataFim));
			preparedStatement.setInt(index++, id);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				ResultadoEvaluacionDTO resultadoEvaluacionDTO = new ResultadoEvaluacionDTO();
				resultadoEvaluacionDTO.setIdResultadoEncuesta(resultado.getString("ID_RESULTADO_ENCUESTA"));
				resultadoEvaluacionDTO.setIdEvaluacionAtencion(resultado.getString("ID_EVALUACION_ATENCION"));
				resultadoEvaluacionDTO.setIdGestionAtencion(resultado.getString("ID_GESTION_ATENCION"));
				resultadoEvaluacionDTO.setSolicitudAtencion(resultado.getString("SOLICITUD_ATENCION"));
				resultadoEvaluacionDTO.setNroAtencion(resultado.getString("NRO_ATENCION"));
				resultadoEvaluacionDTO.setFechaAtencion(resultado.getString("FECHA_ATENCION"));
				resultadoEvaluacionDTO.setIdSubsede(resultado.getString("ID_SUBSEDE"));
				resultadoEvaluacionDTO.setNombreSubsede(resultado.getString("NOMBRE_SUBSEDE"));
				resultadoEvaluacionDTO.setIdTaquilla(resultado.getString("ID_TAQUILLA"));
				resultadoEvaluacionDTO.setNombreTaquilla(resultado.getString("NOMBRE_TAQUILLA"));
				resultadoEvaluacionDTO.setIdPreguntaCalificacion(resultado.getString("ID_PREGUNTA_CALIFICACION"));
				resultadoEvaluacionDTO.setPregunta(resultado.getString("PREGUNTA"));
				resultadoEvaluacionDTO.setIdCalificacionServicio(resultado.getString("ID_CALIFICACION_SERVICIO"));
				resultadoEvaluacionDTO.setNombreCalificacion(resultado.getString("NOMBRE_CALIFICACION"));
				
				resultadoEvaluacionDTOs.add(resultadoEvaluacionDTO);
			}

		} finally {
			this.closeResources(preparedStatement, resultado);
		}

		return resultadoEvaluacionDTOs;
	}
	
	public Timestamp convertToSqlTimestamp(Date date) {
		if (date == null) {
			return null;
		} else {
			return new java.sql.Timestamp(date.getTime());
		}

	}

	public void closeResources(PreparedStatement preparedStatement, ResultSet resultado) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				// logger.error(e.getMessage(), e);
			}
		}
		if (resultado != null) {
			try {
				resultado.close();
			} catch (Exception e) {
				// logger.error(e.getMessage(), e);
			}
		}
	}
}
