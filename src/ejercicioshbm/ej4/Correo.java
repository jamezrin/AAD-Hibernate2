package ejercicioshbm.ej4;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Correo", catalog = "profesor")
public class Correo implements Serializable {
	private Integer id;
	private String direccion;
	private String proveedor;
	private Profesor profesor;

	public Correo() {
	}
	
	public Correo(Integer id, String direccion, String proveedor, Profesor profesor) {
		this.id = id;
		this.direccion = direccion;
		this.proveedor = proveedor;
		this.profesor = profesor;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column(name = "proveedor")
	public String getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@ManyToOne
	@JoinColumn(name = "profesor_id")
	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Correo [id=" + id + ", direccion=" + direccion + ", proveedor=" + proveedor + ", profesor=" + profesor
				+ "]";
	}
}
