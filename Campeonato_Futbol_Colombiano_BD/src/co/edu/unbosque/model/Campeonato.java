package co.edu.unbosque.model;

import java.io.IOException;
import java.util.InputMismatchException;

import co.edu.unbosque.model.persistence.Archivo;

public class Campeonato {

	private int maxEquipos;
	private Equipo[] equipos;
	private Archivo archivo;

	public Campeonato() {
		archivo = new Archivo();
		try {
			archivo.leerConfiguracion();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			maxEquipos = Integer.parseInt(obtenerPropiedad("campeonato.equipos"));
		} catch (NumberFormatException e) {
			archivo.escribirPropiedades("campeonato.equipos", "" + 0);
		}

		equipos = new Equipo[maxEquipos];
		inicializarEquipos();
	}

	public String obtenerPropiedad(String propiedad) {
		return archivo.getDatos().getProperty(propiedad);
	}

	public void modificarPropiedad(String propiedad, String valor) {
		archivo.escribirPropiedades(propiedad, valor);
	}

	public void eliminarPropiedad(String propiedad) {
		archivo.getDatos().remove(propiedad);
	}

	public void inicializarEquipos() {
		for (int i = 0; i < maxEquipos; i++) {
			String nombre = obtenerPropiedad("campeonato.nombre" + i);
			String estrellas = obtenerPropiedad("equipo.estrellaEquipo" + i);
			equipos[i] = new Equipo(nombre, estrellas);
		}
	}

	public String informacionCampeonato() {
		String info = "Cantidad de equipos: " + maxEquipos + "\n";
		for (int i = 0; i < maxEquipos; i++) {
			info += equipos[i] + "\n";
		}
		return info;
	}

	public boolean agregarEquipo(String nombre, String cantEstrellas) {
		try {
			Integer.parseInt(cantEstrellas);
		} catch (NumberFormatException e) {
			return false;
		}
		int pos = buscarEquipo(nombre);
		if (pos == -1) {
			// Se agrega el nombre del equipo a la propiedad
			maxEquipos++;
			modificarPropiedad("campeonato.equipos", "" + maxEquipos);
			equipos = new Equipo[maxEquipos];
			modificarPropiedad("campeonato.nombre" + (maxEquipos - 1), nombre);
			// Agregar las estrellas de los equipos

			modificarPropiedad("equipo.estrellaEquipo" + (maxEquipos - 1), cantEstrellas);
			inicializarEquipos();
			return true;
		} else {
			return false;
		}
	}

	public int buscarEquipo(String nombre) {
		int pos = -1;
		for (int i = 0; i < maxEquipos; i++) {
			if (equipos[i].getNombre().equals(nombre)) {
				pos = i;
			}
		}
		return pos;
	}

	public String consultarEquipo(String nombre) {
		int pos = buscarEquipo(nombre);
		String rta = "";
		try {
			rta = equipos[pos].toString();
		} catch (IndexOutOfBoundsException e) {
			rta = "Equipo no encontrado";
		}
		return rta;
	}

	public boolean eliminarEquipo(String nombre) {
		int pos = buscarEquipo(nombre);

		if (pos != -1) {

			for (int i = pos; i < maxEquipos - 1; i++) {
				equipos[i] = equipos[i + 1];
			}

			maxEquipos--;

			modificarPropiedad("campeonato.equipos", "" + maxEquipos);

			for (int i = pos; i < maxEquipos; i++) {
				modificarPropiedad("campeonato.nombre" + (i), equipos[i].getNombre());
				modificarPropiedad("equipo.estrellaEquipo" + (i), equipos[i].getEstrellas());
				eliminarPropiedad("campeonato.nombre" + (equipos.length - 1));
				eliminarPropiedad("equipo.estrellaEquipo" + (equipos.length - 1));
			}

			inicializarEquipos();
			return true;
		}

		return false;
	}

	public int getMaxEquipos() {
		return maxEquipos;
	}

	public Equipo[] getEquipos() {
		return equipos;
	}

}
