package Champion;
public class Objets {
    int armure;//quantité de résistance apportée par l’objet
    int soin;//quantité de soin de l’objet
    int quantite;//quantite de l’objet
    int prix;//prix de l’objet
    int force;//force ajoutée par l’objet
    int mana;//mana ajouté par l’objet
    double portee;//utilisé pour "coefdist" dans actions.arc Plus la valeur est grande plus la répartition est homogène.
    boolean dispo;//? ? ? disponibilité de l’objet pour l’utilisation ? ? ?
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
    //apporte + de resistance au personnage
    public void augmenteresistance (Personnage perso){
        perso.setResistance(perso.getResistance()+armure);
    }
    //rend des PV pendant 3 tours
    public void soigne(Personnage perso){
        int[] heal = {this.soin, 3}; //donne "soin" pv pour les 3 prochains tours
    	perso.setEvo(heal); 
    }
    //apporte + de force au personnage
    public void augmentedegats (Personnage perso){
        perso.setForce(perso.getForce()+this.force);
    }
    //rend du mana
    public void ChargeMana (Personnage perso) {
    	perso.setMana(perso.getMana()+this.mana);
    }
    //apporte les modifications de l’objet au personnage
    public void use(Personnage perso) {
        this.augmentedegats(perso);
        this.augmenteresistance(perso);
        this.soigne(perso);
        this.ChargeMana(perso);
        this.quantite--;
    }
}
