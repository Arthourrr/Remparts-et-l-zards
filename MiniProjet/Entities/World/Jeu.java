package World;
import Champion.Personnage;
public class Jeu {
	private int[][] Plateau;//Plateau du jeu
	Map ChoixCarte = new Map();
	public Jeu (){
		this.setPlateau(InitJeu());
	} 
	//initialise un tableau 5x5 prédéfini
	public int[][] InitJeu(){
		int[][] PlateauDeJeu;
		ChoixCarte.InitCarte();
		PlateauDeJeu = ChoixCarte.carte;
		return PlateauDeJeu;
	}
	//Dépose le personnage sur une case vide du tableau
	public void PosePion(int x,int y, Personnage perso){
		for(int i=0; i<this.getPlateau().length; i++){
			for(int j=0; j<this.getPlateau()[0].length; j++){
				if(this.getPlateau()[i][j]==-perso.getJoueur()){
					this.getPlateau()[i][j]=0;
				}
				else{
					this.getPlateau()[i][j]=this.getPlateau()[i][j];
				}
			}
		}	
		this.getPlateau()[x][y]=-perso.getJoueur();
	}
	//Déplace un personnage d’un point à un autre du tableau
	public void DeplacePion(int x,int y, Personnage perso){
		for(int i=0; i<this.getPlateau().length; i++){
			for(int j=0; j<this.getPlateau()[0].length; j++){
				if(this.getPlateau()[i][j]==-perso.getJoueur()){
					this.getPlateau()[i][j]=0;
				}
				else{
					this.getPlateau()[i][j]=this.getPlateau()[i][j];
				}
			}
		}	
		this.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]]=-perso.getJoueur();
	}	
	//Affichage du plateau
	public String AffichePlateau (){
		String description = "\n-----------------------------------------\n";
		for(int i=0; i<this.getPlateau().length; i++){
			for(int j=0; j<this.getPlateau()[0].length; j++){
				description = description+"|\t";
			}
			description = description+"|\n";

			for(int j=0; j<this.getPlateau()[0].length; j++){

				if(this.getPlateau()[i][j]==0){
					description = description+"|\t";
				}else if(this.getPlateau()[i][j]==-1){
					description = description+"|  J1\t";
				}else if(this.getPlateau()[i][j]==-2){
					description = description+"|  J2\t";
				}else if(this.getPlateau()[i][j]==-3) {
					description = description+"|  B\t";
				}else{
					description = description+"|  °°°\t";
				}
			}
			description = description+"|\n";
			for(int j=0; j<this.getPlateau()[0].length; j++){
				description = description+"|\t";
			}
			description = description+"|\n-----------------------------------------\n";	
		}
		return description;
	}

	//A une chance de déposer une grosse quantité d’or sur une case
	public void RandomGoldSpawn () {
		int x=0;
		int y=0;
		int z = (int) (75*Math.random()+25);
		int g;

		if(z<40) {
			for(int i=0; i<3; i++) {
				x = (int) (this.Plateau.length*Math.random());
				y = (int) (this.Plateau[0].length*Math.random());
				if(this.getPlateau()[x][y] == 0){ 
					do{
						g = (int) (100*Math.random());
					}while(g==0);	
					this.getPlateau()[x][y]=(int) (100*Math.random());
				}	
			}
		}
	}
	//Dépose à chaque tour un paquet d’or sur une case aléatoire du tableau (pas d’or si la case est celle d’un personnage)
	public void SpawnGoldRegulier() {
		int x=0;
		int y=0;
		int isPièces= 0;
		
		do {
			for (int i=0; i< this.getPlateau().length; i++) {
				for (int j=0; j< this.getPlateau()[0].length; j++) {
					if(this.getPlateau()[i][j]>0)
						isPièces++;
				}
			}
			x = (int) (this.Plateau.length*Math.random());
			y = (int) (this.Plateau[0].length*Math.random());
			System.out.println(isPièces);
			if(this.getPlateau()[x][y] == 0 && isPièces<2){ 	
				this.getPlateau()[x][y]=10;
			}
		}while(this.getPlateau()[x][y] != 10 && isPièces<2);
	}
	//getters/setters
	public void PlaceObstacles (int X, int Y) {
		this.getPlateau()[X][Y]=-3;
	}	
	public int[][] getPlateau() {
		return Plateau;
	}
	public void setPlateau(int[][] plateau) {
		Plateau = plateau;
	}
}
