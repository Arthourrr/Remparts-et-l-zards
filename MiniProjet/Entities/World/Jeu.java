package World;
import Champion.Personnage;
import Run.Affichage;
public class Jeu {
	private int[][] Plateau;//Plateau du jeu
	//DeroulementJeu deroulementjeu = new DeroulementJeu();
	//Initialise le plateau du jeu
	public Jeu (){
		this.setPlateau(InitJeu());
	} 
	//Cree un tableau 5x5
	public int[][] InitJeu(){
		int[][] PlateauDeJeu = new int[5][5];
		return PlateauDeJeu;
	}
	//Depose les pions sur le plateau en des positions x et y predefinies
	/**
	 * @param x
	 * @param y
	 * @param perso
	 */
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
	
	
	//Deplace les pions de +x ou +y
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
	//Affiche le tableau
	//Un JX à la place du joueur
	//Rien si pas de joueur
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
				}else{
					description = description+"|"+this.getPlateau()[i][j]+"or\t";
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
	
	//20% de chances de faire spawn de l'or
	public void RandomGoldSpawn () {
		int x=0;
		int y=0;
		int z = (int) (100*Math.random());
		int g;
		
		if(z<=20) {
			for(int i=0; i<3; i++) {
				x = (int) (4*Math.random());
				y = (int) (4*Math.random());
				if(this.getPlateau()[x][y] != -1 && this.getPlateau()[x][y] != -2){ 
					do{
						g = (int) (100*Math.random());
					}while(g==0);	
					this.getPlateau()[x][y]=(int) (100*Math.random());
				}	
			}
		}
	}
	
	public int[][] getPlateau() {
		return Plateau;
	}
	public void setPlateau(int[][] plateau) {
		Plateau = plateau;
	}

}
	

	
	
	
	
