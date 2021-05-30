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
		
		int[][][]carte = new int[5][5][4];
		carte[0][0][3]=0;
		Timer loop= new Timer();
		TimerTask Refresh = new RefreshAff(carte);
		loop.scheduleAtFixedRate(Refresh, 0, 300 );
		
		AePlayWave Intro = new AePlayWave(System.getProperty("user.dir") + "\\Audio\\Title_Screen01.wav");
		Intro.start();
		Update skip = new Update();
		skip.setDaemon(true);
		skip.start();
		Display(  Refresh,"(Passer l'intro: 0 )");
		Display(  Refresh,"");
		pause(1000);
		Display(  Refresh,"Bonjour a toi jeune aventurier.");
		Display(  Refresh,"En quete de richesses, par recherche de succes ou par gout");
		Display(  Refresh,"du combat, tu entres aujourd'hui dans l'arene.");
		Display(  Refresh,"");
		pause(skip.val);
		Display(  Refresh,"En plein coeur de la capitale, l'arene du Lion est un joyau");
		Display(  Refresh,"dominant la Cite aux mille lumieres.");
		pause(skip.val);
		Display(  Refresh,"Les arcades de ce somptueux batiment ont vu passer les");
		Display(  Refresh,"plus grands musiciens, acteurs, mais aussi des animaux ");
		Display(  Refresh,"exotiques, des spectacles de cirque, des jeux sportifs.");
		pause(skip.val);
		Display(  Refresh,"Mais, l'attraction phare du stade demeure les combats de ");
		Display(  Refresh,"gladiateurs. Du simple mendiant au plus riche marchand,");
		Display(  Refresh,"tous se pressent pour observer les combats.");
		pause(skip.val);
		Display(  Refresh,"");
		Display(  Refresh,"Pour les gladiateurs, c'est l'opportunite de se faire une ");
		Display(  Refresh,"reputation et gagner mille tresors, de s'attirer les faveurs des ");
		Display(  Refresh,"plus belles courtisanes du royaume, ou encore d'ameliorer ses");
		Display(  Refresh,"aptitudes au combat.");
		pause(skip.val*2);
		Display(  Refresh,0);
		Display(  Refresh,"Que tu sois mage, guerrier, assassin, archer, tous les coups sont");
		Display(  Refresh,"permis. L'issue ne peut etre que la victoire... ou la mort.");
		Display(  Refresh,"");
		pause(skip.val);
		
		Display(  Refresh,"Vous entrez donc d'un pas decide sur le terrain, ");
		Display(  Refresh,"confiant en vos aptitudes guerrieres.");	
		pause(skip.val);
		skip.stop();
		Refresh.cancel();
		System.out.println();
		Jeu TableDeJeu = new Jeu(carte);
		
		
		int compteur=0;
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
	public static void Display( TimerTask refresh, String sentence) { //Afficher "sentence"
    	((RefreshAff) refresh).run(sentence);
    }
	public static void Display( TimerTask refresh, int a) { //effacer la console
    	((RefreshAff) refresh).run(a);
    }
	
	public static void pause(long lag) {
	    	try {
				Thread.sleep(lag);
			} catch (InterruptedException e) {
			
			}
	 }
}
