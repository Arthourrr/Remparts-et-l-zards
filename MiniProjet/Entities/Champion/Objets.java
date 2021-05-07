package Champion;
public class Objets {
    int armure;
    int soin;
    int quantite;
    int prix;
    int force; 
    
    Personnage perso;
    public Objets (int a, int b, int c, int d, int e){
        this.armure=a;
        this.soin=b;
        this.quantite=c;
        this.prix=d;
        this.force=e;
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
    public void use(Personnage perso) {
        this.augmentedegats(perso);
        this.augmentedegats(perso);
        this.soigne(perso);
    }
}
