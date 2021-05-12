package Main;

import Run.Affichage;

public class Test {

	public static void main(String[] args) {
		int[][] monde = {{0, 0, 0, -1, 0},{0,0,-2,0,0},{0,0,0,-1,0},{0,0,10,0,0},{0,0,0,0,0}};
		Affichage.afficherMonde(monde, 100);
	}
}
