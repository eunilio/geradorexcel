package geradorexcel;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CSVtoExcel {
	public static void main(String[] args) throws CsvException {
		// Lista de nomes de arquivos CSV
		String[] arquivosCsv = { "ATENCION_PROCESO.csv", "DETALLE_ATENCION_PROCESO.csv", "DETALLE_GESTION_ATENCION.csv",
				"EVALUACION_ATENCION.csv", "MAESTRO_GESTION_ATENCION.csv", "RESULTADO_EVALUACION.csv" };

		try (FileOutputStream outputStream = new FileOutputStream(
				"C:\\Quipux\\excelLeitura\\Arquivos\\EXTRACAO_COEF.xlsx")) {

			try (SXSSFWorkbook workbook = new SXSSFWorkbook()) {
				for (int i = 0; i < arquivosCsv.length; i++) {
					// Lê o arquivo CSV
					List<String[]> linhas = null;
					linhas = lerCSV(arquivosCsv[i]);

					// Cria uma nova planilha
					Sheet sheet = workbook.createSheet(arquivosCsv[i].replace(".csv", ""));

					// Preenche a planilha com os dados do arquivo CSV
					preencherPlanilha(sheet, linhas);

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

	// Método para ler o conteúdo de um arquivo CSV
	private static List<String[]> lerCSV(String arquivo) throws IOException, CsvException {
		String path = "C:\\Quipux\\excelLeitura\\Arquivos\\";
		Charset charset = Charset.forName("UTF-8");
		try (FileReader fr = new FileReader(path + arquivo, charset)) {
			CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
			CSVReader reader = new CSVReaderBuilder(fr).withCSVParser(parser).build();
					
			return reader.readAll();
		}
	}

	// Método para preencher uma planilha com os dados do arquivo CSV
	private static void preencherPlanilha(Sheet sheet, List<String[]> linhas) {
		int rowNum = 0;
		for (String[] linha : linhas) {
			System.out.println(sheet.getSheetName() + ": " + rowNum);
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for (String campo : linha) {
				Cell cell = row.createCell(colNum++);
				cell.setCellValue(campo);
			}
		}
	}
}
