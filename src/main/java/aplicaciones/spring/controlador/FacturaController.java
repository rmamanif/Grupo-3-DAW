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

import aplicaciones.spring.modelo.Factura;
import aplicaciones.spring.servicios.FacturaService;

@Controller
@RequestMapping("/facturas")
@SessionAttributes("factura")
public class FacturaController {

	@Autowired
	@Qualifier("factura")
	FacturaService facturaService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Factura> facturas = facturaService.listar();
		model.addAttribute("facturas",facturas);
		model.addAttribute("titulo","Lista de Facturas");
		return "facturaListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Factura factura = new Factura();
		model.put("factura",factura);
		model.put("btn", "Crear Factura");
		return "facturaForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("factura",facturaService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "facturaForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Factura factura,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			factura = new Factura();
			model.addAttribute("factura",factura);
			model.addAttribute("btn","Crear Factura");
			return "facturaForm";
		}else {
		facturaService.guardar(factura);
		return "redirect:/facturas/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		facturaService.eliminar(id);
		return "redirect:/facturas/listar";
	}
	
}
