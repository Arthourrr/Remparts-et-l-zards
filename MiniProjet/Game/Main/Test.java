package Main;
//import java.util.Scanner;
import Run.AePlayWave;
import Run.DeroulementJeu;
import Run.Initialisation;
import Run.IntroCombat;
import Run.PlayCombat;
import Champion.Personnage;
import World.Jeu;
import Champion.Actions;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class Test {
	
	public static void main (String[] arg){
		Actions play = new Actions();
		Jeu TableDeJeu = new Jeu();
		Personnage Perso1 = new Personnage(1);
		Personnage Perso2 = new Personnage(2);
		Perso1.SetStatistiques(3, "J1");
		Perso2.SetStatistiques(1, "J2");
		Perso1.MajPosition(0, 0);
		Perso2.MajPosition(0, 1);		
		for(int i=0; i<100; i++) {
		//int degats = play.ArcDegatsChange(play.degats(Perso1.getAgilite(),Perso2.getAgilite(),Perso1,Perso2),Perso1,Perso2);
		int degats = play.degats(Perso1.getForce(),Perso2.getForce(),Perso1,Perso2);
		//int degats = play.degats(Perso1.getSagesse(),Perso2.getSagesse(),Perso1,Perso2);
		System.out.println(degats+"\t"+Perso1.getchance());
		}
	}
}
