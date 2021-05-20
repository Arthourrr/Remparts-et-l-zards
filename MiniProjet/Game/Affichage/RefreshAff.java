package Affichage;

import java.util.TimerTask;

public class RefreshAff extends TimerTask{
	int[][]monde;
	int det;
	String modeJeu;

	public RefreshAff(int[][]a, String modeJeu) {
		this.monde=a;
		this.modeJeu= modeJeu;
	}
	
	@Override
	public void run() {
		if(det==1) {
			det=2;
		}else if (!(det==1)) {
			det=1;
		}

		//System.out.println("Thread Refresh = "+det);
		Affichage.afficherMonde(monde, 100, det, modeJeu);
		//Display display = new Display(monde, det);
		//display.start();
		
	}

}
