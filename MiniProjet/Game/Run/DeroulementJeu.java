package Run;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import Affichage.RefreshAff;
import Champion.Personnage;
import World.Jeu;
public class DeroulementJeu {
	public static Personnage P1 = new Personnage(0);
	public static Personnage P2 = new Personnage(0);
	static int[][][]carte = new int[5][5][4];
	public static Timer loop= new Timer();
	public static TimerTask Refresh = new RefreshAff(carte);
	public DeroulementJeu() {	
	
	}
//Fait tourner la partie tant que aucun personnage n'est mort
//Compteur base sur pair/impair
//Affiche le gagnant Ã  la fin
	public static void DeroulementPartie(Personnage p1 , Personnage p2, Jeu tabledejeu){
		for(int i=0; i<tabledejeu.getPlateau().length; i++) {
			for(int j=0; j<tabledejeu.getPlateau()[0].length; j++) {
				for(int k=0; k<tabledejeu.getPlateau()[0][0].length; k++) {
					carte[i][j][k]=tabledejeu.getPlateau()[i][j][k];
				}
			}
		}		
		loop.scheduleAtFixedRate(Refresh, 0, 300 );
		int compteur=1;
        Fini fin = new Fini(p1, p2, tabledejeu.getPlateau());
        fin.start();
        while (true){
        	P1=p1;
        	P2=p2;
            if (compteur%2!=0){
				Tour(p1,p2,tabledejeu, compteur);
                compteur++;
            }else{
				Tour(p2,p1,tabledejeu, compteur);
                compteur++;
            }
            tabledejeu.SpawnGoldRegulier();
            //tabledejeu.RandomGoldSpawn();
            tabledejeu.fissures(compteur);
        }
        //Gagnant(compteur, p1, p2);
    }
//Mise à jour de la position du personnage vers un point de coordonnées X,Y 
 	public static void Move (Personnage perso, Jeu tabledejeu, int X, int Y){
		perso.MajPosition(X,Y);
		tabledejeu.DeplacePion(X,Y,perso);
	}
//Interface permettant d’activer chaque action possible par tour pour un personnage dans les objets correspondants
    public static void Tour(Personnage persoA, Personnage persoB, Jeu tabledejeu, int compteur){
    		//Auto-refresh de l'Affichage 
    	
    	for(int i=0; i<tabledejeu.getPlateau().length; i++) {
			for(int j=0; j<tabledejeu.getPlateau()[0].length; j++) {
				for(int k=0; k<tabledejeu.getPlateau()[0][0].length; k++) {
					carte[i][j][k]=tabledejeu.getPlateau()[i][j][k];
				}
			}
		}
    	int fight=1;
		System.out.print(tabledejeu.AffichePlateau());
		Display(0);
		Display(persoA.getNom() +" a ton tour !");
		System.out.println(persoA.getNom() +" à ton tour !");
		persoA.MajStats();
		while (persoA.getPa()>0){
			for(int i=0; i<tabledejeu.getPlateau().length; i++) { // synchronise la map d'affichage avec la map de la méthode.
				for(int j=0; j<tabledejeu.getPlateau()[0].length; j++) {
					for(int k=0; k<tabledejeu.getPlateau()[0][0].length; k++) {
						carte[i][j][k]=tabledejeu.getPlateau()[i][j][k];
					}
				}
			}
		Display(0);
		Display(persoA.AffichePerso());
		Display(persoA.getNom()+", que choisis-tu de faire ?");
		int[] mouvement;
			if(fight!=0 && persoA.getPa()>=2){
				Display("1 = Objets, Entraînement \t 2 = Déplacement \t 3 = Fin du tour\t 4 = Combat \t0 = Infos");
				Scanner n = new Scanner(System.in); 
				final int numero = n.nextInt();
				switch(numero){
					case 0 :
						Aide(persoA);
						pause(4000);
						break;
					case 1 :
						Display("1 = Améliorer la force \t 2 = Marché  \t 3 = Utiliser un objet \n 0 = retour");
						Scanner b = new Scanner(System.in); 
						final int numeroter = b.nextInt();
						
						persoA.getPlay().choixAction(numero, numeroter, persoA, persoB, compteur, tabledejeu.getPlateau());
						pause(1200);
						break;
					case 2 :
						mouvement = Mouvement(persoA,tabledejeu);
						if(mouvement[2]!=0){
							Move(persoA,tabledejeu,mouvement[0],mouvement[1]);
							persoA.setPa(persoA.getPa() - 1);
							System.out.print(tabledejeu.AffichePlateau());
							//Affichage.afficherMonde(tabledejeu.getPlateau());
							break;
						}else{
							Display("\n\nAction Impossible\n\n");
							break;
						}						
					case 3 :
						persoA.setPa(0);
						break;
					case 4 :
						Display("1 = Epée \t 2 = Arc \t 3 = Sort"); // /!\methodes manquantes
						Scanner a = new Scanner(System.in); 
						final int numerobis = a.nextInt();
						persoA.getPlay().choixAction(numero, numerobis, persoA, persoB, compteur, tabledejeu.getPlateau()); //numero= categorie d'action, numerobis= sous-categorie.
						pause(1200);
						break;						
				}
			}else{
				Display("1 = Objets, Entraînements \t 2 = Déplacement\t 3 = Fin du tour \t0 = Infos");
				Scanner n = new Scanner(System.in); 
				final int numero = n.nextInt();
				switch(numero){
					case 1 :
						Display("1 = Améliorer la force  \t 2 = Marché \t 3 = Utiliser un objet \\n 0 = retour"); // /!\methodes manquantes
						Scanner b = new Scanner(System.in); 
						final int numeroter = b.nextInt();
						persoA.getPlay().choixAction(numero, numeroter, persoA, persoB, compteur, tabledejeu.getPlateau());
						pause(1200);
						break;
					case 2 :
						mouvement = Mouvement(persoA,tabledejeu);
						if(mouvement[2]!=0){
							Move(persoA,tabledejeu,mouvement[0],mouvement[1]);
							persoA.setPa(persoA.getPa() - 1);
							System.out.print(tabledejeu.AffichePlateau());
							break;
						}else{
							Display("Action Impossible");
							break;
						}
					case 3 :
						persoA.setPa(0);
						break;
					case 0 :
						Aide(persoA);
						pause(5000);
						break;
				}
			}
		}
		pause(3000);
		persoA.setPa(3);
	}
//Permet l’action "mouvement de personnage" (à bouger dans actions ? ? ?)
	public static int[] Mouvement (Personnage perso, Jeu tabledejeu){
		int[] mouvement = new int[3];
		mouvement[2]=0;
		Display("Gauche (4), droite (6), haut(8), bas(2)");
        Scanner n = new Scanner(System.in); 
        int numero = n.nextInt();
        int persval;
        int mapval;
        int effectval;
			switch(numero){
				case 8 : //déplacement vers le haut
					if(perso.getPosition()[0]!=0){
						mapval= tabledejeu.getPlateau()[perso.getPosition()[0]-1][perso.getPosition()[1]][0];
						effectval= tabledejeu.getPlateau()[perso.getPosition()[0]-1][perso.getPosition()[1]][1];
						persval= tabledejeu.getPlateau()[perso.getPosition()[0]-1][perso.getPosition()[1]][2];
						if(persval>=0 && mapval != (-3) && mapval!= -4){
							perso.setPo(perso.getPo()+persval);
							Display((!(persval == 0))? "Vous ramassez "+persval+" pièces d'or!" : "");
							mouvement[0]=-1;
							mouvement[2]=1;
							pause ( (!(persval == 0))? 1200 : 0);
						}
					}
					break;
				case 2 : // bas
					if(perso.getPosition()[0]!=tabledejeu.getPlateau().length-1){
						mapval=tabledejeu.getPlateau()[perso.getPosition()[0]+1][perso.getPosition()[1]][0];
						effectval= tabledejeu.getPlateau()[perso.getPosition()[0]+1][perso.getPosition()[1]][1];
						persval= tabledejeu.getPlateau()[perso.getPosition()[0]+1][perso.getPosition()[1]][2];
						if(persval>=0 && mapval != (-3) && mapval!= -4){
							perso.setPo(perso.getPo()+persval);
							Display((!(persval == 0))? "Vous ramassez "+persval+" pièces d'or!" : "");
							mouvement[0]=1;
							mouvement[2]=1;
							pause ( (!(persval == 0))? 1200 : 0);
						}
					}					
					break;
				case 4 : // gauche
					if(perso.getPosition()[1]!=0){
						mapval=tabledejeu.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]-1][0];
						effectval= tabledejeu.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]-1][1];
						persval= tabledejeu.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]-1][2];
						if(persval>=0 && mapval != (-3) && mapval!= -4){
							perso.setPo(perso.getPo()+persval);
							Display((!(persval == 0))? "Vous ramassez "+persval+" pièces d'or!" : "");
							mouvement[1]=-1;
							mouvement[2]=1;
							pause ( (!(persval == 0))? 1200 : 0);
						}
					}
					break;
				case 6 : // droite
					if(perso.getPosition()[1]!=tabledejeu.getPlateau()[0].length-1){
						mapval=tabledejeu.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]+1][0];
						effectval= tabledejeu.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]+1][1];
						persval= tabledejeu.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]+1][2];
						if(persval>=0 && mapval != (-3) && mapval!= -4){
							perso.setPo(perso.getPo()+persval);
							Display((!(persval == 0))? "Vous ramassez "+persval+" pièces d'or!" : "");
							mouvement[1]=1;
							mouvement[2]=1;
							pause ( (!(persval == 0))? 1200 : 0);
						}
					}
					break;
					
					/* "position": int[][], position[0]= position en ordonnée, position[1]= position en abscisse*/
			}
			return mouvement;
	}
