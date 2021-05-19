package Run;
//import java.util.Scanner;
import Champion.Personnage;
import World.Jeu;
import java.util.Timer;
import java.util.TimerTask;
public class RunGame {
	public RunGame() {	
	
	}
	
	
	public static void Partie1v1() {
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
