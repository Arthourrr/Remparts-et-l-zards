package World;
import java.util.Scanner;
import Run.Affichage;
//import World.Jeu;
public class Map {
	int[][] carte;	
	public Map (){
	}
	
	
	public void InitCarte() {
		boolean Verif = false;
		while(Verif == false) {
			System.out.println("Vous et votre adversaire vous concertez pour savoir quel sera le terrain de votre glorieux affrontement. Choisissez votre terrain (1,2 ou 3):");			
			Scanner n = new Scanner(System.in); 
			final int numero = n.nextInt();
			switch(numero){
				case 1 ://5x5 normale
					this.carte = Carte1();
					if(ValidationCarte()) {
						Verif = true;
						break;
					}else{
						break;
					}
				case 2 ://5x5 with obstacles U
					this.carte = Carte2();
					if(ValidationCarte()) {
						Verif = true;
						break;
					}else{
						break;
					}
				case 3 ://5x5 with obstacles carré central
					this.carte = Carte3();
					if(ValidationCarte()) {
						Verif = true;
						break;
					}else{
						break;
					}
			}
		}
	}
	
	public int[][] Carte1 () {
		int[][] Carte = new int[5][5];
		return Carte;
	}
	
	
	public int[][] Carte2 () {
		int[][] Carte = new int[5][5];
		for(int i=1;i<4;i++) {Carte[i][1]=-3;}
		for(int i=1;i<4;i++) {Carte[i][3]=-3;}
		for(int i=1;i<4;i++) {Carte[1][i]=-3;}
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
	public String AffichePlateau (int[][] carte){
		
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
				}else if(carte[i][j]==-4) {
					description = description+"|\t";
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
