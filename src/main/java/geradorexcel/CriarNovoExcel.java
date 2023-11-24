package geradorexcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriarNovoExcel {
    public static void main(String[] args) throws IOException {
    	ExcelUnico excelUnico = new ExcelUnico();
    	List<String> strings = new ArrayList();
		strings.add("ATENCION_PROCESO");
		strings.add("DETALLE_ATENCION_PROCESO");
		strings.add("DETALLE_GESTION_ATENCION.xlsx");
		strings.add("EVALUACION_ATENCION");
		strings.add("MAESTRO_GESTION_ATENCION");
		strings.add("RESULTADO_EVALUACION");
		
		int contador = 0;
		
		for (String nomeArquivo : strings) {
			excelUnico.gerarExcel(nomeArquivo, contador);
			contador++;
		}
		System.out.println("Finalizado!");
    }
}
