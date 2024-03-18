package co.edu.unbosque.controller;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class AplMain {

	public static void main(String[] args) {
//		for(LookAndFeelInfo lafInfo :  UIManager.getInstalledLookAndFeels()) {
//			System.out.println(lafInfo.getClassName());
//		}
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		Controller controlador = new Controller();	
	}

}
