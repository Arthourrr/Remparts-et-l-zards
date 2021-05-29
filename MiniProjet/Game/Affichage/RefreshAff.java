package Affichage;

import java.util.TimerTask;

public class RefreshAff extends TimerTask{
	int[][][]monde;
	int det;
	int comp;
	String modeJeu;
	String[] Text= {"","","","","","","","","","",""};
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
		Affichage.afficherMonde(monde, 100, det, modeJeu, comp, 2, Text);
		//Display display = new Display(monde, det);
		//display.start();
		
	}
	public void run(String text) {
		comp++;
		Text[comp]=text;
		Affichage.afficherMonde(monde, 100, det, modeJeu, comp, 2, Text);
	}
	public void run(int stop) {
		comp=0;
		for(int i=0; i< Text.length; i++)
				Text[i]="";
		
	}
}
