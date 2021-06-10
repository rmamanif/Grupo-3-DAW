package aplicaciones.spring.modelo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sun.istack.NotNull;
@Entity
@Table(name = "VENTAS")
public class Venta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@NotNull
	private Long producto;
	@NotNull
	private Long cliente;
	@NotNull
	private Integer cantidad;
	@NotNull
	private Double subtotal;
	@NotNull
	private Double igv;
	@NotNull
	private Double total;
	
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Long getProducto() {
		return producto;
	}


	public void setProducto(Long producto) {
		this.producto = producto;
	}


	public Long getCliente() {
		return cliente;
	}


	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}


	public Double getIgv() {
		return igv;
	}


	public void setIgv(Double igv) {
		this.igv = igv;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Venta(Long id, Date fecha, Long producto, Long cliente, Integer cantidad, Double subtotal, Double igv,
			Double total) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.producto = producto;
		this.cliente = cliente;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
	}


	public Venta() {
		super();
	}


	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", producto=" + producto + ", cliente=" + cliente
				+ ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", igv=" + igv + ", total=" + total + "]";
	}
	
	
	
	
	
	

	
	
}
