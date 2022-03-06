package com.codingdojo.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.modelos.Ninja;
import com.codingdojo.servicios.ServicioDojo;
import com.codingdojo.servicios.ServicioNinja;

@Controller
public class ControladorDojo {
	
	private final ServicioDojo servicioDojo;
	private final ServicioNinja servicioNinja;
	
	public ControladorDojo(ServicioDojo servicio, ServicioNinja servicioninja) {
		this.servicioDojo = servicio;
		this.servicioNinja = servicioninja;
	}
	
	@RequestMapping( value="/dojos", method = RequestMethod.GET)
	public String despliegaInicio(@ModelAttribute("dojo") Dojo nuevoDojo,Model model) {
		List<Dojo> listaDojos = servicioDojo.selectAllFromDojos();
		model.addAttribute("listaDojos", listaDojos);
		return "dojos.jsp";
	}
	@RequestMapping( value="/dojos/nuevo", method = RequestMethod.POST)
	public String registrarDojo(@Valid @ModelAttribute("dojo") Dojo nuevoDojo, BindingResult result) {
		if(result.hasErrors()){
			return ("dojos.jsp");
		}
		else {
			servicioDojo.insertIntoDojos(nuevoDojo);
			return "redirect:/dojos";
		}
	
	}
	
	@RequestMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Dojo dojo = servicioDojo.findDojo(id);
    	List<Ninja> listaNinjas = dojo.getNinjas();
    	model.addAttribute("listaNinjas", listaNinjas);
        return "dojoshow.jsp";
    }
	
	@RequestMapping( value="/ninjas/nuevo", method = RequestMethod.GET)
	public String despliegaRegistro(@ModelAttribute("ninja") Ninja nuevoNinja, @ModelAttribute("dojo") Dojo nuevoDojo ,Model model) {
		List<Dojo> listaDojos = servicioDojo.selectAllFromDojos();
		model.addAttribute("listaDojos", listaDojos);
		return "nuevoninja.jsp";
	}

	@RequestMapping( value="/ninjas/nuevo/registrar", method = RequestMethod.POST)
	public String registrarNinja(@Valid @ModelAttribute("ninja") Ninja nuevoNinja, BindingResult result ) {
		if(result.hasErrors()){
			return ("dojos.jsp");
		}
		else {
			servicioNinja.insertIntoNinjas(nuevoNinja);
			return "redirect:/ninjas/nuevo";
		}
	}
	
}
