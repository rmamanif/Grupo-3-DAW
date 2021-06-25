package aplicaciones.spring.controlador;
import java.util.List;

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
import aplicaciones.spring.modelo.Producto;
import aplicaciones.spring.servicios.ProductoService;
import aplicaciones.spring.servicios.ProveedorService;
@Controller
@RequestMapping("/productos")
@SessionAttributes("producto")
public class ProductoController {
	@Autowired
	@Qualifier("producto")
	ProductoService productoService;
	
	@Autowired
	@Qualifier("proveedor")
	ProveedorService proveedorService;
	
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Producto> productos = productoService.listar();
		model.addAttribute("productos",productos);
		model.addAttribute("titulo","Lista de Productos");
		return "productoListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto",producto);
		model.addAttribute("proveedores", proveedorService.listar());
		model.addAttribute("btn", "Crear Producto");
		return "productoForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("producto",productoService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "productoForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Producto producto,BindingResult result,Model model) {
		
		if(producto.getIdpvd() == null ) {
			model.addAttribute("ERROR","Por favor añada un proveedor para el producto.");
			producto = new Producto();
			model.addAttribute("producto",producto);
			model.addAttribute("btn","Crear Producto");
			return "productoForm";
		}
		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			producto = new Producto();
			model.addAttribute("producto",producto);
			model.addAttribute("btn","Crear Producto");
			return "productoForm";
		}else {
		productoService.guardar(producto);
		return "redirect:/productos/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		productoService.eliminar(id);
		return "redirect:/productos/listar";
	}
}
