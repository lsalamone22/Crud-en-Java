package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControlador {
	
	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping({"/estudiantes","/"})//en la url loq ue va a aparezer
	private String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes() );
		return "estudiantes";//nos retorna al archivo html estudiantes
	}
	
	@GetMapping("/estudiantes/nuevo")
	public String mostrarEstudianteFormParaRegistrar(Model modelo) {
		Estudiante estudiante = new Estudiante();//aqui le estoy pasasndo un obj estudiante
		modelo.addAttribute("estudiante", estudiante);//para que en este form podamos asignar los atributos de este obj
		return "crear_estudiante";
	}
	
	@PostMapping("/estudiantes/nuevo")//puedo poenrlo como yo quiera
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {//este será el metodo de guardar el estudiante
		servicio.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}
	
	@GetMapping("/estudiantes/editar/{id}")//este será el form para editar
	public String mostrarFormDeEditar(@PathVariable Long id, Model modelo) {//path recibe un id
		modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));//aqui voy a pasar el estudiante que encuntre por id
		return "editar_estudiante";
	}
	
	@PostMapping("/estudiantes/{id}")//este metodo será para actualizar del todo al estduainte
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo) {
		Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);//obtenemos el estu por id
		estudianteExistente.setId(id);
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setApellido(estudiante.getApellido());
		estudianteExistente.setEmail(estudiante.getEmail());
		
		servicio.actualizarEstudiante(estudianteExistente);
		return "redirect:/estudiantes";
		
	}
	
	@GetMapping("/estudiante/eliminar/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}

}
