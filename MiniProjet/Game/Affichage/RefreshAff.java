package Affichage;

import java.util.TimerTask;

public class RefreshAff extends TimerTask{
	int[][][]monde;
	int det;
	int comp;
	String modeJeu;
	String[] Text= {"","","","","","","","","","","","","","","","","","","","","","",""};
	//int modejeu;
	public RefreshAff(int[][][]a) {
		this.monde=a;
		
	}
	
	@Override
	public void run() {
		if(monde[0][0][3] == 1) {
			this.modeJeu= "clairiere";
		}else if(monde[0][0][3] == 2) {
			this.modeJeu = "volcan";
		}
		if(det==1) {
			det=2;
		}else if (!(det==1)) {
			det=1;
		}
		//System.out.println(modeJeu);
		Affichage.afficherMonde(monde, 100, det, modeJeu, comp, 2, Text);
	}
	public void run(String text) {
		comp++;
		Text[comp]=text;
		//Affichage.afficherMonde(monde, 100, det, modeJeu, comp, 2, Text);
	}
	public void run(int stop) {
		comp=0;
		for(int i=0; i< Text.length; i++)
				Text[i]="";
		
	}
}
