package nivell2mySQL;

public class ParametresConnexio {

	public ParametresConnexio() {

		this.setProtocol("jdbc");
		this.setTipusBaseDades("mysql");
		this.setServidor("localhost"); 
		this.setPort(3306);
		this.setNomBaseDades("floristeria");
		this.setNomUsuari("prova");
		this.setClauUsuari("1a2b3c");
		
	}

	public ParametresConnexio(String protocol, String tipusBaseDades, String servidor, int port, String nomBaseDades,
			String nomUsuari, String clauUsuari) {
		this.setProtocol(protocol);
		this.setTipusBaseDades(tipusBaseDades);
		this.setServidor(servidor);
		this.setPort(port);
		this.setNomBaseDades(nomBaseDades);
		this.setNomUsuari(nomUsuari);
		this.setClauUsuari(clauUsuari);
	}

	private String protocol;
	private String tipusBaseDades;
	private String servidor;
	private int port;
	private String nomBaseDades;
	private String nomUsuari;
	private String clauUsuari;

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getTipusBaseDades() {
		return tipusBaseDades;
	}

	public void setTipusBaseDades(String tipusBaseDades) {
		this.tipusBaseDades = tipusBaseDades;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getNomBaseDades() {
		return nomBaseDades;
	}

	public void setNomBaseDades(String nomBaseDades) {
		this.nomBaseDades = nomBaseDades;
	}

	public String getNomUsuari() {
		return nomUsuari;
	}

	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
	}

	public String getClauUsuari() {
		return clauUsuari;
	}

	public void setClauUsuari(String clauUsuari) {
		this.clauUsuari = clauUsuari;
	}

	public String getCadenaConnexio() {
		String cadena = protocol + ":" + tipusBaseDades + "://" + servidor + ":" + port + "/" + nomBaseDades + "?user="
				+ nomUsuari + "&password=" + clauUsuari;

		System.out.println("Cadena connexió: " + cadena);
		return cadena;

	}

}
