package Run;
import java.util.Scanner;
import Champion.Personnage;	
public class Initialisation {
	public Initialisation() {	
	
	}
//Initialise le personnage (generation aleatoire, choix d’ordre)
	public static void InitPerso (Personnage perso){
        System.out.print(perso.AfficheStats());
        AfficherLesClasses(); //affiche les diff ordres/ classes dispo
        System.out.print("Choisis ta classe : ");
        Scanner n = new Scanner(System.in); 
        final int numero = n.nextInt();//le joueur saisit le numero de la classe qu'il souhaite
        Scanner clavier= new Scanner(System.in);
        System.out.println("Saisis ton nom :");
        final String nom= clavier.nextLine(); //le joueur saisit son pseudo
        perso.setOrdre(numero);
        perso.SetStatistiques(numero, nom);// met à jour les statistiques du perso en fonction de l'ordre choisi
        System.out.print(perso.AfficheStats());
        System.out.println(); 	
	}

	public static void AfficherLesClasses (){ //methode pour afficher les choix d'ordres
        System.out.println("Voici les classes disponibles, avec leurs caracteristiques.");
        System.out.println();
        System.out.println("1= Archer (+1 en dexterite; +1 en agilite)");
        System.out.println("2= Assassin (+1 agilite, +1 en sagesse)");
        System.out.println("3= Guerrier (+1 en force, +1 en resistance)");
        System.out.println("4= Mage (+2 en dexterite, +3 en sagesse, -3 en resistance)");
        System.out.println();
    }

	public String AfficheStats(Personnage perso){
		String description;
		description = "--------------------------\n";
		description = description+"Bonjour, "+perso.getNom()+"\n";
		description = description+"Ta classe est\t"+perso.getOrdre()+"\n\n";
		description = description+"Tes caracteristiques sont :\n\n";
		description = description+"Agilite :\t"+perso.getAgilite()+"\n";
		description = description+"Dexterite :\t"+perso.getDexterite()+"\n";
		description = description+"Force :\t\t"+perso.getForce()+"\n";
		description = description+"Resistance :\t"+perso.getResistance()+"\n";
		description = description+"Sagesse :\t"+perso.getSagesse()+"\n\n";
		description = description+"--------------------------\n";
		return description;	
	}
	public void Spawn (int tempx, int tempy, Personnage perso){//Fait apparaître les personnages sur le plateau aleatoirement et pas sur la même place
		int x=0;
		int y=0;
		do{	
		x = (int) (4*Math.random());
		y = (int) (4*Math.random());
		}while(x==tempx && y==tempy);
		perso.getPosition()[0]=perso.getPosition()[0]+x;
		perso.getPosition()[1]=perso.getPosition()[1]+y;
	}



}
