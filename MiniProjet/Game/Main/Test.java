package Main;

import Champion.Personnage;

public class Test {

	public static void main(String []args) {
		
		int[][]carte = {{0,0,0,0,0},{0,-3,0,0,0},{0,-3,0,-3,0},{0,0,0,0,0},{0,0,0,0,0}};
		System.out.println(affiche(carte));
		Personnage p1 = new Personnage(1);
		int[] pos1 = {3,3};
		p1.setPosition(pos1);
		Personnage p2 = new Personnage(2);
		int[] pos2 = {1,0};
		p2.setPosition(pos2);
		if(!p1.isObstacle(p2, carte));
		//System.out.println(p1.isObstacle(p2, carte));
	}
	public static String affiche(int[][] carte) {
	String description = "\n-----------------------------------------\n";
	for(int i=0; i<carte.length; i++){
		for(int j=0; j<carte[0].length; j++){
			description = description+"|\t";
		}
		description = description+"|\n";

		for(int j=0; j<carte[0].length; j++){

			if(carte[i][j]==0){
				description = description+"|\t";
			}else if(carte[i][j]==-1){
				description = description+"|  J1\t";
			}else if(carte[i][j]==-2){
				description = description+"|  J2\t";
			}else if(carte[i][j]==-3) {
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

