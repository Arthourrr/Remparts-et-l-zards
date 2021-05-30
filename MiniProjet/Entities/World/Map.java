package World;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import Affichage.RefreshAff;
import Run.RunGame;
public class Map {
	static int[][][] carte= new int[5][5][4];	
	//static Timer loop= new Timer();
	//static TimerTask Refresh = new RefreshAff(carte);
	public Map (){
	}
	
	
	public void InitCarte(int[][][] map) {
		boolean Verif = false;
		int[][][]tmp;
		
		//loop.scheduleAtFixedRate(Refresh, 0, 300 );
		while(Verif == false) {
			RunGame.Display( 0);
			RunGame.Display( "Vous et votre adversaire vous concertez pour savoir quel sera");
			RunGame.Display( "le terrain de votre glorieux affrontement.");
			RunGame.Display( "Clairiere : 1 ; Arene en fusion : 2.");
			Scanner n = new Scanner(System.in); 
			final int numero = n.nextInt();
			switch(numero){
				case 1 ://5x5 clairiere
					for(int i=0; i<Carte1().length; i++) {
						for(int j=0; j<Carte1()[0].length; j++) {
							for(int k=0; k<Carte1()[0][0].length; k++) {
								carte[i][j][k]=Carte1()[i][j][k];
							}
						}
					}
					tmp= Carte1();
					for(int i=0; i<map.length; i++) {
						for(int j=0; j<map[0].length; j++) {
							for(int k=0; k<map[0][0].length; k++) {
								map[i][j][k]=tmp[i][j][k];
							}
						}
					}map[0][0][3]=1;
					if(ValidationCarte()) {
						Verif = true;
						break;
					}else{
						break;
					}
				case 2 ://5x5 volcan
					for(int i=0; i<Carte2().length; i++) {
						for(int j=0; j<Carte2()[0].length; j++) {
							for(int k=0; k<Carte2()[0][0].length; k++) {
								carte[i][j][k]=Carte2()[i][j][k];
							}
						}
					}
					tmp= Carte2();
					for(int i=0; i<map.length; i++) {
						for(int j=0; j<map[0].length; j++) {
							for(int k=0; k<map[0][0].length; k++) {
								map[i][j][k]=tmp[i][j][k];
							}
						}
					}map[0][0][3]=2;
					if(ValidationCarte()) {
						Verif = true;
						break;
					}else{
						break;
					}
				/*case 3 ://5x5 with obstacles carré central
					this.carte = Carte3();
					if(ValidationCarte()) {
						Verif = true;
						break;
					}else{
						break;
					}*/
			}
		}
		//Refresh.cancel();
	}
	
	public int[][][] Carte1 () {
		int[][][] Carte = new int[5][5][4];
		Carte[0][0][3] = 1; // mode de jeu, num texture
		int x=0;
		int y=0;
		int nbBuissons= 0;
		int nbMenhirs= 0;
		
		do {
			nbBuissons=0;
			for (int i=0; i< Carte.length; i++) {
				for (int j=0; j< Carte[0].length; j++) {
					if(Carte[i][j][0]==-3)
						nbBuissons++;
				}
			}
			x = (int) (Carte.length*Math.random());
			y = (int) (Carte[0].length*Math.random());
			System.out.println(nbBuissons);
			if(Carte[x][y][0] == 0 && nbBuissons<4){ 	
				Carte[x][y][0]=-3;
			}
		}while(nbBuissons<4);
		
		do {
			nbMenhirs=0;
			for (int i=0; i< Carte.length; i++) {
				for (int j=0; j< Carte[0].length; j++) {
					if(Carte[i][j][0]==-4)
						nbMenhirs++;
				}
			}
			x = (int) (Carte.length*Math.random());
			y = (int) (Carte[0].length*Math.random());
			System.out.println(nbMenhirs);
			if(Carte[x][y][0] == 0 && nbMenhirs<2){ 	
				Carte[x][y][0]=-4;
			}
		}while(nbMenhirs<2);
		return Carte;
	}
	
	
	public int[][][] Carte2 () {
		int[][][] Carte = new int[5][5][4];
		Carte[0][0][3] = 2; // mode de jeu, num texture
		int x,y;
		int nbMenhirs=0;
		do {
			nbMenhirs=0;
			for (int i=0; i< Carte.length; i++) {
				for (int j=0; j< Carte[0].length; j++) {
					if(Carte[i][j][0]==-4)
						nbMenhirs++;
				}
			}
			x = (int) (Carte.length*Math.random());
			y = (int) (Carte[0].length*Math.random());
			System.out.println(nbMenhirs);
			if(Carte[x][y][0] == 0 && nbMenhirs<2){ 	
				Carte[x][y][0]=-4;
			}
		}while(nbMenhirs<2);
		return Carte;
	}
	
	public int[][] Carte3 () {
		int[][] Carte = new int[5][5];
		for(int i=1;i<4;i++) {for(int j=1;j<4;j++) {Carte[i][j]=-3;}}
		return Carte;
	}
	
	public boolean ValidationCarte() {
		System.out.println(AffichePlateau(carte));
		//Affichage.afficherMonde(this.carte);
		RunGame.Display( "");
		RunGame.Display( "Etes-vous sur ? (1: oui ; 0: retour)");
		Scanner V = new Scanner(System.in); 
		final int verif = V.nextInt();
		if(verif==1) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//Tests sur console
	public String AffichePlateau (int[][][] carte){
		
		String description = "\n-----------------------------------------\n";
		for(int i=0; i<carte.length; i++){
			for(int j=0; j<carte[0].length; j++){
					description = description+"|\t";
			}
			description = description+"|\n";
			
			for(int j=0; j<carte[0].length; j++){

				if(carte[i][j]==new int[] {0,0,0}){
					description = description+"|\t";
				}else if(carte[i][j][2]== -1){
					description = description+"|  J1\t";
				}else if(carte[i][j][2]== -2){
					description = description+"|  J2\t";
				}else if(carte[i][j][0]==-3) {
					description = description+"|  B\t";
				}else if(carte[i][j][0]==-4) {
					description = description+"|  R\t";
				}else if(carte[i][j][2]>0){ //exception: pièces rangées dans la colonne joueur pour combiner avec obstacles & effets
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
