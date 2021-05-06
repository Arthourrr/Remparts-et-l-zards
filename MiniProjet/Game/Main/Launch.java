package Main;
import java.util.Scanner;
import Run.DeroulementJeu;
import Run.Initialisation;
import Champion.Personnage;
import World.Jeu;
public class Launch {
	public static void main (String[] arg){
		DeroulementJeu FaisTournerLaPartie = new DeroulementJeu();
		Jeu TableDeJeu = new Jeu();
		System.out.println("Joueur 1 à toi");

		int compteur=1;
		
		Personnage Perso1 = new Personnage(1);
		Perso1.getInit();
		Initialisation.InitPerso(Perso1);
		Perso1.getInit().Spawn(0,0,Perso1);
		TableDeJeu.PosePion(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso1);//pose le joueur sur un pt du tableau
		compteur++;
		
		System.out.println("Joueur 2 à toi");
		Personnage Perso2 = new Personnage(2);
		Perso2.getInit();
		Initialisation.InitPerso(Perso2);
		Perso2.getInit().Spawn(Perso1.getPosition()[0],Perso1.getPosition()[1],Perso2);
		TableDeJeu.PosePion(Perso2.getPosition()[0],Perso2.getPosition()[1],Perso2);//pose le joueur sur un pt du tableau	
		System.out.println("\\\\\\\\\\"+Perso1.getNom() +"VS"+ Perso2.getNom()+"/////////");
		DeroulementJeu.DeroulementPartie(Perso1,Perso2,TableDeJeu);
		DeroulementJeu.Gagnant(compteur,Perso1,Perso2);
    }	
}	
