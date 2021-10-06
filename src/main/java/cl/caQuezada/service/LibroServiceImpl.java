package cl.caQuezada.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.caQuezada.dao.LIbroDAO;
import cl.caQuezada.model.Libro;
import cl.caQuezada.vo.LibroVO;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LIbroDAO dao;
	
	private LibroVO respuesta;

	@Override
	public LibroVO getAllLibros() {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "101");
		try {
			respuesta.setLibros(new ArrayList<>(dao.getAllLibros()));
			respuesta.setMensaje(String.format("Se ha/n encontrado %d libro/s", respuesta.getLibros().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO findByTituloAndAutor(String titulo, String autor) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "102");
		try {
			Libro libro = dao.findByTituloAndAutor(titulo, autor);
			respuesta.getLibros().add(libro);
			respuesta.setMensaje(String.format("Se ha/n encontrado %d libro/s", null != libro ? 1 : 0 ));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO add(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "103");
		try {
			int registrosActualizados = dao.add(libro);
			respuesta.setMensaje(registrosActualizados == 1 ? "Se ha creado el libro correctamente" 
					: "No se ha podido crear el libro");
			respuesta.setCodigo(registrosActualizados == 1 ? "0" : "103");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO update(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "104");
		try {
			int registrosActualizados = dao.update(libro);
			respuesta.setMensaje(String.format("Se ha/n actualizado correctamente %d libro/s", registrosActualizados));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO delete(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105");
		try {
			int registrosActualizados = dao.delete(libro);
			respuesta.setMensaje(String.format("Se ha/n eliminado correctamente %d libro/s", registrosActualizados));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}
}
