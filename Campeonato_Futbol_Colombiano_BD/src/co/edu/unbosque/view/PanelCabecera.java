package co.edu.unbosque.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelCabecera extends JPanel {
	public PanelCabecera() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		setBorder(new EmptyBorder(40, 20, 40, 20));
		
		inicializarComponentes();
		
		setVisible(true);
	}
	
	public void inicializarComponentes() {
        ImageIcon iconoOriginal = new ImageIcon("src\\co\\edu\\unbosque\\assets\\ImagenBalon.png");
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        JLabel labelIcono = new JLabel(iconoRedimensionado);	
		add(labelIcono);
		
		JLabel titulo = new JLabel("BD Campeonato Futbol Colombiano");
		Font font = new Font("Arial", Font.BOLD, 36);
		titulo.setFont(font);
		add(titulo);		
	}
}
