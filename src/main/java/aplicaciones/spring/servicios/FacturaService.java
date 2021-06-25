package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Factura;
import aplicaciones.spring.repositorios.IFactura;

@Service("factura")
public class FacturaService {
	
	@Autowired
	private IFactura iFactura;
	
	public void guardar(Factura factura) {
		iFactura.save(factura);
	}	
	public List<Factura> listar (){
		 return iFactura.findAll();
	}	
	
	public  Factura buscar(Long id) {
		return  iFactura.findById(id);
	}	
	
	public boolean eliminar (Long id) {
		try {
			iFactura.delete(iFactura.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	
}
