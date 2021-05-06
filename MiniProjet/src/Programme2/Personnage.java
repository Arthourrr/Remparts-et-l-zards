package Programme2;
public class Personnage {
	int ordre; //classe du personnage
	String nom; //nom du perso
	int pv; //point de vie du perso
	int mana; //points de mana pour lancer les sorts/attaques speciales  
	int pa; //point d'action du perso
	int po; //pièces d'or
	int[] position = new int[2]; //position du perso sur le jeu
	int resistance; // resistance aux attaques
	int agilite; //augmente proba de toucher adveraire,
	int dexterite; //chance de coup critique
	int sagesse; //intelligence/ capacite d'utiliser la magie
	int force; //augmente attaque
	int joueur; //numero du joueur
	int[] evo;
	Actions play = new Actions();//Actions
	Initialisation init = new Initialisation();
	DeroulementJeu deroulementjeu = new DeroulementJeu();
	Inventaire stuff;
 //objet Personnage avec ses diff caracteristiques
 //Initialise : stats/po/pa/pv/numero de personnage
	public Personnage(int N){
		this.nom = "Inconnu";
		this.pv= 100;
		this.pa=3;//point d'action
		this.po=100;
		this.resistance= (int) (8+12*Math.random()); // nombre aleatoire entre 8 et 20
		this.agilite= (int) (8+13*Math.random());
		this.sagesse= (int) (8+12*Math.random());
		this.dexterite=(int) (8+12*Math.random());
		this.force =(int) (8+12*Math.random());
		this.joueur = N;
		this.stuff = new Inventaire ();
		this.evo = new int[2];
	}	
 //Mise à jour de la position sur le plateau
	public void MajPosition (int X, int Y){	//met à jouer la position en faisant avancer/reculer selon X et Y
		this.position[0]=this.position[0]+X;
		this.position[1]=this.position[1]+Y;
	}
//Fait apparaître le personnage aleatoirement sur le plateau en debut de partie
	public void Spawn (int tempx, int tempy){//Fait apparaître les personnages sur le plateau aleatoirement et pas sur la même place
		int x=0;
		int y=0;
		do{	
		x = (int) (4*Math.random());
		y = (int) (4*Math.random());
		}while(x==tempx && y==tempy);
		this.position[0]=this.position[0]+x;
		this.position[1]=this.position[1]+y;
	}
//Associe les amelioration selon la classe (l’ordre) du joueur choisit manuellement avec un numero de 1 à 4
	public void SetStatistiques(int numero, String nom){ //ajout de pts de stats aux personnages selon la classe choisie
		switch(numero){
			case 1 :
				this.dexterite=this.dexterite+1;
				this.agilite=this.agilite+1;
				break;
			case 2 :
				this.agilite=this.agilite+1;
				this.sagesse++;
				break;
			case 3 :
				this.force++;
				this.resistance++;
				break;
			case 4 :
				this.dexterite=this.dexterite+2;
				this.sagesse=this.sagesse+3;
				this.force=this.force-3;
				break;  
		}
		this.nom=nom;       
	}	
//Affiche les stats du personnage
	public String AfficheStats(){
		String description;
		description = "--------------------------\n";
		description = description+"Bonjour, "+this.nom+"\n";
		description = description+"Ta classe est\t"+this.ordre+"\n\n";
		description = description+"Tes caracteristiques sont :\n\n";
		description = description+"Agilite :\t"+this.agilite+"\n";
		description = description+"Dexterite :\t"+this.dexterite+"\n";
		description = description+"Force :\t\t"+this.force+"\n";
		description = description+"Resistance :\t"+this.resistance+"\n";
		description = description+"Sagesse :\t"+this.sagesse+"\n\n";
		description = description+"--------------------------\n";
		return description;
	}
//Affiche les pv/mana/pa/po
	public String AffichePerso (){
		if(this.evo[0]<0 && this.evo[1]>0) {
			this.pv= this.pv-evo[0];
			this.evo[1]--;
			System.out.println("Vous subissez "+ evo[0]+ " degats.");
		}
		String description = "Personnage\n";
		description = description+"PV 	\t :	\t"+this.pv+"\n";
		description = description+"Mana \t\t :	\t"+this.mana+"\n";	
		description = description+"PO 	\t :	\t"+this.pv+"\n";
		description = description+"PA	\t :	\t"+this.pa+"\n";
		description = description+"--------------------------\n";				
		return description;
	}
//Donne la distance entre les deux personnages
	public double distance(Personnage p2) {
		double d = Math.sqrt(Math.pow(this.position[0]-p2.position[0],2)+Math.pow(this.position[1]-p2.position[1],2));
		return d;
	}
}
