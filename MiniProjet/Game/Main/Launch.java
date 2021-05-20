package Main;
import java.util.Scanner;

//import java.util.Scanner;
import Run.AePlayWave;
import Run.DeroulementJeu;
import Run.RunGame;
public class Launch {
	public static void main (String[] arg){

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
