package ejercicioshbm.ej2;

public class Profesor implements java.io.Serializable {
	private Integer id;
	private String nombre;
	private String ape1;
	private String ape2;
	private Direccion direccion;

	public Profesor() {
	}

	public Profesor(String nombre, String ape1, String ape2, Direccion direccion) {
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.direccion = direccion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", direccion="
				+ direccion + "]";
	}
}
