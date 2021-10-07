package cl.caQuezada.model;

import org.springframework.stereotype.Component;

@Component("libro")
public class Libro {

	private Integer id_libro;
	private String titulo;
	private Integer anio;
	private String autor;
	private String imprenta;
	private Integer disponible; // 0 es no disponible, 1 es disponible
	
	
	
	public Libro() {}
	
	public Libro(int id_libro, String titulo, int anio, String autor, String imprenta, int disponible) {
		super();
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.anio = anio;
		this.autor = autor;
		this.imprenta = imprenta;
		this.disponible = disponible;
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getImprenta() {
		return imprenta;
	}
	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}
	public int getDisponible() {
		return disponible;
	}
	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}
	
}
