package Main;
import java.util.Scanner;
import Run.AePlayWave;
import Run.DeroulementJeu;
import Run.Initialisation;
import Run.IntroCombat;
import Run.PlayCombat;
import Champion.Personnage;
import World.Jeu;
import java.util.Timer;
import java.util.TimerTask;

public class Launch {
	public static void main (String[] arg){
	    
		AePlayWave Intro = new AePlayWave("C:\\Users\\antoi\\git\\SuperjeuKitue\\MiniProjet\\Audio\\Title_Screen01.wav");
		Intro.start();
	    
		DeroulementJeu FaisTournerLaPartie = new DeroulementJeu();
		Jeu TableDeJeu = new Jeu();
		System.out.println("Joueur 1 à toi");

		int compteur=1;
		
		Personnage Perso1 = new Personnage(1);
		Perso1.getInit();
		Initialisation.InitPerso(Perso1);
		Perso1.getInit().Spawn(0,0,Perso1);
		TableDeJeu.PosePion(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso1);//pose le joueur sur un pt du tableau
		compteur++;
		
		System.out.println("Joueur 2 à toi");
		Personnage Perso2 = new Personnage(2);
		Perso2.getInit();
		Initialisation.InitPerso(Perso2);
		Perso2.getInit().Spawn(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso2);
		TableDeJeu.PosePion(Perso2.getPosition()[0],Perso2.getPosition()[1],Perso2);//pose le joueur sur un pt du tableau	
		
		System.out.println("\\\\\\\\\\\\\\\\\\ "+Perso1.getNom() +" VS "+ Perso2.getNom()+" /////////");
		Intro.stop();	
		Timer timer = new Timer(true);
		TimerTask PlayCbt1 = new IntroCombat();
		TimerTask PlayCbt2 = new PlayCombat();
		timer.schedule(PlayCbt1, 0);
		timer.scheduleAtFixedRate(PlayCbt2, 0, 87000 );
		DeroulementJeu.DeroulementPartie(Perso1,Perso2,TableDeJeu);
		DeroulementJeu.Gagnant(compteur,Perso1,Perso2);
		
		

		
    }	
}	
