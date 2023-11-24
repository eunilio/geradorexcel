package geradorExcelBD.fabrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoOracle {
	// Configura��es de conex�o
	private String jdbcUrl;
	private String username;
	private String password;

	public ConexaoOracle() {
		super();
		this.jdbcUrl = "jdbc:oracle:thin:@QXDBSERVER28:1523/PDBDEVSHOP";
		this.username = "QXDIGITALES";
		this.password = "tto1";
	}

	
	public Connection conexao() throws ClassNotFoundException, SQLException {
		// Carregar o driver JDBC
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Estabelecer a conex�o
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        
		return connection;
	}
}
