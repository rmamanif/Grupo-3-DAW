package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.modelo.Proveedor;

@Repository
public interface IProveedor extends JpaRepository<Proveedor, Serializable>  {
	public abstract Proveedor findById(Long id);

}
