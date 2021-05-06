package World;
import Champion.Personnage;
public class Jeu {
	private int[][] Plateau;//Plateau du jeu
	//DeroulementJeu deroulementjeu = new DeroulementJeu();
	//Initialise le plateau du jeu
	public Jeu (){
		this.setPlateau(InitJeu());
	} 
	//Cree un tableau 10x10
	public int[][] InitJeu(){
		int[][] PlateauDeJeu = new int[5][5];
		return PlateauDeJeu;
	}
	//Depose les pions sur le plateau en des positions x et y predefinies
	public void PosePion(int x,int y, Personnage perso){
		for(int i=0; i<this.getPlateau().length; i++){
			for(int j=0; j<this.getPlateau()[0].length; j++){
				if(this.getPlateau()[i][j]==perso.getJoueur()){
					this.getPlateau()[i][j]=0;
				}
				else{
					this.getPlateau()[i][j]=this.getPlateau()[i][j];
				}
			}
		}	
		this.getPlateau()[x][y]=perso.getJoueur();
	}
	//Deplace les pions de +x ou +y
	public void DeplacePion(int x,int y, Personnage perso){
		
		for(int i=0; i<this.getPlateau().length; i++){
			for(int j=0; j<this.getPlateau()[0].length; j++){
				
				if(this.getPlateau()[i][j]==perso.getJoueur()){
					this.getPlateau()[i][j]=0;
				}
				else{
					this.getPlateau()[i][j]=this.getPlateau()[i][j];
				}
				
			}
		}	
		this.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]]=perso.getJoueur();
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
				}else if(this.getPlateau()[i][j]==1){
					description = description+"|  J1\t";
				}else if(this.getPlateau()[i][j]==2){
					description = description+"|  J2\t";
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
	public int[][] getPlateau() {
		return Plateau;
	}
	public void setPlateau(int[][] plateau) {
		Plateau = plateau;
	}	
}
	

	
	
	
	