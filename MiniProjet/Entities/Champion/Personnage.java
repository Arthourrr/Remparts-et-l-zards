package Champion;
import Run.Initialisation;
import Run.DeroulementJeu;
public class Personnage {
	private int ordre; //classe du personnage
	private String nom; //nom du perso
	private int pv; //point de vie du perso
	int mana; //points de mana pour lancer les sorts/attaques speciales  
	private int pa; //point d'action du perso
	private int po; //pièces d'or
	private int[] position = new int[2]; //position du perso sur le jeu
	private int resistance; // resistance aux attaques
	private int agilite; //augmente proba de toucher adveraire,
	private int dexterite; //chance de coup critique
	private int sagesse; //intelligence/ capacite d'utiliser la magie
	private int force; //augmente attaque
	private int joueur; //numero du joueur
	private int[] Evo; //Evolution des pv. [0]= pv+- ; [1]= nb de tours restants
	private Actions play = new Actions();//Actions
	private Initialisation init = new Initialisation();
	DeroulementJeu deroulementjeu = new DeroulementJeu();
	private Inventaire stuff;
 //objet Personnage avec ses diff caracteristiques
 //Initialise : stats/po/pa/pv/numero de personnage
	public Personnage(int N){
		this.setNom("Inconnu");
		this.setPv(100);
		this.setPa(3);//point d'action
		this.setPo(100);
		this.setResistance((int) (8+12*Math.random())); // nombre aleatoire entre 8 et 20
		this.setAgilite((int) (8+13*Math.random()));
		this.setSagesse((int) (8+12*Math.random()));
		this.setDexterite((int) (8+12*Math.random()));
		this.setForce((int) (8+12*Math.random()));
		this.setJoueur(N);
		this.setStuff(new Inventaire ());
		this.Evo = new int[2];
	}	
 //Mise à jour de la position sur le plateau
	public void MajPosition (int X, int Y){	//met à jouer la position en faisant avancer/reculer selon X et Y
		this.getPosition()[0]=this.getPosition()[0]+X;
		this.getPosition()[1]=this.getPosition()[1]+Y;
	}
	//Mise a jour des stats de personnage
	public void MajStats() {
		if(this.Evo[0]<0 && this.Evo[1]>0) {
			this.setPv(this.getPv()+Evo[0]);
			this.Evo[1]--;
			System.out.println("Vous subissez "+ -Evo[0]+ " degats.");
		} else if (this.Evo[0]>0 && this.Evo[1]>0){
			this.setPv(this.getPv()+Evo[0]);
			this.Evo[1]--;
			System.out.println("Vous gagnez "+ Evo[0]+ " pv.");
		}
	}
//Fait apparaître le personnage aleatoirement sur le plateau en debut de partie
	public void Spawn (int tempx, int tempy){//Fait apparaître les personnages sur le plateau aleatoirement et pas sur la même place
		int x=0;
		int y=0;
		do{	
		x = (int) (4*Math.random());
		y = (int) (4*Math.random());
		}while(x==tempx && y==tempy);
		this.getPosition()[0]=this.getPosition()[0]+x;
		this.getPosition()[1]=this.getPosition()[1]+y;
	}
//Associe les amelioration selon la classe (l’ordre) du joueur choisit manuellement avec un numero de 1 à 4
	public void SetStatistiques(int numero, String nom){ //ajout de pts de stats aux personnages selon la classe choisie
		switch(numero){
			case 1 :
				this.setDexterite(this.getDexterite()+1);
				this.setAgilite(this.getAgilite()+1);
				break;
			case 2 :
				this.setAgilite(this.getAgilite()+1);
				this.setSagesse(this.getSagesse() + 1);
				break;
			case 3 :
				this.setForce(this.getForce() + 1);
				this.setResistance(this.getResistance() + 1);
				break;
			case 4 :
				this.setDexterite(this.getDexterite()+2);
				this.setSagesse(this.getSagesse()+3);
				this.setForce(this.getForce()-3);
				break;  
		}
		this.setNom(nom);       
	}	
//Affiche les stats du personnage
	public String AfficheStats(){
		String description;
		description = "--------------------------\n";
		description = description+"Bonjour, "+this.getNom()+"\n";
		description = description+"Ta classe est\t"+this.getOrdre()+"\n\n";
		description = description+"Tes caracteristiques sont :\n\n";
		description = description+"Agilite :\t"+this.getAgilite()+"\n";
		description = description+"Dexterite :\t"+this.getDexterite()+"\n";
		description = description+"Force :\t\t"+this.getForce()+"\n";
		description = description+"Resistance :\t"+this.getResistance()+"\n";
		description = description+"Sagesse :\t"+this.getSagesse()+"\n\n";
		description = description+"--------------------------\n";
		return description;
	}
//Affiche les pv/mana/pa/po
	public String AffichePerso (){
		
		String description = "Personnage\n";
		description = description+"PV 	\t :	\t"+this.getPv()+"\n";
		description = description+"Mana \t\t :	\t"+this.mana+"\n";	
		description = description+"PO 	\t :	\t"+this.getPv()+"\n";
		description = description+"PA	\t :	\t"+this.getPa()+"\n";
		description = description+"--------------------------\n";				
		return description;
	}
//Donne la distance entre les deux personnages
	public double distance(Personnage p2) {
		double d = Math.sqrt(Math.pow(this.getPosition()[0]-p2.getPosition()[0],2)+Math.pow(this.getPosition()[1]-p2.getPosition()[1],2));
		return d;
	}
	public int getJoueur() {
		return joueur;
	}
	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}
	public int[] getPosition() {
		return position;
	}
	public void setPosition(int[] position) {
		this.position = position;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAgilite() {
		return agilite;
	}
	public void setAgilite(int agilite) {
		this.agilite = agilite;
	}
	public int getDexterite() {
		return dexterite;
	}
	public void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getSagesse() {
		return sagesse;
	}
	public void setSagesse(int sagesse) {
		this.sagesse = sagesse;
	}
	public int getResistance() {
		return resistance;
	}
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public Actions getPlay() {
		return play;
	}
	public void setPlay(Actions play) {
		this.play = play;
	}
	public int getPa() {
		return pa;
	}
	public void setPa(int pa) {
		this.pa = pa;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getPo() {
		return po;
	}
	public void setPo(int po) {
		this.po = po;
	}
	public Initialisation getInit() {
		return init;
	}
	public void setInit(Initialisation init) {
		this.init = init;
	}
	public int[] getEvo() {
		return Evo;
	}
	public void setEvo(int[]Evo) {
		this.Evo[0] = this.Evo[0] + Evo[0];
		this.Evo[1] = this.Evo[1] + Evo[1];
	}
	public Inventaire getStuff() {
		return stuff;
	}
	public void setStuff(Inventaire stuff) {
		this.stuff = stuff;
	}
}
