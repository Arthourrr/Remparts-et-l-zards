package Main;

import java.util.Timer;
import java.util.TimerTask;
import Affichage.RefreshAff;

public class Test {

	
	public static void main(String[] args) {
		//System.out.println("");
		int[][] monde = {{-1, 0, 0, 0, 0},{0,0,0,0,0},{0,0,-0,0,0},{0,0,0,0,-0},{0,0,0,0,-0}};
		//Affichage.afficherMonde(monde);
		
		//AnimationClock Clock = new AnimationClock();
		//Clock.start();
		//Display display = new Display(monde, clock);
		//display.start();
		Timer loop= new Timer();
		TimerTask Refresh = new RefreshAff(monde);
		loop.scheduleAtFixedRate(Refresh, 0, 300 );
	}
}
