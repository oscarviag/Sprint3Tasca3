package nivell2mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexio {
	
	ParametresConnexio connexioParams;
	
	public Connexio() {
		this.connexioParams = new ParametresConnexio();
	}

	public Connexio(ParametresConnexio parametres) {
		this.setconnexioParams(parametres);

	}

	public ParametresConnexio getconnexioParams() {
		return connexioParams;
	}

	public void setconnexioParams(ParametresConnexio connexioParams) {
		this.connexioParams = connexioParams;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
	
		Connection connection = null;

		String url = this.getconnexioParams().getCadenaConnexio();
		System.out.println(url);
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		connection = DriverManager.getConnection(url);

		return connection;
	}


}
