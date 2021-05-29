package Main;

import java.util.Timer;
import java.util.TimerTask;
import Affichage.DisplayTxt;
import Affichage.RefreshAff;
import Champion.Personnage;

public class Test {

	public static void main(String []args) {
		
		int comp=0;
		int[][][]carte = new int[5][5][4];// {{0,0,0,0,0},{0,-3,0,0,0},{0,-3,0,-3,0},{0,0,0,0,0},{0,0,0,0,0}};
		carte[1][2][2]=-1;
		System.out.println(affiche(carte));
		Timer loop= new Timer();
		TimerTask Refresh = new RefreshAff(carte, 1);
		((RefreshAff) Refresh).run("Helllllo");
		((RefreshAff) Refresh).run("I'm a human.");
		((RefreshAff) Refresh).run(0);
		((RefreshAff) Refresh).run("I'm a human.");
		loop.scheduleAtFixedRate(Refresh, 0, 300 );
		//DisplayTxt disp = new DisplayTxt();
		//disp.run("Hello");
		//disp.run("jhvjhv");
		//disp.run("");
		//Affichage.Display("Bonjour", comp);
		

		Personnage p1 = new Personnage(1);
		int[] pos1 = {3,3};
		p1.setPosition(pos1);
		Personnage p2 = new Personnage(2);
		int[] pos2 = {1,0};
		p2.setPosition(pos2);
		if(!p1.isObstacle(p2, carte));
		//System.out.println(p1.isObstacle(p2, carte));
	}
	public static String affiche(int[][][] carte) {
	String description = "\n-----------------------------------------\n";
	for(int i=0; i<carte.length; i++){
		for(int j=0; j<carte[0].length; j++){
			description = description+"|\t";
		}
		description = description+"|\n";

		for(int j=0; j<carte[0].length; j++){

			if(carte[i][j][0]==0){
				description = description+"|\t";
			}else if(carte[i][j][2]==-1){
				description = description+"|  J1\t";
			}else if(carte[i][j][2]==-2){
				description = description+"|  J2\t";
			}else if(carte[i][j][0]==-3) {
				description = description+"|  B\t";
			}else{
				description = description+"|  °°°\t";
			}
		}
		description = description+"|\n";
		for(int j=0; j<carte[0].length; j++){
			description = description+"|\t";
		}
		description = description+"|\n-----------------------------------------\n";	
	}
	return description;
	}
	
}

