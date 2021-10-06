package cl.caQuezada.dao;

import java.util.List;

import cl.caQuezada.model.Libro;

public interface LIbroDAO {

	public List<Libro> getAllLibros();
	public Libro findByTituloAndAutor(String titulo, String autor);
	public int add(Libro libro);
	public int delete(Libro libro);
	public int update(Libro libro);
}
