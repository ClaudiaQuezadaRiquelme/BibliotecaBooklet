package cl.caQuezada.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LibroMapper implements RowMapper<Libro> {

	@Override
	public Libro mapRow(ResultSet rs, int i) throws SQLException {
		Libro libro = new Libro();
		libro.setId_libro(rs.getInt("ID_LIBRO"));
		libro.setTitulo(rs.getString("TITULO"));
		libro.setAnio(rs.getInt("ANIO"));
		libro.setAutor(rs.getString("AUTOR"));
		libro.setImprenta(rs.getString("IMPRENTA"));
		libro.setDisponible(rs.getInt("DISPONIBLE"));
		return libro;
	}
}
