package co.edu.unbosque.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.unbosque.model.Campeonato;
import co.edu.unbosque.view.PanelFilaTabla;
import co.edu.unbosque.view.VistaVentana;

public class Controller implements ActionListener {
	private VistaVentana vista;
	private Campeonato campeonato;

	public Controller() {
		vista = new VistaVentana();
		campeonato = new Campeonato();

		run();
	}

	public void run() {
		vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos()
				.insertarNuevaTabla(campeonato.getEquipos());

		asignarListeners();
	}

	public void asignarListeners() {
		// Agregar Listener a Pantalla lista de equipos
		asignarListenersPantallaListaEquipos();

		// Agregar listeners a pantalla crear nuevo equipo
	}

	public void asignarListenersPantallaListaEquipos() {
		vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos().getBotonCrearEquipo()
				.addActionListener(this);
		vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos().getBotonConsultar()
				.addActionListener(this);
		asignarListenersBotonesEliminar();
	}

	public void asignarListenersBotonesEliminar() {
		// Agregar Listeners para eliminar equipos
		Component[] equipos = vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos().getTabla()
				.getContenedorInfo().getComponents();

		for (Component c : equipos) {
			JPanel panelInterno = (JPanel) c;
			Component subComponente = panelInterno.getComponent(0);
			if (subComponente != null) {
				if (subComponente instanceof PanelFilaTabla) {
					((PanelFilaTabla) subComponente).getBotonEliminar().addActionListener(this);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String aux = e.getActionCommand();

		validateAction(aux);
	}

	public void validateAction(String aux) {
		if (aux.contains("CREAR")) {

			JTextField field1 = new JTextField(), field2 = new JTextField();
			Object[] fields = { "Nombre", field1, "Estrellas", field2 };

			addTeam: while (true) {
				int opt = JOptionPane.showConfirmDialog(null, fields, "Ingrese el nuevo equipo",
						JOptionPane.OK_CANCEL_OPTION);
				if (opt == JOptionPane.OK_OPTION) {

					boolean respuesta = campeonato.agregarEquipo(field1.getText(), field2.getText());
					if (respuesta) {
						JOptionPane.showMessageDialog(null, "El equipo ha sido añadido exitosamente!", "YAAAAAAY",
								JOptionPane.INFORMATION_MESSAGE);
						campeonato = new Campeonato();
						vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos()
								.insertarNuevaTabla(campeonato.getEquipos());
						asignarListenersBotonesEliminar();
						int n = JOptionPane.showConfirmDialog(null, "¿Desea Seguir agregando equipos?", "",
								JOptionPane.YES_NO_OPTION);
						if (n != JOptionPane.YES_OPTION) {
							break addTeam;
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"¡El equipo no se pudo agregar!\nPor favor ingrese correctamente los datos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (opt == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Accion cancelada", "", JOptionPane.INFORMATION_MESSAGE);
					break addTeam;
				}
			}
		}

		if (aux.contains("Eliminar")) {
			String equipo = aux.split("=")[1];
			boolean respuesta = campeonato.eliminarEquipo(equipo);

			if (respuesta) {
				// Mostrar dialog de exito
				JOptionPane.showMessageDialog(null, "¡Equipo eliminado con éxito!", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
				campeonato = new Campeonato();
				vista.getContenedorPrincipal().getContenedorPantallas().getListaEquipos()
						.insertarNuevaTabla(campeonato.getEquipos());
				asignarListenersBotonesEliminar();
			} else {
				// Mostrar dialog de rechazo
				JOptionPane.showMessageDialog(null, "¡El equipo no se pudo eliminar!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (aux.contains("CONSULTAR")) {

			JTextField field1 = new JTextField();

			consultTeam: while (true) {
				int opt = JOptionPane.showConfirmDialog(null, field1, "Ingrese el nombre del equipo",
						JOptionPane.OK_CANCEL_OPTION);
				if (opt == JOptionPane.OK_OPTION) {
					String respuesta = campeonato.consultarEquipo(field1.getText());
					JOptionPane.showMessageDialog(null, respuesta);
					int n = JOptionPane.showConfirmDialog(null, "¿Desea Seguir consultando equipos?", "",
							JOptionPane.YES_NO_OPTION);
					if (n != JOptionPane.YES_OPTION) {
						break consultTeam;
					}
				} else if (opt == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Accion cancelada", "", JOptionPane.INFORMATION_MESSAGE);
					break consultTeam;
				}
			}
		}

	}
}
