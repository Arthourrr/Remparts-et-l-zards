package World;
import Champion.Personnage;
public class Jeu {
	private int[][][] Plateau;//Plateau du jeu //y, x, map, effets, joueur 
	Map ChoixCarte = new Map();
	public Jeu (int[][][]tmp){
		this.setPlateau(InitJeu(tmp));
	} 
	//initialise un tableau 5x5 predefini
	public int[][][] InitJeu(int[][][]tmp){
		int[][][] PlateauDeJeu;
		ChoixCarte.InitCarte(tmp);
		PlateauDeJeu = Map.carte;
		return PlateauDeJeu;
	}
	//Depose le personnage sur une case vide du tableau
	public void PosePion(int x,int y, Personnage perso){
		for(int i=0; i<this.getPlateau().length; i++){
			for(int j=0; j<this.getPlateau()[0].length; j++){
				if(this.getPlateau()[i][j][2]==-perso.getJoueur()){
					this.getPlateau()[i][j][2]=0;
				}
				//else{this.getPlateau()[i][j][2]=this.getPlateau()[i][j][2];}
			}
		}	
		this.getPlateau()[x][y][2]=-perso.getJoueur();
	}
	//Deplace un personnage d’un point a un autre du tableau
	public void DeplacePion(int x,int y, Personnage perso){
		for(int i=0; i<this.getPlateau().length; i++){
			for(int j=0; j<this.getPlateau()[0].length; j++){
				if(this.getPlateau()[i][j][2]==-perso.getJoueur()){
					this.getPlateau()[i][j][2]=0;
				}
				//else{this.getPlateau()[i][j]=this.getPlateau()[i][j];}
			}
		}	
		this.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]][2]=-perso.getJoueur();
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

				if(this.getPlateau()[i][j]==new int[] {0,0,0}){
					description = description+"|\t";
				}else if(this.getPlateau()[i][j][2]== -1){
					description = description+"|  J1\t";
				}else if(this.getPlateau()[i][j][2]== -2){
					description = description+"|  J2\t";
				}else if(this.getPlateau()[i][j][0]==-3) {
					description = description+"|  B\t";
				}else if(this.getPlateau()[i][j][0]==-4) {
					description = description+"|  R\t";
				}else if(this.getPlateau()[i][j][2]>0){ //exception: pieces rangees dans la colonne joueur pour combiner avec obstacles & effets
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

	//A une chance de deposer une grosse quantite d’or sur une case
	public void RandomGoldSpawn () {
		int x=0;
		int y=0;
		int z = (int) (75*Math.random()+25);
		int g;

		if(z<40) {
			for(int i=0; i<3; i++) {
				x = (int) (this.Plateau.length*Math.random());
				y = (int) (this.Plateau[0].length*Math.random());
				if(this.getPlateau()[x][y][2] == 0){ 
					do{
						g = (int) (100*Math.random());
					}while(g==0);	
					this.getPlateau()[x][y][2]=(int) (100*Math.random());
				}	
			}
		}
	}
	//Depose a chaque tour un paquet d’or sur une case aleatoire du tableau (pas d’or si la case est celle d’un personnage)
	public void SpawnGoldRegulier() {
		int x=0;
		int y=0;
		int isPieces= 0;
		
		do {
			for (int i=0; i< this.getPlateau().length; i++) {
				for (int j=0; j< this.getPlateau()[0].length; j++) {
					if(this.getPlateau()[i][j][2]>0)
						isPieces++;
				}
			}
			x = (int) (this.Plateau.length*Math.random());
			y = (int) (this.Plateau[0].length*Math.random());
			//System.out.println(isPieces);
			if(this.getPlateau()[x][y][2] == 0 && this.getPlateau()[x][y][0]==0 && isPieces<2){ 	
				this.getPlateau()[x][y][2]=10;
			}
		}while(this.getPlateau()[x][y][2] != 10 && isPieces<2);
	}
	public void fissures(int count) {
		if(count%4 ==0 && this.getPlateau()[0][0][3]==2) {
			int x,y;
			do {
				
				x = (int) ((this.Plateau.length-2)*Math.random()+1);
				y = (int) ((this.Plateau[0].length-2)*Math.random()+1);
				if(this.getPlateau()[x][y][0] == 0){ 
					this.getPlateau()[x][y][0]= -5;
				}
			}while(this.getPlateau()[x][y][0] != -5);
		}else {
		for (int i=0; i< this.getPlateau().length; i++) {
			for (int j=0; j< this.getPlateau()[0].length; j++) {
				if(this.getPlateau()[i][j][0]==-5) {
					this.getPlateau()[i][j][0]=-6;
				}
			}}
		}
	}
	//getters/setters
	
	public int[][][] getPlateau() {
		return Plateau;
	}
	public void setPlateau(int[][][] plateau) {
		Plateau = plateau;
	}

}
