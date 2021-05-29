package Run;
//import java.util.Scanner;
import Champion.Personnage;
import World.Jeu;
import java.util.Timer;
import java.util.TimerTask;

import Affichage.RefreshAff;
public class RunGame {
	public RunGame() {	
	
	}
	
	
	public static void Partie1v1() {
	    //music INTRO
		
		int[][][]carte = new int[5][5][4];// {{0,0,0,0,0},{0,-3,0,0,0},{0,-3,0,-3,0},{0,0,0,0,0},{0,0,0,0,0}};
		Timer loop= new Timer();
		TimerTask Refresh = new RefreshAff(carte, 1);
		loop.scheduleAtFixedRate(Refresh, 0, 300 );
		
		AePlayWave Intro = new AePlayWave(System.getProperty("user.dir") + "\\Audio\\Title_Screen01.wav");
		Intro.start();
		Update skip = new Update();
		skip.setDaemon(true);
		skip.start();
		Display(  Refresh,"(Passer l'intro: 0 )");
		pause(1000);
		Display(  Refresh,"Bonjour à toi jeune aventurier. En quête de richesses, par recherche de succès ou par goût du combat, tu entres aujourd'hui dans l'arène.");
		pause(skip.val);
		Display(  Refresh,"En plein coeur de la capitale, l'arène du Lion est un diamant planté au beau milieu de la Cité brillant de mille feux."); //Mouais pas fan de la formule mdr
		pause(skip.val);
		Display(  Refresh,"Les arcades de ce somptueux bâtiment ont vu passer les plus grands musiciens, acteurs, mais aussi des animaux exotiques, des spectacles de cirque, des jeux sportifs.");
		pause(skip.val);
		Display(  Refresh,"Mais, l'attraction phare du stade demeure les combats de gladiateurs. Du simple mendiant au plus riche marchand, tous se pressent pour observer les combats.");
		pause(skip.val);
		Display(  Refresh,"Pour les gladiateurs, c'est l'opportunité de se faire une réputation et gagner mille trésors, de s'attirer les faveurs des plus belles courtisanes du royaume, \nou encore d'améliorer ses aptitudes au combat.");
		pause(skip.val);
		Display(  Refresh,"Que tu sois mage, guerrier, assassin, archer, tous les coups sont permis. L'issue ne peut être que la victoire... ou la mort.");
		pause(skip.val);
		Display(  Refresh,"Vous entrez donc d'un pas sûr sur le terrain, confiant en vos aptitudes guerrières.");	
		pause(1500);
		skip.stop();
		System.out.println();
		Jeu TableDeJeu = new Jeu();
		
		
		int compteur=0;
		System.out.println("EQUIPE 1\n");
		System.out.println("Joueur 1 à toi\n");
		compteur++;
		Personnage Perso1 = new Personnage(1);
		Perso1.getInit();
		Initialisation.InitPerso(Perso1);
		do {
			Perso1.getInit().Spawn(0,0,Perso1,TableDeJeu);
		}while(TableDeJeu.getPlateau()[Perso1.getPosition()[0]][Perso1.getPosition()[1]][2]!=0);
		TableDeJeu.PosePion(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso1);//pose le joueur sur un pt du tableau
		

		//init perso2
		System.out.println("Joueur 2 à toi\n");
		compteur++;
		Personnage Perso2 = new Personnage(2);
		Perso2.getInit();
		Initialisation.InitPerso(Perso2);
		do {
			Perso2.getInit().Spawn(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso2,TableDeJeu);	
		}while(TableDeJeu.getPlateau()[Perso2.getPosition()[0]][Perso2.getPosition()[1]][2]!=0);
		TableDeJeu.PosePion(Perso2.getPosition()[0],Perso2.getPosition()[1],Perso2);//pose le joueur sur un pt du tableau
		Intro.stop();
		//music début
				Timer timer = new Timer(true);
				TimerTask PlayCbt1 = new IntroCombat();
				TimerTask PlayCbt2 = new PlayCombat();
				timer.schedule(PlayCbt1, 0);
				timer.scheduleAtFixedRate(PlayCbt2, 0, 87000 );

		System.out.println(Perso1.getNom() +"   VS   "+ Perso2.getNom());
		//partie
		Refresh.cancel();
		DeroulementJeu.DeroulementPartie(Perso1,Perso2,TableDeJeu);
		DeroulementJeu.Gagnant(compteur,Perso1,Perso2);
		
		
	}
	public static void Display( TimerTask refresh, String sentence) {
    	((RefreshAff) refresh).run(sentence);
    }
	
	public static void pause(long lag) {
	    	try {
				Thread.sleep(lag);
			} catch (InterruptedException e) {
			
			}
	 }
}
