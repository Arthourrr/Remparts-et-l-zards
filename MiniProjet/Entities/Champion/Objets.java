package Champion;
public class Objets {
    int armure;
    int soin;
    int quantite;
    int prix;
    
    Personnage perso;
    public Objets (int a, int b, int c, int d){
        this.armure=a;
        this.soin=b;
        this.quantite=c;
        this.prix=d;
    }
    public void augmenteresistance (Personnage perso){
        perso.setResistance(perso.getResistance()+armure);
        
    }
    public void soigne(Personnage perso){
        perso.setPv(perso.getPv()+soin);
    }
    public void augmentedegats (Personnage perso){
        
    }
    public void use(Personnage perso) {
        this.augmentedegats(perso);
        this.augmentedegats(perso);
        this.soigne(perso);
    }
}
