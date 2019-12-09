package ejercicioshbm.ej2;

public class Direccion implements java.io.Serializable {

	private Integer id;
	private String calle;
	private Integer numero;
	private String poblacion;
	private String provincia;

	public Direccion() {
	}

	public Direccion(String calle, Integer numero, String poblacion, String provincia) {
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", poblacion=" + poblacion
				+ ", provincia=" + provincia + "]";
	}
}
