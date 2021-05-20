package Run;
//import java.util.Scanner;
import Champion.Personnage;
import World.Jeu;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class RunGame {
	public RunGame() {	
	
	}
	
	
	public static void Partie1v1() {
	    //music INTRO
		AePlayWave Intro = new AePlayWave("C:\\Users\\antoi\\git\\SuperjeuKitue\\MiniProjet\\Audio\\Title_Screen01.wav");
		Intro.start();
		System.out.println("Bonjour à toi jeune aventurier. Par manque d'argent, par recherche de succès ou par goût du combat, tu entres aujourd'hui dans l'arène.");
		pause(3000);
		System.out.println("En plein coeur de la capitale, l'arène du Lion est un diamant planté au beau milieu de la Cité brillant de mille feux.");
		pause(3000);
		System.out.println("Les arcades de ce somptueux bâtiment ont vu passer les meilleurs musiciens, acteurs, mais aussi des animaux, des spectacles de cirque, des jeux sportifs.");
		pause(3000);
		System.out.println("Mais, l'attraction phare du stade demeure les combats de gladiateurs. La crème de la cité se bouscule pour observer les combats.");
		pause(3000);
		System.out.println("Pour les gladiateurs, c'est une opportunité de gagner beaucoup d'argent, de devenir célèbre, ou d'améliorer ses aptitudes au combat.");
		pause(3000);
		System.out.println("Que tu sois mage, guerrier, assassin, archer, tous les coups sont permis. L'issue ne peut être que la victoire ou la mort.");
		pause(3000);
		System.out.println("Vous entrez donc d'un pas sûr sur le terrain, confiant en vos aptitudes guerrières.");	
		pause(3000);
		for(int i=0;i<50;i++) {System.out.println();}	
		
		Jeu TableDeJeu = new Jeu();
		
		
		int compteur=0;
		System.out.println("EQUIPE 1\n");
		System.out.println("Joueur 1 à toi\n");
		compteur++;
		Personnage Perso1 = new Personnage(1,1);
		Perso1.getInit();
		Initialisation.InitPerso(Perso1);
		do {
			Perso1.getInit().Spawn(0,0,Perso1,TableDeJeu);
		}while(TableDeJeu.getPlateau()[Perso1.getPosition()[0]][Perso1.getPosition()[1]]!=0);
		TableDeJeu.PosePion(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso1);//pose le joueur sur un pt du tableau
		

		//init perso2
		System.out.println("Joueur 2 à toi\n");
		compteur++;
		Personnage Perso2 = new Personnage(2,1);
		Perso2.getInit();
		Initialisation.InitPerso(Perso2);
		do {
			Perso2.getInit().Spawn(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso2,TableDeJeu);	
		}while(TableDeJeu.getPlateau()[Perso2.getPosition()[0]][Perso2.getPosition()[1]]==-3);
		TableDeJeu.PosePion(Perso2.getPosition()[0],Perso2.getPosition()[1],Perso2);//pose le joueur sur un pt du tableau
		Intro.stop();
		System.out.println(Perso1.getNom() +"   VS   "+ Perso2.getNom());
		//partie
		DeroulementJeu.DeroulementPartie(Perso1,Perso2,TableDeJeu);
		DeroulementJeu.Gagnant(compteur,Perso1,Perso2);
		
		//music début
		Timer timer = new Timer(true);
		TimerTask PlayCbt1 = new IntroCombat();
		TimerTask PlayCbt2 = new PlayCombat();
		timer.schedule(PlayCbt1, 0);
		timer.scheduleAtFixedRate(PlayCbt2, 0, 87000 );

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void Partie2v2() {
		Jeu TableDeJeu = new Jeu();
		
		int compteur=0;
		System.out.println("EQUIPE 1\n");
		System.out.println("Joueur 1 à toi\n");
		compteur++;
		Personnage Perso1 = new Personnage(1,1);
		Perso1.getInit();
		Initialisation.InitPerso(Perso1);
		do {
			Perso1.getInit().Spawn(0,0,Perso1,TableDeJeu);
		}while(TableDeJeu.getPlateau()[Perso1.getPosition()[0]][Perso1.getPosition()[1]]!=0);
		TableDeJeu.PosePion(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso1);//pose le joueur sur un pt du tableau
		

		//init perso2
		System.out.println("Joueur 2 à toi\n");
		compteur++;
		Personnage Perso2 = new Personnage(2,1);
		Perso2.getInit();
		Initialisation.InitPerso(Perso2);
		do {
			Perso2.getInit().Spawn(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso2,TableDeJeu);	
		}while(TableDeJeu.getPlateau()[Perso2.getPosition()[0]][Perso2.getPosition()[1]]==-3);
		TableDeJeu.PosePion(Perso2.getPosition()[0],Perso2.getPosition()[1],Perso2);//pose le joueur sur un pt du tableau

		
		System.out.println("EQUIPE 2\n");
		//init perso3
		System.out.println("Joueur 3 à toi\n");
		compteur++;
		Personnage Perso3 = new Personnage(1,2);
		Perso2.getInit();
		Initialisation.InitPerso(Perso2);
		do {
			Perso2.getInit().Spawn(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso2,TableDeJeu);	
		}while(TableDeJeu.getPlateau()[Perso2.getPosition()[0]][Perso2.getPosition()[1]]==-3);
		TableDeJeu.PosePion(Perso2.getPosition()[0],Perso2.getPosition()[1],Perso2);//pose le joueur sur un pt du tableau		
		
		
		//init perso4
		System.out.println("Joueur 4 à toi\n");
		compteur++;
		Personnage Perso4 = new Personnage(2,2);
		Perso2.getInit();
		Initialisation.InitPerso(Perso2);
		do {
			Perso2.getInit().Spawn(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso2,TableDeJeu);	
		}while(TableDeJeu.getPlateau()[Perso2.getPosition()[0]][Perso2.getPosition()[1]]==-3);
		TableDeJeu.PosePion(Perso2.getPosition()[0],Perso2.getPosition()[1],Perso2);//pose le joueur sur un pt du tableau		
		
		
		System.out.println(Perso1.getNom() +"   VS   "+ Perso2.getNom());
		//music début
		Timer timer = new Timer(true);
		TimerTask PlayCbt1 = new IntroCombat();
		TimerTask PlayCbt2 = new PlayCombat();
		timer.schedule(PlayCbt1, 0);
		timer.scheduleAtFixedRate(PlayCbt2, 0, 87000 );
		//partie
		DeroulementJeu.DeroulementPartie(Perso1,Perso2,TableDeJeu);
		DeroulementJeu.Gagnant(compteur,Perso1,Perso2);
	}		
	
	
	public static void pause(long lag) {
	    	try {
				Thread.sleep(lag);
			} catch (InterruptedException e) {
			
			}
	 }
}
