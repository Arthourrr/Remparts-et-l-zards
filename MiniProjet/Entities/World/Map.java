package World;
import java.util.Scanner;
public class Map {
	int[][][] carte;	
	public Map (){
	}
	
	
	public void InitCarte() {
		boolean Verif = false;
		while(Verif == false) {
			System.out.println("Vous et votre adversaire vous concertez pour savoir quel sera le terrain de votre glorieux affrontement. Clairière : 1 ; Arène en fusion : 2.");			
			Scanner n = new Scanner(System.in); 
			final int numero = n.nextInt();
			switch(numero){
				case 1 ://5x5 clairiere
					this.carte = Carte1();
					if(ValidationCarte()) {
						Verif = true;
						break;
					}else{
						break;
					}
				case 2 ://5x5 volcan
					this.carte = Carte2();
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
		System.out.println(AffichePlateau(this.carte));
		//Affichage.afficherMonde(this.carte);
		System.out.println("Etes-vous sûr ? (1: oui ; 0: retour)");
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
