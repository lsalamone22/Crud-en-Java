package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;

@Service // para que esto se guarde en la fabrica de Spring
public class EstudianteServicioImpl implements EstudianteServicio {

	@Autowired
	private EstudianteRepositorio repositorio;

	// estamos implementando todos los metodos abstractos
	@Override
	public List<Estudiante> listarTodosLosEstudiantes() {

		return repositorio.findAll();// para buscar todos
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudiantePorId(Long id) {
		return repositorio.findById(id).get();// vamos a pasarle el id ya que obtendrempoa a un estudiante por su id
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
		// voya buscar une studiante a la hora de actualizarlo y esos datos actualizados
		// los voy a guardar
	}

	@Override
	public void eliminarEstudiante(Long id) {
		repositorio.deleteById(id);

	}

}
