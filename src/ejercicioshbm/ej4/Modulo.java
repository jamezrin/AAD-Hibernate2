package ejercicioshbm.ej4;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Modulo", catalog = "profesor")
public class Modulo implements Serializable {
	private Integer id;
	private String nombre;
	private Float creditos;
	private Set<Profesor> profesores = new HashSet<>();
	
	public Modulo() {
	}
	
	public Modulo(Integer id, String nombre, Float creditos, Set<Profesor> profesores) {
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
		this.profesores = profesores;
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
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "creditos")
	public Float getCreditos() {
		return creditos;
	}
	
	public void setCreditos(Float creditos) {
		this.creditos = creditos;
	}
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", profesores=" + profesores
				+ "]";
	}
}
