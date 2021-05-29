package Affichage;

public class Display extends Thread {
	
	int[][][] monde;
	int res;
	int a;
	
	public Display(int[][][] monde, int a) {
		this.monde=monde;
		this.res= 100;
		this.a=a;
	}
	
	public void run() {
		Affichage.afficherMonde(monde, res, a, "clairiere");
		
	}

}

