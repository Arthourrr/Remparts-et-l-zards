package Main; 
import Run.RunGame;
public class Launch {
	public static void main (String[] arg){
		RunGame.Partie1v1();
	}
	 public static void pause(long lag) {
	    	try {
				Thread.sleep(lag);
			} catch (InterruptedException e) {
			}
	 }
}	
