package Affichage;

import java.util.TimerTask;

public class RefreshAff extends TimerTask{
	int[][][]monde;
	int det;
	String modeJeu;
	//int modejeu;
	public RefreshAff(int[][][]a, int modejeu) {
		this.monde=a;
		//this.modejeu =modejeu;
		if(modejeu == 1) {
			this.modeJeu= "clairiere";
		}else if(modejeu == 2) {
			this.modeJeu = "volcan";
		}
	}
	
	@Override
	public void run() {
		if(det==1) {
			det=2;
		}else if (!(det==1)) {
			det=1;
		}
		//System.out.println(modejeu);
		//System.out.println(modeJeu);
		Affichage.afficherMonde(monde, 100, det, modeJeu);
		//Display display = new Display(monde, det);
		//display.start();
		
	}

}
