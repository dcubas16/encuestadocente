package org.encuestadocente.controllers;

import java.util.List;

import org.encuestadocente.dao.EncuestaDAO;
import org.encuestadocente.dao.GeneralDAO;
import org.encuestadocente.entities.CabeceraEncuesta;
import org.encuestadocente.entities.CarreraProfesional;
import org.encuestadocente.entities.Curso;
import org.encuestadocente.entities.DetallePreguntaAlumnoGrupo;
import org.encuestadocente.entities.Encuesta;
import org.encuestadocente.entities.Estadistico;
import org.encuestadocente.entities.Facultad;
import org.encuestadocente.entities.Grupo;
import org.encuestadocente.entities.RespuestaTransaccion;
import org.encuestadocente.entities.Usuario;
import org.encuestadocente.services.EncuestaService;
import org.encuestadocente.services.GeneralService;
import org.encuestadocente.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

//	@Autowired
//	private AlumnoService alumnoService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private EncuestaService encuestaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private GeneralDAO generalDAO;
	
	@Autowired
	private EncuestaDAO encuestaDAO;

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "poll.htm", method = RequestMethod.GET)
	public String poll(Model model, @RequestParam("idAlumno") String idAlumno) {

		Encuesta encuesta = encuestaService.obtenerEncuestaActiva();
		
		model.addAttribute("idAlumno", idAlumno);
		model.addAttribute("idEncuesta", encuesta.getId());

		return "poll";
	}
	
	@RequestMapping(value = "statistics.htm", method = RequestMethod.GET)
	public String statistics(Model model, @RequestParam("idAdministrativo") int idAdministrativo) {

		Encuesta encuesta = encuestaService.obtenerEncuestaActiva();
		
		model.addAttribute("idAdministrativo", idAdministrativo);
		model.addAttribute("idEncuesta", encuesta.getId());

		return "statistics";
	}

	@RequestMapping(value = "/api/obtenerCabeceraEncuesta/{idAlumno}", method = RequestMethod.GET)
	public @ResponseBody CabeceraEncuesta obtenerCabeceraEncuesta(@PathVariable String idAlumno) {

		CabeceraEncuesta cabeceraEncuesta = encuestaService.obtenerCabeceraEncuesta(idAlumno);

		return cabeceraEncuesta;
	}

	@RequestMapping(value = "/api/obtenerCursosPorAlumno/{idAlumno}", method = RequestMethod.GET)
	public @ResponseBody List<Curso> obtenerCursosPorAlumno(@PathVariable String idAlumno) {

		List<Curso> listaCursos = generalService.obtenerCursosPorAlumno(idAlumno);

		return listaCursos;
	}

	@RequestMapping(value = "/api/obtenerEncuesta/{idEncuesta}", method = RequestMethod.GET)
	public @ResponseBody Encuesta obtenerEncuesta(@PathVariable int idEncuesta) {

		Encuesta encuesta = generalService.obtenerEncuesta(idEncuesta);

		return encuesta;
	}

	@RequestMapping(value = "/api/guardarEncuesta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RespuestaTransaccion guardarEncuesta(@RequestBody DetallePreguntaAlumnoGrupo[] listaDetalle) {

		RespuestaTransaccion esEncuestaGuardada = encuestaService.guardarEncuesta(listaDetalle);

		return esEncuestaGuardada;
	}

	@RequestMapping(value = "/api/obtenerEncuestaAlumnoGrupo/{idAlumnoGrupo}/{idEncuesta}", method = RequestMethod.GET)
	public @ResponseBody List<DetallePreguntaAlumnoGrupo> obtenerEncuestaAlumnoGrupo(@PathVariable int idAlumnoGrupo, @PathVariable int idEncuesta) {

		List<DetallePreguntaAlumnoGrupo> listaDetalle = encuestaService.obtenerDetallesEncuestaAlumnoGrupo(idAlumnoGrupo, idEncuesta);
		
		return listaDetalle;
	}
	
	@RequestMapping(value = "/api/obtenerUsuario/{email}/{password}", method = RequestMethod.GET)
	public @ResponseBody Usuario obtenerUsuario(@PathVariable String email, @PathVariable String password) {

		Usuario usuario = usuarioService.obtenerUsuario(email, password);
		
		return  usuario;
	}
	
	@RequestMapping(value = "/api/obtenerFacultades", method = RequestMethod.GET)
	public @ResponseBody List<Facultad> obtenerFacultades() {

		List<Facultad> facultades = generalDAO.obtenerFacultades();
		
		return facultades;
	}
	
	@RequestMapping(value = "/api/obtenerCarrerasProfesionales/{idFacultad}", method = RequestMethod.GET)
	public @ResponseBody List<CarreraProfesional> obtenerCarrerasProfesionales(@PathVariable int idFacultad) {

		List<CarreraProfesional> carrerasProfesionales = generalDAO.obtenerCarrerasProfesionalesPorFacultad(idFacultad);
		
		return carrerasProfesionales;
	}
	
	@RequestMapping(value = "/api/obtenerCursos/{idCarreraProfesional}", method = RequestMethod.GET)
	public @ResponseBody List<Curso> obtenerCursos(@PathVariable int idCarreraProfesional) {

		List<Curso> cursos = generalDAO.obtenerCursosPorCarreraProfesional(idCarreraProfesional);
		
		return cursos;
	}
	
	@RequestMapping(value = "/api/obtenerGruposPorCurso/{idCurso}", method = RequestMethod.GET)
	public @ResponseBody List<Grupo> obtenerGruposPorCurso(@PathVariable int idCurso) {

		List<Grupo> grupos = generalDAO.obtenerGruposPorCurso(idCurso);
		
		return grupos;
	}	
	
	@RequestMapping(value = "/api/obtenerEstadisticas/{idGrupo}/{idEncuesta}", method = RequestMethod.GET)
	public @ResponseBody List<Estadistico> obtenerEstadisticas(@PathVariable int idGrupo, @PathVariable int idEncuesta) {

		List<Estadistico> estadisticos = encuestaDAO.obtenerEstadisticas(idGrupo, idEncuesta);
		
		return estadisticos;
	}	

}