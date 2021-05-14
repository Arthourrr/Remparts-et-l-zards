package Affichage;

import java.util.TimerTask;

public class RefreshAff extends TimerTask{
	int[][]monde;
	int det;

	public RefreshAff(int[][]a) {
		this.monde=a;
	}
	
	@Override
	public void run() {
		if(det==1) {
			det=2;
		}else if (!(det==1)) {
			det=1;
		}

		//System.out.println("Thread Refresh = "+det);
		Affichage.afficherMonde(monde, 100, det);
		//Display display = new Display(monde, det);
		//display.start();
		
	}

}
