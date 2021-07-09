package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	public Connection criarConexao() {
		String url = "jdbc:mysql://localhost:3306/mjv_db"; //Nome da base de dados
		String user = "root"; //nome do usu�rio do MySQL
		String password = "tads1234"; //senha do MySQL

		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			if(e.equals(null))
				System.out.println("O banco de dados n�o foi iniciado.");
			else
			System.out.println("Ocorreu um erro durante conex�o com o banco de dados.\n" + e.getMessage());
		}

		return conexao;
	}
}
