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

import aplicaciones.spring.modelo.DetFactura;
import aplicaciones.spring.servicios.DetFacturaService;

@Controller
@RequestMapping("/detfacturas")
@SessionAttributes("detfactura")
public class DetFacturaController {
	@Autowired
	@Qualifier("detfactura")
	DetFacturaService detfacturaService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<DetFactura> detfacturas = detfacturaService.listar();
		model.addAttribute("detfacturas",detfacturas);
		model.addAttribute("titulo","Lista de DetFacturas");
		return "detfacturaListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		DetFactura detfactura = new DetFactura();
		model.put("detfactura",detfactura);
		model.put("btn", "Crear DetFactura");
		return "detfacturaForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("detfactura",detfacturaService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "detfacturaForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated DetFactura detfactura,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			detfactura = new DetFactura();
			model.addAttribute("detfactura",detfactura);
			model.addAttribute("btn","Crear DetFactura");
			return "detfacturaForm";
		}else {
		detfacturaService.guardar(detfactura);
		return "redirect:/detfacturas/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		detfacturaService.eliminar(id);
		return "redirect:/detfacturas/listar";
	}
	
}
