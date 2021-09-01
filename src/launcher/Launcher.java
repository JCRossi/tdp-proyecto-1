package launcher;

import entities.*;
import gui.*;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student juancruz = new Student(125594, "Rossi", "Juan Cruz", "juanrossi1969@gmail.com", "https://github.com/JCRossi", "/JuanCruzRossi.png");
            	SimplePresentationScreen presentacion = new SimplePresentationScreen(juancruz);
            	presentacion.setVisible(true);
            }
        });
    }
}