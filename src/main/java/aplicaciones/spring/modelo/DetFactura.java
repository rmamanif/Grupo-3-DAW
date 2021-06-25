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
@Table(name = "det_factura")
public class DetFactura implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle")
	private Long id;
	@Column(name="id_factura")
	private Long idf;
	@NotNull
	@Column(name="id_producto")
	private Long producto;
	@NotNull
	private Integer cantidad;
	@NotNull
	private Double precio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdf() {
		return idf;
	}
	public void setIdf(Long idf) {
		this.idf = idf;
	}
	public Long getProducto() {
		return producto;
	}
	public void setProducto(Long producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DetFactura [id=" + id + ", idf=" + idf + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}
	public DetFactura(Long id, Long idf, Long producto, Integer cantidad, Double precio) {
		super();
		this.id = id;
		this.idf = idf;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public DetFactura() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


}
