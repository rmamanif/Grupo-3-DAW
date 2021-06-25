package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.modelo.DetFactura;

@Repository
public interface IDetFactura extends JpaRepository<DetFactura, Serializable> {
	public abstract DetFactura findById(Long id);
}
