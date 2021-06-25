package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.DetFactura;
import aplicaciones.spring.repositorios.IDetFactura;

@Service("detfactura")
public class DetFacturaService {
	
	@Autowired
	private IDetFactura iDetFactura;
	
	public void guardar(DetFactura detfactura) {
		iDetFactura.save(detfactura);
	}	
	public List<DetFactura> listar (){
		 return iDetFactura.findAll();
	}	
	
	public  DetFactura buscar(Long id) {
		return  iDetFactura.findById(id);
	}	
	
	
	public boolean eliminar (Long id) {
		try {
			iDetFactura.delete(iDetFactura.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	
}
