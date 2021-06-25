package aplicaciones.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aplicaciones.spring.modelo.DetFactura;

import aplicaciones.spring.servicios.DetFacturaService;
import aplicaciones.spring.servicios.FacturaService;
import aplicaciones.spring.servicios.ProductoService;

@Controller
@RequestMapping("/detfacturas")
@SessionAttributes("detfactura")
public class DetFacturaController {
	@Autowired
	@Qualifier("detfactura")
	DetFacturaService detfacturaService;

	@Autowired
	@Qualifier("factura")
	FacturaService facturaService;

	@Autowired
	@Qualifier("producto")
	ProductoService productoService;

	@RequestMapping("/listar")
	public String listar(Model model) {
		List<DetFactura> detfacturas = detfacturaService.listar();
		model.addAttribute("detfacturas", detfacturas);
		model.addAttribute("titulo", "Lista de detalles de las facturas");
		return "detfacturaListar";
	}

	@RequestMapping("/form")
	public String formulario(Model model) {
		DetFactura detfactura = new DetFactura();
		if (facturaService.listar().isEmpty()) {
			return "redirect:/facturas/form";
		} else if (productoService.listar().isEmpty()) {
			return "redirect:/productos/form";
		} else {

			model.addAttribute("detfactura", detfactura);
			model.addAttribute("productos", productoService.listar());
			model.addAttribute("facturas", facturaService.listar());
			model.addAttribute("btn", "Crear venta del producto");
			return "detfacturaForm";

		}
	}

	@RequestMapping("/form/{id}")
	public String actualizar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("detfactura", detfacturaService.buscar(id));
		model.addAttribute("btn", "Actualiza Registro");
		return "detfacturaForm";
	}

	@RequestMapping(value = "/insertar", method = RequestMethod.POST)
	public String guardar(@Validated DetFactura detfactura, Model model) {
		try {
			Long idfa = detfactura.getIdf();
			Long idp = detfactura.getProducto();
			var prod = productoService.buscar(idp);
			var fact = facturaService.buscar(idfa);
			if (detfactura.getCantidad() <= prod.getStock()) {
				int redu = prod.getStock() - detfactura.getCantidad();
				prod.setStock(redu);
				double preproducto = detfactura.getCantidad() * prod.getPrecio();
				detfactura.setPrecio(preproducto);
				double factsub = fact.getStotal() + preproducto;
				double factigv = factsub * 0.18;
				double facttotal = factigv + factsub;
				fact.setIgv(factigv);
				fact.setStotal(factsub);
				fact.setTotal(facttotal);
			} else {
				model.addAttribute("ERROR",
						"Stock insuficiente, stock de " + prod.getNombre() + ": " + prod.getStock());
				var detfactura2 = new DetFactura();
				model.addAttribute("detfactura", detfactura2);
				model.addAttribute("productos", productoService.listar());
				model.addAttribute("facturas", facturaService.listar());
				model.addAttribute("btn", "Crear venta del producto");
				return "detfacturaForm";
			}

			detfacturaService.guardar(detfactura);
		} catch (Exception e) {
		}
		return "redirect:/detfacturas/listar";
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		detfacturaService.eliminar(id);
		return "redirect:/detfacturas/listar";
	}

}
