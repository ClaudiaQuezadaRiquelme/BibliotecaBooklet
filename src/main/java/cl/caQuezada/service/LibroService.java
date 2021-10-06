package cl.caQuezada.service;

import cl.caQuezada.model.Libro;
import cl.caQuezada.vo.LibroVO;

public interface LibroService {

	LibroVO getAllLibros();
	LibroVO findByTituloAndAutor(String titulo, String autor);
	LibroVO add(Libro libro);
	LibroVO update(Libro libro);
	LibroVO delete(Libro libro);
}
