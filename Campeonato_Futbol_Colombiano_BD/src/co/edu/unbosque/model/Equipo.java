package co.edu.unbosque.model;

public class Equipo {

	private String nombre;
	private String estrellas;

	public Equipo() {
		nombre = "";
	}

	public Equipo(String nombre, String estrellas) {
		this.nombre = nombre;
		this.estrellas = estrellas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(String estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", estrellas=" + estrellas+"]";
	}

}
