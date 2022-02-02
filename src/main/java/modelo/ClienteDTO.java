package modelo;

public class ClienteDTO {
	
	private int doccli;//documento de cliente
	private String nomcli;//nombre de cliente
	private String dircli;//direccion de cliente
	private String telcli;//telefono de cliente
	private String emailcli;//correo de cliente
	public ClienteDTO(int doccli, String nomcli, String dircli, String telcli, String emailcli) {
		this.doccli = doccli;
		this.nomcli = nomcli;
		this.dircli = dircli;
		this.telcli = telcli;
		this.emailcli = emailcli;
	}
	
		
	public ClienteDTO(int doccli) {
		super();
		this.doccli = doccli;
	}



	public int getDoccli() {
		return doccli;
	}
	public void setDoccli(int doccli) {
		this.doccli = doccli;
	}
	public String getNomcli() {
		return nomcli;
	}
	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}
	public String getDircli() {
		return dircli;
	}
	public void setDircli(String dircli) {
		this.dircli = dircli;
	}
	public String getTelcli() {
		return telcli;
	}
	public void setTelcli(String telcli) {
		this.telcli = telcli;
	}
	public String getEmailcli() {
		return emailcli;
	}
	public void setEmailcli(String emailcli) {
		this.emailcli = emailcli;
	}
	
	
	
	
	

}
