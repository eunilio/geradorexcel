package geradorexcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUnico {
	Workbook workbookDestino = new XSSFWorkbook();

	public void gerarExcel(String nomeArquivo, int contador) throws IOException {
		String arquivoOrigem = "C:\\Quipux\\excelLeitura\\Arquivos\\" + nomeArquivo.replace(".xlsx", "") + ".xlsx";
		String arquivoDestino = "C:\\Quipux\\excelLeitura\\Arquivos\\EXTRACAO_COEF.xlsx";
		System.out.println(arquivoOrigem);
		
		try (Workbook workbookOrigem = getWorkbook(arquivoOrigem)) {
			Sheet sheetOrigem = workbookOrigem.getSheetAt(0);
			Sheet sheetDestino = workbookDestino.createSheet();
			workbookDestino.setSheetName(contador, nomeArquivo);

			Map<CellStyle, CellStyle> styleMap = new HashMap<>();

			for (int rowIndex = 0; rowIndex <= sheetOrigem.getLastRowNum(); rowIndex++) {
				Row rowOrigem = sheetOrigem.getRow(rowIndex);
				Row rowDestino = sheetDestino.createRow(rowIndex);

				if (rowOrigem != null) {
					for (int colIndex = 0; colIndex < rowOrigem.getLastCellNum(); colIndex++) {
						Cell cellOrigem = rowOrigem.getCell(colIndex);
						Cell cellDestino = rowDestino.createCell(colIndex);

						if (cellOrigem != null) {
							if (cellOrigem.getCellType() == CellType.NUMERIC) {
								cellDestino.setCellValue(cellOrigem.getNumericCellValue());
							} else if (cellOrigem.getCellType() == CellType.STRING) {
								cellDestino.setCellValue(cellOrigem.getStringCellValue());
							}

							CellStyle cellStyleOrigem = cellOrigem.getCellStyle();

							CellStyle cellStyleDestino = styleMap.get(cellStyleOrigem);

							if (cellStyleDestino == null) {
								cellStyleDestino = workbookDestino.createCellStyle();
								cellStyleDestino.cloneStyleFrom(cellStyleOrigem);
								styleMap.put(cellStyleOrigem, cellStyleDestino);
							}

							cellDestino.setCellStyle(cellStyleDestino);
						}
					}
				}
			}

			try (FileOutputStream fileOut = new FileOutputStream(arquivoDestino)) {
				workbookDestino.write(fileOut);
			}

			System.out.println("Novo arquivo do Excel criado com sucesso em: " + arquivoDestino);
		}
	}

	private Workbook getWorkbook(String filePath) throws IOException {
		try (FileInputStream fis = new FileInputStream(filePath)) {
			if (filePath.endsWith(".xls")) {
				return new HSSFWorkbook(fis);
			} else if (filePath.endsWith(".xlsx")) {
				return new XSSFWorkbook(fis);
			} else {
				throw new IllegalArgumentException("O arquivo não é um arquivo do Excel válido.");
			}
		}
	}
}
