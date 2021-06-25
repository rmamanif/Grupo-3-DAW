package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.modelo.Factura;

@Repository
public interface IFactura extends JpaRepository<Factura, Serializable> {
	public abstract Factura findById(Long id);

}