//Vérifie si un personnage est mort
    public static boolean Fini (Personnage perso1, Personnage perso2) { 
        boolean mort=false;
        if (perso1.getPv()<=0||perso2.getPv()<=0){
            mort=true;
        }
        return mort;
    }	
//Affiche la fin de partie et le gagnant /!\ to fix
    public static void Gagnant(int compteur,Personnage perso1, Personnage perso2){
        System.out.println("Le combat est terminé.");
        if (perso1.getPv()>0){
            System.out.println(perso1.getNom()+" a gagné ! Par le sang ou les flammes, tu as su vaincre ton adversaire. Le public t'acclame, et sous les cris de tes admirateurs en furie, dignement, tu t'en vas face au soleil couchant.");
        }else if(perso2.getPv()>0){
            System.out.println(perso2.getNom()+" a gagné ! Par le sang ou les flammes, tu as su vaincre ton adversaire. Le public t'acclame, et sous les cris de tes admirateurs en furie, dignement, tu t'en vas face au soleil couchant.");
        }
    }
 //Affichage des aides pendant une partie
    public static void Aide(Personnage p1) {
    	Display("1 : Mon inventaire\t 2 : Mes stats\t 3 : Objets ?\t 4 : Attaques ?");
    	Scanner sc = new Scanner(System.in); 
    	int a = sc.nextInt();
    	switch (a) {
    	case 1:
    		Display(p1.getStuff().AfficheInv());
    		break;
    	case 2:
    		Display(p1.AfficheStats());
    		
    	break;
    	case 3:
    		Display("Vous pouvez acheter les objets au marché contre des pièces d'or.\n Voici les objets existants:");
    		Display("-Potion de soin: régénère 5 PV par tour pendant 3 tours.");
    		Display("-Bisoumagique: vous soigne instantanément de 9 PV");
    		Display("-Epée Kipik: augmente votre force de 4");
    		Display("-Armure des ténèbres: augmente votre résistance de 5");
    		Display("-Arc du feu de Dieu: vous permet d'être précis à toute distance et augmente votre agilité de 3.");
    		Display("-Amulette: lève tous les sorts et effets qui vous affectent. Attention, annule aussi les soins!");
    		break;
    	case 4:
    		Display("-Attaque à l'épée: réservée au corps à corps. Dégats dépendant de la force de votre personnage.\n Attention, vous pouvez subir des dégâts en cas d'échec.");
    		Display("-Attaque à l'arc: dégats aléatoires dépendant de votre agilité et de la distance de tir. La portée optimale de base est de 3 cases.");
    		Display("-Sortilège: dégats magiques sur plusieurs tours (dégénérescence) ou lancer de boule de feu, essentiellement améliorés par la sagesse.");
    		Display("\nVous infligerez parfois des coups critiques. Les dégats sont alors démultipliés.");
    		break;
    	}
    }
    public static void Display(String sentence) { //Afficher "sentence"
		int lg=61;
		int quotient = sentence.length()/lg;
		int reste = sentence.length()%lg;
		for (int i=0; i<quotient*lg; i=i+lg) {
			((RefreshAff) DeroulementJeu.Refresh).run(sentence.substring(i, i+lg));
		}
		if (reste!=0) {
			((RefreshAff) DeroulementJeu.Refresh).run(sentence.substring(quotient*lg, quotient*lg +reste));
		}
    	
    }
	public static void Display(int a) { //effacer la console
    	((RefreshAff) DeroulementJeu.Refresh).run(a);
    }
    public static void pause(long lag) {
    	try {
			Thread.sleep(lag);
		} catch (InterruptedException e) {
		}
    }
}
