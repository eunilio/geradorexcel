package geradorExcelBD.dto;

import java.util.List;

public class ExcelDTO {
	private List<AtencionProcesoDTO> atencionProcesoDTOs;
	private List<DetalleAtencionProcesoDTO> detalleAtencionProcesoDTOs;
	private List<DetalleGestionAtencionDTO> detalleGestionAtencionDTOs;
	private List<EvaluacionAtencionDTO> evaluacionAtencionDTOs;
	private List<MaestroGestionAtencionDTO> maestroGestionAtencionDTOs;
	private List<ResultadoEvaluacionDTO> resultadoEvaluacionDTOs;

	public ExcelDTO(List<AtencionProcesoDTO> atencionProcesoDTOs,
			List<DetalleAtencionProcesoDTO> detalleAtencionProcesoDTOs,
			List<DetalleGestionAtencionDTO> detalleGestionAtencionDTOs,
			List<EvaluacionAtencionDTO> evaluacionAtencionDTOs,
			List<MaestroGestionAtencionDTO> maestroGestionAtencionDTOs,
			List<ResultadoEvaluacionDTO> resultadoEvaluacionDTOs) {
		super();
		this.atencionProcesoDTOs = atencionProcesoDTOs;
		this.detalleAtencionProcesoDTOs = detalleAtencionProcesoDTOs;
		this.detalleGestionAtencionDTOs = detalleGestionAtencionDTOs;
		this.evaluacionAtencionDTOs = evaluacionAtencionDTOs;
		this.maestroGestionAtencionDTOs = maestroGestionAtencionDTOs;
		this.resultadoEvaluacionDTOs = resultadoEvaluacionDTOs;
	}

	public List<AtencionProcesoDTO> getAtencionProcesoDTOs() {
		return atencionProcesoDTOs;
	}

	public void setAtencionProcesoDTOs(List<AtencionProcesoDTO> atencionProcesoDTOs) {
		this.atencionProcesoDTOs = atencionProcesoDTOs;
	}

	public List<DetalleAtencionProcesoDTO> getDetalleAtencionProcesoDTOs() {
		return detalleAtencionProcesoDTOs;
	}

	public void setDetalleAtencionProcesoDTOs(List<DetalleAtencionProcesoDTO> detalleAtencionProcesoDTOs) {
		this.detalleAtencionProcesoDTOs = detalleAtencionProcesoDTOs;
	}

	public List<DetalleGestionAtencionDTO> getDetalleGestionAtencionDTOs() {
		return detalleGestionAtencionDTOs;
	}

	public void setDetalleGestionAtencionDTOs(List<DetalleGestionAtencionDTO> detalleGestionAtencionDTOs) {
		this.detalleGestionAtencionDTOs = detalleGestionAtencionDTOs;
	}

	public List<EvaluacionAtencionDTO> getEvaluacionAtencionDTOs() {
		return evaluacionAtencionDTOs;
	}

	public void setEvaluacionAtencionDTOs(List<EvaluacionAtencionDTO> evaluacionAtencionDTOs) {
		this.evaluacionAtencionDTOs = evaluacionAtencionDTOs;
	}

	public List<MaestroGestionAtencionDTO> getMaestroGestionAtencionDTOs() {
		return maestroGestionAtencionDTOs;
	}

	public void setMaestroGestionAtencionDTOs(List<MaestroGestionAtencionDTO> maestroGestionAtencionDTOs) {
		this.maestroGestionAtencionDTOs = maestroGestionAtencionDTOs;
	}

	public List<ResultadoEvaluacionDTO> getResultadoEvaluacionDTOs() {
		return resultadoEvaluacionDTOs;
	}

	public void setResultadoEvaluacionDTOs(List<ResultadoEvaluacionDTO> resultadoEvaluacionDTOs) {
		this.resultadoEvaluacionDTOs = resultadoEvaluacionDTOs;
	}
}
