package Run;
//import java.util.Scanner;
import Champion.Personnage;
import World.Jeu;
import java.util.Timer;
import java.util.TimerTask;
import Affichage.RefreshAff;
public class RunGame {
	static int[][][]carte = new int[5][5][4];
	public static Timer loop= new Timer();
	public static TimerTask Refresh = new RefreshAff(carte);
	public RunGame() {	
	
	}
	//Intro du jeu avec initialisation du jeu (personnages, map)
	public static void Partie1v1() {
	    //music INTRO	
		loop.scheduleAtFixedRate(Refresh, 0, 300 );
		AePlayWave Intro = new AePlayWave(System.getProperty("user.dir") + "\\Audio\\Title_Screen01.wav");
		Intro.start();
		Update skip = new Update();
		skip.setDaemon(true);
		skip.start();
		Display( "(Passer l'intro: 0 )");
		Display( "");
		pause(1000);
		Display( "Bonjour a toi jeune aventurier.");
		Display( "En quete de richesses, par recherche de succes ou par gout");
		Display( "du combat, tu entres aujourd'hui dans l'arene.");
		Display( "");
		pause(skip.val);
		Display( "En plein coeur de la capitale, l'arene du Lion est un joyau");
		Display( "dominant la Cite aux mille lumieres.");
		pause(skip.val);
		Display( "Les arcades de ce somptueux batiment ont vu passer les");
		Display( "plus grands musiciens, acteurs, mais aussi des animaux ");
		Display( "exotiques, des spectacles de cirque, des jeux sportifs.");
		pause(skip.val);
		Display( "Mais, l'attraction phare du stade demeure les combats de ");
		Display( "gladiateurs. Du simple mendiant au plus riche marchand,");
		Display( "tous se pressent pour observer les combats.");
		pause(skip.val);
		Display( "");
		Display( "Pour les gladiateurs, c'est l'opportunite de se faire une ");
		Display( "reputation et gagner mille tresors, de s'attirer les faveurs des ");
		Display( "plus belles courtisanes du royaume, ou encore d'ameliorer ses");
		Display( "aptitudes au combat.");
		pause(skip.val*2);
		Display( 0);
		Display( "Que tu sois mage, guerrier, assassin, archer, tous les coups sont");
		Display( "permis. L'issue ne peut etre que la victoire... ou la mort.");
		Display( "");
		pause(skip.val);
		
		Display( "Vous entrez donc d'un pas decide sur le terrain, ");
		Display( "confiant en vos aptitudes guerrieres.");	
		pause(skip.val);
		skip.stop();
		System.out.println();
		Jeu TableDeJeu = new Jeu(carte);
		int compteur=0;
		Display("Joueur 1 a toi\n");
		compteur++;
		Personnage Perso1 = new Personnage(1);
		Perso1.getInit();
		Initialisation.InitPerso(Perso1, carte);
		do {
			Perso1.getInit().Spawn(0,0,Perso1,TableDeJeu);
		}while(TableDeJeu.getPlateau()[Perso1.getPosition()[0]][Perso1.getPosition()[1]][2]!=0);
		TableDeJeu.PosePion(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso1);//pose le joueur sur un pt du tableau
		//init perso2
		Display("Joueur 2 a toi\n");
		compteur++;
		Personnage Perso2 = new Personnage(2);
		Perso2.getInit();
		Initialisation.InitPerso(Perso2, carte);
		do {
			Perso2.getInit().Spawn(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso2,TableDeJeu);	
		}while(TableDeJeu.getPlateau()[Perso2.getPosition()[0]][Perso2.getPosition()[1]][2]!=0);
		TableDeJeu.PosePion(Perso2.getPosition()[0],Perso2.getPosition()[1],Perso2);//pose le joueur sur un pt du tableau
		Intro.stop();
		//music debut
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
	public static void Display(String sentence) { //Afficher "sentence"
		int lg=61;
		int quotient = sentence.length()/lg;
		int reste = sentence.length()%lg;
		for (int i=0; i<quotient*lg; i=i+lg) {
			((RefreshAff) RunGame.Refresh).run(sentence.substring(i, i+lg));
		}
		if (reste!=0) {
			((RefreshAff) RunGame.Refresh).run(sentence.substring(quotient*lg, quotient*lg +reste));
		}
    	
    }
	public static void Display(int a) { //effacer la console
    	((RefreshAff) RunGame.Refresh).run(a);
    }
	
	public static void pause(long lag) {
	    	try {
				Thread.sleep(lag);
			} catch (InterruptedException e) {
			
			}
	 }
}
