package Affichage;
import java.awt.Graphics;

public class ShowImage extends Thread{
	
	String FileName;
	Graphics g;
	int i;
	int j;
	
	public ShowImage (String FileName, Graphics g, int i, int j) {
		this.FileName=FileName;
		this.g=g;
		this.i=i;
		this.j=j;
	}

	public void run(){
		Affichage.PanneauGrille.AfficheEntite(FileName, g, i, j);
	}
}

