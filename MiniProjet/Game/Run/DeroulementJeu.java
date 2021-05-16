package Run;
import java.util.Scanner;
import Champion.Personnage;
import World.Jeu;
public class DeroulementJeu {
	public DeroulementJeu() {	
	
	}
//Fait tourner la partie tant que aucun personnage n'est mort
//Compteur base sur pair/impair
//Affiche le gagnant Ã  la fin
	public static void DeroulementPartie(Personnage perso1, Personnage perso2, Jeu tabledejeu){
        int compteur=1;
        while (!Fini(perso1,perso2)){
            if (compteur%2!=0){
				Tour(perso1,perso2,tabledejeu, compteur);
                compteur++;
            }else{
				Tour(perso2,perso1,tabledejeu, compteur);
                compteur++;
            }
            tabledejeu.SpawnGoldRegulier();
            tabledejeu.RandomGoldSpawn();
        }
        Gagnant(compteur, perso1, perso2);
    }
//Mise à jour de la position du personnage vers un point de coordonnées X,Y 
 	public static void Move (Personnage perso, Jeu tabledejeu, int X, int Y){
		perso.MajPosition(X,Y);
		tabledejeu.DeplacePion(X,Y,perso);
	}
//Interface permettant d’activer chaque action possible par tour pour un personnage dans les objets correspondants
    public static void Tour(Personnage persoA, Personnage persoB, Jeu tabledejeu, int compteur){
		int fight=1;
		System.out.print(tabledejeu.AffichePlateau());
		Affichage.afficherMonde(tabledejeu.getPlateau());
		System.out.println(persoA.getNom() +" à ton tour !");
		persoA.MajStats();
		while (persoA.getPa()>0){
		System.out.println(persoA.AffichePerso());
		System.out.println("Que choisis-tu de faire ?");
		int[] mouvement;
			if(fight!=0 && persoA.getPa()>=2){
				System.out.println("1 = Objets, Entraînement \t 2 = Déplacement \t 3 = Fin du tour\t 4 = Combat \t0 = Infos");
				Scanner n = new Scanner(System.in); 
				final int numero = n.nextInt();
				switch(numero){
					case 0 :
						Aide(persoA);
						pause(4000);
						break;
					case 1 :
						System.out.println("1 = Améliorer la force \t 2 = Marché  \t 3 = Utiliser un objet \n 0 = retour");
						Scanner b = new Scanner(System.in); 
						final int numeroter = b.nextInt();
						
						persoA.getPlay().choixAction(numero, numeroter, persoA, persoB, compteur);
						pause(1200);
						break;
					case 2 :
						mouvement = Mouvement(persoA,tabledejeu);
						if(mouvement[2]!=0){
							Move(persoA,tabledejeu,mouvement[0],mouvement[1]);
							persoA.setPa(persoA.getPa() - 1);
							System.out.print(tabledejeu.AffichePlateau());
							Affichage.afficherMonde(tabledejeu.getPlateau());
							break;
						}else{
							System.out.println("\n\nAction Impossible\n\n");
							break;
						}						
					case 3 :
						persoA.setPa(0);
						break;
					case 4 :
						System.out.println("1 = Epée \t 2 = Arc \t 3 = Sort"); // /!\methodes manquantes
						Scanner a = new Scanner(System.in); 
						final int numerobis = a.nextInt();
						persoA.getPlay().choixAction(numero, numerobis, persoA, persoB, compteur); //numero= categorie d'action, numerobis= sous-categorie.
						pause(1200);
						break;						
				}
			}else{
				System.out.println("1 = Objets, Entraînements \t 2 = Déplacement\t 3 = Fin du tour \t0 = Infos");
				Scanner n = new Scanner(System.in); 
				final int numero = n.nextInt();
				switch(numero){
					case 1 :
						System.out.println("1 = Améliorer la force  \t 2 = Marché \t 3 = Utiliser un objet \\n 0 = retour"); // /!\methodes manquantes
						Scanner b = new Scanner(System.in); 
						final int numeroter = b.nextInt();
						persoA.getPlay().choixAction(numero, numeroter, persoA, persoB, compteur);
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
							System.out.println("Action Impossible");
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
		System.out.println("Gauche (4), droite (6), haut(8), bas(2)");
        Scanner n = new Scanner(System.in); 
        int numero = n.nextInt();
        if(numero==4){numero=3;}
        if(numero==6){numero=4;}
        if(numero==8){numero=1;}
        if(numero==2){numero=2;}
        int newposval;
			switch(numero){
				case 1 :
					if(perso.getPosition()[0]!=0){
						newposval= tabledejeu.getPlateau()[perso.getPosition()[0]-1][perso.getPosition()[1]];
						if(newposval!= -1 && newposval!= -2 && newposval!=-3){
							perso.setPo(perso.getPo()+newposval);
							System.out.println((!(newposval == 0))? "Vous ramassez "+newposval+" pièces d'or!" : "");
							mouvement[0]=-1;
							mouvement[2]=1;
							pause ( (!(newposval == 0))? 1200 : 0);
						}
					}
					break;
				case 2 :
					if(perso.getPosition()[0]!=tabledejeu.getPlateau().length-1){
						newposval=tabledejeu.getPlateau()[perso.getPosition()[0]+1][perso.getPosition()[1]];
						if(newposval!= -1 && newposval!= -2 && newposval!=-3){
							perso.setPo(perso.getPo()+newposval);
							mouvement[0]=1;
							mouvement[2]=1;
						}
					}					
					break;
				case 3 :
					if(perso.getPosition()[1]!=0){
						newposval=tabledejeu.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]-1];
						if(newposval!= -1 && newposval!= -2 && newposval!=-3){
							perso.setPo(perso.getPo()+newposval);
							mouvement[1]=-1;
							mouvement[2]=1;
						}
					}
					break;
				case 4 :
					if(perso.getPosition()[1]!=tabledejeu.getPlateau()[0].length-1){
						newposval=tabledejeu.getPlateau()[perso.getPosition()[0]][perso.getPosition()[1]+1];	
						if(newposval!= -1 && newposval!= -2 && newposval!=-3){
							perso.setPo(perso.getPo()+newposval);
							mouvement[1]=1;
							mouvement[2]=1;
						}
					}
					break;						
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
        if (compteur%2==0){
            System.out.println(perso1.getNom()+" a gagné ! Par le sang ou les flammes, tu as su vaincre ton adversaire. Le public t'acclame, et sous les cris de tes admirateurs en furie, dignement, tu t'en va face au soleil couchant.");
        }else{
            System.out.println(perso2.getNom()+" a gagné ! Par le sang ou les flammes, tu as su vaincre ton adversaire. Le public t'acclame, et sous les cris de tes admirateurs en furie, dignement, tu t'en va face au soleil couchant.");
        }
    }
 //Affichage des aides pendant une partie
    public static void Aide(Personnage p1) {
    	System.out.println("1 : Mon inventaire\t 2 : Mes stats\t 3 : Objets ?\t 4 : Attaques ?");
    	Scanner sc = new Scanner(System.in); 
    	int a = sc.nextInt();
    	switch (a) {
    	case 1:
    		System.out.println(p1.getStuff().AfficheInv());
    		break;
    	case 2:
    		System.out.println(p1.AfficheStats());
    		
    	break;
    	case 3:
    		System.out.println("Vous pouvez acheter les objets au marché contre des pièces d'or.\n Voici les objets existants:");
    		System.out.println("-Potion de soin: régénère 5 PV par tour pendant 3 tours.");
    		System.out.println("-Bisoumagique: vous soigne instantanément de 9 PV");
    		System.out.println("-Epée Kipik: augmente votre force de 4");
    		System.out.println("-Armure des ténèbres: augmente votre résistance de 5");
    		System.out.println("-Arc du feu de Dieu: vous permet d'être précis à toute distance et augmente votre agilité de 3.");
    		System.out.println("-Amulette: lève tous les sorts et effets qui vous affectent. Attention, annule aussi les soins!");
    		break;
    	case 4:
    		System.out.println("-Attaque à l'épée: réservée au corps à corps. Dégats dépendant de la force de votre personnage.\n Attention, vous pouvez subir des dégâts en cas d'échec.");
    		System.out.println("-Attaque à l'arc: dégats aléatoires dépendant de votre agilité et de la distance de tir. La portée optimale de base est de 3 cases.");
    		System.out.println("-Sortilège: dégats magiques sur plusieurs tours (dégénérescence) ou lancer de boule de feu, essentiellement améliorés par la sagesse.");
    		System.out.println("\nVous infligerez parfois des coups critiques. Les dégats sont alors démultipliés.");
    		break;
    	}
    }
    public static void pause(long lag) {
    	try {
			Thread.sleep(lag);
		} catch (InterruptedException e) {
		}
    }
}
