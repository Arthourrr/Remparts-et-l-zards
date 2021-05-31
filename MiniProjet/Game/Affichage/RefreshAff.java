package Affichage;

import java.util.TimerTask;

import Champion.Personnage;

public class RefreshAff extends TimerTask{
	int[][][]monde;
	int det;
	int comp;
	String modeJeu;
	String[] Text= {"","","","","","","","","","","","","","","","","","","","","","",""};
	Personnage P1;
	Personnage P2;
	//int modejeu;
	public RefreshAff(int[][][]a/*, Personnage p1,Personnage p2*/) {
		this.monde=a;
		//this.P1=p1;
		//this.P2=p2;
		
	}
	
	@Override
	public void run() {
		if(monde[0][0][3] == 1) {
			this.modeJeu= "clairiere";
		}else if(monde[0][0][3] == 2) {
			this.modeJeu = "volcan";
		}else if(monde[0][0][3] == 0) {
			this.modeJeu = "titlescreen";
		}
		if(det==1) {
			det=2;
		}else if (!(det==1)) {
			det=1;
		}
		//System.out.println(modeJeu);
		Affichage.afficherMonde(monde, 100, det, modeJeu, comp, 2, Text);
		/*
		for(int i=0; i< monde.length; i++) {
			for(int j=0; j<monde[0].length; j++) {
				System.out.print(monde[i][j][0]);
			}
			System.out.println("");
		}System.out.println("");
		
		for(int i=0; i< monde.length; i++) {
			for(int j=0; j<monde[2].length; j++) {
				System.out.print(monde[i][j][0]);
			}
			System.out.println("");
		}System.out.println("");
		
		for(int i=0; i< monde.length; i++) {
			for(int j=0; j<monde[1].length; j++) {
				System.out.print(monde[i][j][0]);
			}
			System.out.println("");
		}System.out.println("");
		*/
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
