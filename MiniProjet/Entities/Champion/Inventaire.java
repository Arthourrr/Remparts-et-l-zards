package Champion;
public class Inventaire {
    Objets potion;
    Objets armure;
    Objets epee;
    Objets arc;
    Objets bisoumagique;
    
    
    public Inventaire() {
    	/* Paramètres:
        0 armure
        1 soin
        2 quantite
        3 prix
        4 force */
        this.potion= new Objets (0, 5, 0, 20, 0);
        this.armure= new Objets (5, 0, 0, 50, 0);
        this.epee= new Objets (0, 0, 0, 50, 4);
        this.bisoumagique = new Objets (0, 10, 0, 10, 0);
    }
} 