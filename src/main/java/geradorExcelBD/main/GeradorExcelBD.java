package geradorExcelBD.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import geradorExcelBD.dao.Generico;
import geradorExcelBD.dto.AtencionProcesoDTO;
import geradorExcelBD.dto.DetalleAtencionProcesoDTO;
import geradorExcelBD.dto.DetalleGestionAtencionDTO;
import geradorExcelBD.dto.EvaluacionAtencionDTO;
import geradorExcelBD.dto.ExcelDTO;
import geradorExcelBD.dto.MaestroGestionAtencionDTO;
import geradorExcelBD.dto.ResultadoEvaluacionDTO;
import geradorExcelBD.fabrica.ConexaoOracle;

public class GeradorExcelBD {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		ExcelDTO excelDTO = null;

		int year = 2023;
		int month = Calendar.APRIL;
		Integer id = 40;

		try {
			ConexaoOracle conexaoOracle = new ConexaoOracle();
			Generico dao = new Generico();

			Date primeiroDiaDoMes = getFirstDayOfMonth(year, month);
			Date ultimoDiaDoMes = getLastDayOfMonth(year, month);

			connection = conexaoOracle.conexao();

			List<AtencionProcesoDTO> atencionProcesoDTOs = dao.findAtencionProceso(id, primeiroDiaDoMes, ultimoDiaDoMes,
					connection);
			System.out.println("AtencionProcesoDTO: " + atencionProcesoDTOs.size());

			List<DetalleAtencionProcesoDTO> detalleAtencionProcesoDTOs = dao.findDetalleAtencionProceso(id,
					primeiroDiaDoMes, ultimoDiaDoMes, connection);
			System.out.println("DetalleAtencionProcesoDTO: " + detalleAtencionProcesoDTOs.size());

			List<DetalleGestionAtencionDTO> detalleGestionAtencionDTOs = dao.findDetalleGestionAtencion(id,
					primeiroDiaDoMes, ultimoDiaDoMes, connection);
			System.out.println("DetalleGestionAtencionDTO: " + detalleGestionAtencionDTOs.size());

			List<EvaluacionAtencionDTO> evaluacionAtencionDTOs = dao.findEvaluacionAtencion(id, primeiroDiaDoMes,
					ultimoDiaDoMes, connection);
			System.out.println("EvaluacionAtencionDTO: " + evaluacionAtencionDTOs.size());

			List<MaestroGestionAtencionDTO> maestroGestionAtencionDTOs = dao.findMaestroGestionAtencion(id,
					primeiroDiaDoMes, ultimoDiaDoMes, connection);
			System.out.println("MaestroGestionAtencionDTO: " + maestroGestionAtencionDTOs.size());

			List<ResultadoEvaluacionDTO> resultadoEvaluacionDTOs = dao.findResultadoEvaluacion(id, primeiroDiaDoMes,
					ultimoDiaDoMes, connection);
			System.out.println("ResultadoEvaluacionDTO: " + resultadoEvaluacionDTOs.size());

			excelDTO = new ExcelDTO(atencionProcesoDTOs, detalleAtencionProcesoDTOs, detalleGestionAtencionDTOs,
					evaluacionAtencionDTOs, maestroGestionAtencionDTOs, resultadoEvaluacionDTOs);

			Gerador gerador = new Gerador();

			gerador.BDtoExcel(excelDTO, id);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	private static Date getFirstDayOfMonth(int year, int month) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(year, month, 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	private static Date getLastDayOfMonth(int year, int month) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(year, month + 1, 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}
}
