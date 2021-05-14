package Champion;
import Run.Initialisation;
import Run.DeroulementJeu;
import World.Jeu;
public class Personnage {
	private int ordre; //classe du personnage
	private String nom; //nom
	private int pv; //points de vie
	private int mana; //points de mana pour lancer les sorts/attaques speciales  
	private int pa; //points d'action du perso
	private int po; //pieces d'or
	private int[] position = new int[2]; //position du perso sur le plateau
	private int resistance; //resistance aux attaques
	private int agilite; //augmente proba de toucher adveraire,
	private int dexterite; //chance de coup critique
	private int sagesse; //intelligence/ capacite d'utiliser la magie
	private int force; //augmente attaque
	private int joueur; //numero du joueur
	private int[] Evo; //Evolution des pv. [0]= pv+- ; [1]= nb de tours restants
	private Actions play = new Actions();//Actions
	private Initialisation init = new Initialisation();//appel objet initialisation
	DeroulementJeu deroulementjeu = new DeroulementJeu();//appel objet deroulementjeu
	private Inventaire stuff;//appel objet inventaire
	
	//objet Personnage avec ses diff caracteristiques
	//Initialise : stats/po/pa/pv/numero de personnage
	public Personnage(int N){
		this.setNom("Inconnu");
		this.setPv(100);
		this.setPa(3);//point d'action
		this.setPo(100);
		this.setMana(100);
		this.setResistance((int) (12+8*Math.random())); // nombre aleatoire entre 12 et 20
		this.setAgilite((int) (12+8*Math.random()));
		this.setSagesse((int) (12+8*Math.random()));
		this.setDexterite((int) (12+8*Math.random()));
		this.setForce((int) (12+8*Math.random()));
		this.setJoueur(N);
		this.setStuff(new Inventaire ());
		this.Evo = new int[2];
	}	
	//met à jour le tableau de position du personnage en X et Y
	public void MajPosition (int X, int Y){	//met à jouer la position en faisant avancer/reculer selon X et Y
		this.getPosition()[0]=this.getPosition()[0]+X;
		this.getPosition()[1]=this.getPosition()[1]+Y;
	}
	//met à jour les statistiques du personnage (pour les PV notamment avec une potion de vie ou des dégats de durée magiques
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
		if (this.Evo[1]==0) {
			this.Evo[0]=0;
		}
	}
	//apporte des variations de statistiques selon la classe de personnage choisie
	public void SetStatistiques(int numero, String nom){ //ajout de pts de stats aux personnages selon la classe choisie
		switch(numero){
		case 1 :
			this.setAgilite(this.getAgilite() +9);
			this.setSagesse(this.getSagesse() -6);
			this.setResistance(this.getResistance() -3);
			this.setForce(this.getForce() -6);				
			break;
		case 2 :
			this.setDexterite(this.getDexterite() +9);
			this.setSagesse(this.getSagesse() -3);
			this.setResistance(this.getResistance() -3);
			this.setForce(this.getForce() -3);	
			break;
		case 3 :
			this.setAgilite(this.getAgilite() -6);
			this.setSagesse(this.getSagesse() -6);
			this.setResistance(this.getResistance() +6);
			this.setForce(this.getForce() +6);	
			break;
		case 4 :
			this.setAgilite(this.getAgilite() -3);
			this.setSagesse(this.getSagesse() +9);
			this.setResistance(this.getResistance() -3);
			this.setForce(this.getForce() -3);	
			break;  
		}
		this.setNom(nom);       
	}	
	//affiche les stats du personnage
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
	//affiche l’état du personnage (pv,pa,po,mana)
	public String AffichePerso (){

		String description = "Personnage\n";
		description = description+"PV 	\t :	\t"+this.getPv()+"\n";
		description = description+"Mana \t\t :	\t"+this.mana+"\n";	
		description = description+"PO 	\t :	\t"+this.getPo()+"\n";
		description = description+"PA	\t :	\t"+this.getPa()+"\n";
		description = description+"--------------------------\n";				
		return description;
	}
	//donne la distance entre les personnages (utile notamment pour le tir à l’arc)
	public double distance(Personnage p2) {
		double d = Math.sqrt(Math.pow(this.getPosition()[0]-p2.getPosition()[0],2)+Math.pow(this.getPosition()[1]-p2.getPosition()[1],2));
		return d;
	}
	//getters / setters
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
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
}
