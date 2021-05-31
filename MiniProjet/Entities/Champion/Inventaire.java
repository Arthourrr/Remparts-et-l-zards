package Champion;
public class Inventaire {
    Objets potionSoin;
    Objets potionMana;
    Objets armure;
    Objets epee;
    Objets arc;
    Objets bisoumagique;
    Objets amulette;
    
    
    public Inventaire() {
    	/* Parametres:
        0 armure
        1 soin
        2 quantite
        3 prix
        4 force */
        this.potionSoin= new Objets (0, 5, 0, 20, 0, 0);
        this.potionMana = new Objets (0, 0, 0, 20, 0, 20);
        this.armure= new Objets (5, 0, 0, 50, 0, 0);
        this.epee= new Objets (0, 0, 0, 50, 4, 0);
        this.bisoumagique = new Objets (0, 9, 0, 10, 0, 0);
        this.amulette = new Objets (0, 0, 0, 10, 0, 0);
        this.arc = new Objets (0, 0, 0, 60, 0, 0);
    }
    public String AfficheInv () {
    	String contenu= new String();
    	if(this.potionSoin.quantite==0 && this.armure.quantite==0 && this.epee.quantite==0 && this.bisoumagique.quantite==0 && this.amulette.quantite==0 && this.arc.quantite==0) {
    		contenu = "Votre inventaire est vide...";
    	}else {
    	contenu = "Votre sac contient:\n";
    	contenu = (this.potionSoin.quantite == 0)? contenu : 
    		(this.potionSoin.quantite==1)? contenu + "- "+ this.potionSoin.quantite+ " potion de soin \n":
    		(this.potionSoin.quantite>1)? contenu + "- "+ this.potionSoin.quantite+ " potions de soin \n": 
    		contenu;
    	contenu = (this.potionMana.quantite == 0)? contenu : 
    		(this.potionMana.quantite==1)? contenu + "- "+ this.potionMana.quantite+ " potion de mana \n":
    		(this.potionMana.quantite>1)? contenu + "- "+ this.potionMana.quantite+ " potions de mana \n": 
    		contenu;
    	contenu = (this.bisoumagique.quantite == 0)? contenu : 
    		(this.bisoumagique.quantite==1)? contenu + "- "+ this.bisoumagique.quantite+ " bisoumagique\n":
    		(this.bisoumagique.quantite>1)? contenu + "- "+ this.bisoumagique.quantite+ " bisoumagiques \n": 
    		contenu;
    	contenu = (this.arc.quantite != 0)? contenu+ "- L'arc du feu de Dieu" : contenu;
    	contenu = (this.armure.quantite != 0)? contenu+ "- L'armure des tenebres" : contenu;
    	contenu = (this.epee.quantite != 0)? contenu+ "- L'epee Kipik" : contenu;
    	contenu = (this.amulette.quantite == 0)? contenu : 
    		(this.amulette.quantite==1)? contenu + "- "+ this.amulette.quantite+ " amulette \n":
    		(this.amulette.quantite>1)? contenu + "- "+ this.amulette.quantite+ " amulettes \n": 
    		contenu;
    	}
    	return contenu;
    	
    }
} 