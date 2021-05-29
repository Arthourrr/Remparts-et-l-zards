package Affichage;

public class DisplayTxt extends Thread {
	int comp;
	String[] Text;
	public void run(String text) {
		comp++;
		Text[comp]= text;
		Affichage.afficherMonde(100, comp, 2, Text);
	}
	public void run() {
		Affichage.afficherMonde(100, comp, 0, new String[15]);
	}
}
