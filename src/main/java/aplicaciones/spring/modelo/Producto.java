package aplicaciones.spring.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;


@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Long id;
	@NotNull
	@Column(name="id_proveedor")
	private Long idpvd;
	@NotNull
	@Column(name="nom_producto")
	private String nombre;
	@NotNull
	@Column(name="pro_precio")
	private Double precio;
	@NotNull
	@Column(name="pro_categoria")
	private String categoria;
	@NotNull
	@Column(name="pro_stock")
	private Integer stock;
	@NotNull
	@Column(name="pro_descripcion")
	private String descripcion;
	
	public Producto() {
		super();
	}

	
	
	
	public Producto(Long id, Long idpvd, String nombre, Double precio, String categoria, Integer stock,
			String descripcion) {
		super();
		this.id = id;
		this.idpvd = idpvd;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock;
		this.descripcion = descripcion;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Long getIdpvd() {
		return idpvd;
	}




	public void setIdpvd(Long idpvd) {
		this.idpvd = idpvd;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Double getPrecio() {
		return precio;
	}




	public void setPrecio(Double precio) {
		this.precio = precio;
	}




	public String getCategoria() {
		return categoria;
	}




	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	public Integer getStock() {
		return stock;
	}




	public void setStock(Integer stock) {
		this.stock = stock;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	@Override
	public String toString() {
		return "Producto [id=" + id + ", idpvd=" + idpvd + ", nombre=" + nombre + ", precio=" + precio + ", categoria="
				+ categoria + ", stock=" + stock + ", descripcion=" + descripcion + "]";
	}


	
	
	
}

