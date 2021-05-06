package Programme2;
import java.util.Scanner;
public class Test {
	public static void main (String[] arg){
		DeroulementJeu FaisTournerLaPartie = new DeroulementJeu();
		Jeu TableDeJeu = new Jeu();
		System.out.println("Joueur 1 à toi");

		int compteur=1;
		
		Personnage Perso1 = new Personnage(1);
		Perso1.init.InitPerso(Perso1);
		Perso1.init.Spawn(0,0,Perso1);
		TableDeJeu.PosePion(Perso1.position[0],Perso1.position[1],Perso1);//pose le joueur sur un pt du tableau
		compteur++;
		
		System.out.println("Joueur 2 à toi");
		Personnage Perso2 = new Personnage(2);
		Perso2.init.InitPerso(Perso2);
		Perso2.init.Spawn(Perso1.position[0],Perso1.position[1],Perso2);
		TableDeJeu.PosePion(Perso2.position[0],Perso2.position[1],Perso2);//pose le joueur sur un pt du tableau	
		System.out.println("\\\\\\\\\\"+Perso1.nom +"VS"+ Perso2.nom+"/////////");
		DeroulementJeu.DeroulementPartie(Perso1,Perso2,TableDeJeu);
		DeroulementJeu.Gagnant(compteur,Perso1,Perso2);
    }	
}	
