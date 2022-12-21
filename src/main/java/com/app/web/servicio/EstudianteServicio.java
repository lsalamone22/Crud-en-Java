package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Estudiante;

public interface EstudianteServicio {
	public List<Estudiante> listarTodosLosEstudiantes();//nuestro primer metodo
	
	public Estudiante guardarEstudiante(Estudiante estudiante);
	
	public Estudiante obtenerEstudiantePorId(Long id);
	
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	public void eliminarEstudiante(Long id);
	//a la hora de yo eliminar le voy a pasar su id
}
