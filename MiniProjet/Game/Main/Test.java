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
		//Jeu TableDeJeu = new Jeu();
		Personnage Perso1 = new Personnage(1,1);
		Personnage Perso2 = new Personnage(2,1);
		Perso1.SetStatistiques(4, "J1");
		Perso2.SetStatistiques(4, "J2");
		Perso1.MajPosition(0, 0);
		Perso2.MajPosition(0, 1);
		int total1=0;
		int total2=0;
		for(int i=0; i<100; i++) {
			//Arc
			//int degats = play.ArcDegatsChange(play.degats(Perso1.getAgilite(),Perso2.getAgilite(),Perso1,Perso2),Perso1,Perso2);
			//int degats2 = play.ArcDegatsChange(play.degats(Perso2.getAgilite(),Perso1.getAgilite(),Perso2,Perso1),Perso2,Perso1);
			//Melee
			//int degats = play.degats(Perso1.getForce(),Perso2.getForce(),Perso1,Perso2);
			//int degats2 = play.degats(Perso2.getForce(),Perso1.getForce(),Perso2,Perso1);
			//Magie
			int degats = play.degats(Perso1.getSagesse(),Perso2.getSagesse(),Perso1,Perso2);
			int degats2 = play.degats(Perso2.getSagesse(),Perso1.getSagesse(),Perso2,Perso1);
			System.out.print(Perso1.getchance()+"\t");
			System.out.println(degats);
			System.out.print("\n");
			System.out.print(Perso2.getchance()+"\t");
			System.out.println(degats2);
			System.out.print("----------------\n");
			total1 = total1 + degats;
			total2 = total2 + degats2;
		}
		System.out.println(total1);
		System.out.println(total2);
	}
}
