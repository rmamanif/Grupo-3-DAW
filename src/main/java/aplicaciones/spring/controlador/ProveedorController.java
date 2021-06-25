package aplicaciones.spring.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aplicaciones.spring.modelo.Proveedor;
import aplicaciones.spring.servicios.ProveedorService;

@Controller
@RequestMapping("/proveedores")
@SessionAttributes("proveedor")
public class ProveedorController {

	@Autowired
	@Qualifier("proveedor")
	ProveedorService proveedorService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Proveedor> proveedores = proveedorService.listar();
		model.addAttribute("proveedores",proveedores);
		model.addAttribute("titulo","Lista de Proveedores");
		return "proveedorListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Proveedor proveedor = new Proveedor();
		model.put("proveedor",proveedor);
		model.put("btn", "Crear Proveedor");
		return "proveedorForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("proveedor",proveedorService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "proveedorForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Proveedor proveedor,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			proveedor = new Proveedor();
			model.addAttribute("proveedor",proveedor);
			model.addAttribute("btn","Crear Proveedor");
			return "proveedorForm";
		}else {
		proveedorService.guardar(proveedor);
		return "redirect:/proveedores/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		proveedorService.eliminar(id);
		return "redirect:/proveedores/listar";
	}
	
}
