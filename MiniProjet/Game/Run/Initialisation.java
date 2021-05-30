package Run;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import Affichage.RefreshAff;
import Champion.Personnage;
import World.Jeu;	
public class Initialisation {
	public Initialisation() {	
		//Timer loop= new Timer();
		//TimerTask Refresh = new RefreshAff(map);
		//loop.scheduleAtFixedRate(Refresh, 0, 300 );
	}
	//Permet d’initialiser les statistiques du personnage en début de partie
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
	
	
	
	
	
	
	
	//Permet l’affichage des classes (pour InitPerso)
	public static void AfficherLesClasses (){ //methode pour afficher les choix d'ordres
		System.out.println("Voici les classes disponibles, avec leurs caracteristiques.");
		System.out.println();
		System.out.println("1= Archer (+10 agilite; -10 en sagesse; -10 force; -5 resistance)");
		System.out.println("2= Assassin (+10 dexterite; -5 sagesse; -5 force; -5 resistance)");
		System.out.println("3= Guerrier (+10 force, +5 resistance; -10 sagesse; -10 agilité)");
		System.out.println("4= Mage (+10 sagesse; -10 force; -10 agilité; -10 resistance)");
		System.out.println();
	}
	
	//Permet d’afficher les statistiques du personnages courant
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
	//Permet de faire apparaître le personnage dans une zone aléatoire sur la table de jeu. 
	//tempx et tempy désignent l’emplacement de l’autre personnage (si existant) pour éviter d’apparaître sur la même case 
	//(possibilité d’utiliser cette méthode pour un téléporteur ?
	public void Spawn (int tempx, int tempy,Personnage perso, Jeu map ){
		int x=0;
		int y=0;
		do{
			x = (int) (map.getPlateau().length*Math.random());
			y = (int) (map.getPlateau()[0].length*Math.random());
		}while(map.getPlateau()[x][y][2]!=0 || map.getPlateau()[x][y][0]!=0);
		perso.getPosition()[0]=perso.getPosition()[0]+x;
		perso.getPosition()[1]=perso.getPosition()[1]+y;
	}
}
