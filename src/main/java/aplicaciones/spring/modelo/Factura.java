package aplicaciones.spring.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="factura")
public class Factura implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura")
	private Long id;
	@Column(name="id_cliente")
	private Long idc;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name="sub_total")
	private Double stotal;
	private Double igv;
	@Column(name="precio_total")
	private Double total;

	public Factura() {
		super();
	}

	

	public Factura(Long id, Long idc, Date fecha, Double stotal, Double igv, Double total) {
		super();
		this.id = id;
		this.idc = idc;
		this.fecha = fecha;
		this.stotal = stotal;
		this.igv = igv;
		this.total = total;
	}



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

	public Long getIdc() {
		return idc;
	}

	public void setIdc(Long idc) {
		this.idc = idc;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getStotal() {
		return stotal;
	}

	public void setStotal(Double stotal) {
		this.stotal = stotal;
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

	@Override
	public String toString() {
		return "Factura [id=" + id + ", idc=" + idc + ", fecha=" + fecha + ", stotal=" + stotal + ", igv=" + igv
				+ ", total=" + total + "]";
	}


	
}
