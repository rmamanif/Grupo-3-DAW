package aplicaciones.spring.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proveedor")
	private Long id;
	@NotNull
	@Column(name="nom_empresa")
	private String nempresa;	
	@NotNull
	private String telefono;		
	@NotNull
	private String direccion;
	
	public Proveedor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNempresa() {
		return nempresa;
	}

	public void setNempresa(String nempresa) {
		this.nempresa = nempresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Proveedor(Long id, String nempresa, String telefono, String direccion) {
		super();
		this.id = id;
		this.nempresa = nempresa;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nempresa=" + nempresa + ", telefono=" + telefono + ", direccion=" + direccion
				+ "]";
	}

	
	
}


