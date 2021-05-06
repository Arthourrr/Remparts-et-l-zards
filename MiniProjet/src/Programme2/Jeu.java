package Programme2;
public class Jeu {
	int[][] Plateau;//Plateau du jeu
	//DeroulementJeu deroulementjeu = new DeroulementJeu();
	//Initialise le plateau du jeu
	public Jeu (){
		this.Plateau = InitJeu();
	} 
	//Cree un tableau 10x10
	public int[][] InitJeu(){
		int[][] PlateauDeJeu = new int[5][5];
		return PlateauDeJeu;
	}
	//Depose les pions sur le plateau en des positions x et y predefinies
	public void PosePion(int x,int y, Personnage perso){
		for(int i=0; i<this.Plateau.length; i++){
			for(int j=0; j<this.Plateau[0].length; j++){
				if(this.Plateau[i][j]==perso.joueur){
					this.Plateau[i][j]=0;
				}
				else{
					this.Plateau[i][j]=this.Plateau[i][j];
				}
			}
		}	
		this.Plateau[x][y]=perso.joueur;
	}
	//Deplace les pions de +x ou +y
	public void DeplacePion(int x,int y, Personnage perso){
		
		for(int i=0; i<this.Plateau.length; i++){
			for(int j=0; j<this.Plateau[0].length; j++){
				
				if(this.Plateau[i][j]==perso.joueur){
					this.Plateau[i][j]=0;
				}
				else{
					this.Plateau[i][j]=this.Plateau[i][j];
				}
				
			}
		}	
		this.Plateau[perso.position[0]][perso.position[1]]=perso.joueur;
	}	
	//Affiche le tableau
	//Un JX à la place du joueur
	//Rien si pas de joueur
	public String AffichePlateau (){	
		String description = "\n-----------------------------------------\n";
		for(int i=0; i<this.Plateau.length; i++){
			for(int j=0; j<this.Plateau[0].length; j++){
					description = description+"|\t";
			}
			description = description+"|\n";
			
			for(int j=0; j<this.Plateau[0].length; j++){
				
				if(this.Plateau[i][j]==0){
					description = description+"|\t";
				}else if(this.Plateau[i][j]==1){
					description = description+"|  J1\t";
				}else if(this.Plateau[i][j]==2){
					description = description+"|  J2\t";
				}
				
			}
			description = description+"|\n";
			
			for(int j=0; j<this.Plateau[0].length; j++){
					description = description+"|\t";
			}
			
		description = description+"|\n-----------------------------------------\n";	
		}
		return description;
	}	
}
	

	
	
	
	
