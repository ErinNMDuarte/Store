package modelo;

public class VentasDTO {
	
	private int codigo;
	private long cedula;
	private long cedula_usuario;
	private double ivaventa;
	private double totalventa;
	private double valorventa;
	public VentasDTO(int codigo, long cedula, long cedula_usuario, double ivaventa, double totalventa,
			double valorventa) {
		super();
		this.codigo = codigo;
		this.cedula = cedula;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.totalventa = totalventa;
		this.valorventa = valorventa;
	}
	public VentasDTO(long cedula, long cedula_usuario, double ivaventa, double totalventa, double valorventa) {
		super();
		this.cedula = cedula;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.totalventa = totalventa;
		this.valorventa = valorventa;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public double getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}
	public double getTotalventa() {
		return totalventa;
	}
	public void setTotalventa(double totalventa) {
		this.totalventa = totalventa;
	}
	public double getValorventa() {
		return valorventa;
	}
	public void setValorventa(double valorventa) {
		this.valorventa = valorventa;
	}
	
	

}
