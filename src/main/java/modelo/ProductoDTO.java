package modelo;

public class ProductoDTO {
	
	private int codpro;
	private int ivacom;
	private int nitpro;
	private String nompro;
	private int preciocom;
	private int precioven;
	
	public ProductoDTO(int codpro, int ivacom, int nitpro, String nompro, int preciocom, int precioven) {
		super();
		this.codpro = codpro;
		this.ivacom = ivacom;
		this.nitpro = nitpro;
		this.nompro = nompro;
		this.preciocom = preciocom;
		this.precioven = precioven;
	}
	
	public ProductoDTO(int codpro) {
		super();
		this.codpro = codpro;
	}

	
	
	
	public int getCodpro() {
		return codpro;
	}
	public void setCodpro(int codpro) {
		this.codpro = codpro;
	}
	public int getIvacom() {
		return ivacom;
	}
	public void setIvacom(int ivacom) {
		this.ivacom = ivacom;
	}
	public int getNitpro() {
		return nitpro;
	}
	public void setNitpro(int nitpro) {
		this.nitpro = nitpro;
	}
	public String getNompro() {
		return nompro;
	}
	public void setNompro(String nompro) {
		this.nompro = nompro;
	}
	public int getPreciocom() {
		return preciocom;
	}
	public void setPreciocom(int preciocom) {
		this.preciocom = preciocom;
	}
	public int getPrecioven() {
		return precioven;
	}
	public void setPrecioven(int precioven) {
		this.precioven = precioven;
	}
	
	

}
