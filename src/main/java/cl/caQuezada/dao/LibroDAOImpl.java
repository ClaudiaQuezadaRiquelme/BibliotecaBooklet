package cl.caQuezada.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import cl.caQuezada.model.Libro;
import cl.caQuezada.model.LibroMapper;

public class LibroDAOImpl implements LIbroDAO {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	@Autowired
	public LibroDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Libro> getAllLibros() {
		return jdbcTemplate.query("SELECT * FROM LIBROS", new LibroMapper());
	}

	@Override
	public Libro findByTituloAndAutor(String titulo, String autor) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM LIBROS WHERE TITULO=? AND AUTOR=?",
				new LibroMapper(),
				new Object[] { titulo, autor });
	}

	@Override
	public int add(Libro libro) {
		return jdbcTemplate.update(
				"INSERT INTO LIBROS VALUES (NULL, ?,?,?,?,?",
				libro.getTitulo(),
				libro.getAnio(), libro.getAutor(), libro.getImprenta(), libro.getDisponible());
	}

	@Override
	public int delete(Libro libro) {
		return jdbcTemplate.update("DELETE FROM LIBROS WHERE ID_LIBRO=?", libro.getId_libro());
	}

	@Override
	public int update(Libro libro) {
		return jdbcTemplate.update(
				"UPDATE LIBROS SET TITULO=?, ANIO=?, AUTOR=?, IMPRENTA=?, DISPONIBLE=? WHERE ID_LIBRO=?",
				libro.getTitulo(),
				libro.getAnio(), libro.getAutor(), libro.getImprenta(), libro.getDisponible(), libro.getId_libro());
	}


}
