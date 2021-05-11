package Champion;
public class Objets {
    int armure;
    int soin;
    int quantite;
    int prix;
    int force; 
    int mana;
    double portee; //utilisé pour "coefdist" dans actions.arc Plus la valeur est grande plus la répartition est homogène.
    boolean dispo;
    
    Personnage perso;
    public Objets (int a, int b, int c, int d, int e, int f){
        this.dispo = true;
    	this.armure=a;
        this.soin=b;
        this.quantite=c;
        this.prix=d;
        this.force=e;
        this.mana=f;
        this.portee= 1.2;
    }
    public void augmenteresistance (Personnage perso){
        perso.setResistance(perso.getResistance()+armure);
    }
    public void soigne(Personnage perso){
        int[] heal = {this.soin, 3}; //donne "soin" pv pour les 3 prochains tours
    	perso.setEvo(heal); 
    }
    public void augmentedegats (Personnage perso){
        perso.setForce(perso.getForce()+this.force);
    }
    public void ChargeMana (Personnage perso) {
    	perso.setMana(perso.getMana()+this.mana);
    }
    public void use(Personnage perso) {
        this.augmentedegats(perso);
        this.augmenteresistance(perso);
        this.soigne(perso);
        this.ChargeMana(perso);
        this.quantite--;
    }

}
