package Main;
import java.util.Scanner;

//import java.util.Scanner;
import Run.AePlayWave;
import Run.RunGame;
public class Launch {
	public static void main (String[] arg){
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
		
		System.out.println("Combien de joueurs êtes-vous ?");
		System.out.println("1: 2 joueurs (1v1)");
		//System.out.println("2: 4 joueurs (2v2)");
		Scanner n = new Scanner(System.in); 
		final int typepartie = n.nextInt();
		
		if(typepartie==1) {
			RunGame.Partie1v1();
		}//else if(typepartie==2) {
		//	RunGame.Partie2v2();
		//}
		
		
		
	}
	 public static void pause(long lag) {
	    	try {
				Thread.sleep(lag);
			} catch (InterruptedException e) {
			}
	 }
}	
