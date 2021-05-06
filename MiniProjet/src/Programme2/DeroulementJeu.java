package Programme2;
import java.util.Scanner;
public class DeroulementJeu {
	public DeroulementJeu() {	
	
	}
//Fait tourner la partie tant que aucun personnage n’est mort
//Compteur base sur pair/impair
//Affiche le gagnant à la fin
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
            
        }
        Gagnant(compteur, perso1, perso2);
    }
//Met à jour la position de l’objet personnage
//Deplace le pion sur le plateau   
 	public static void Move (Personnage perso, Jeu tabledejeu, int X, int Y){
		perso.MajPosition(X,Y);
		tabledejeu.DeplacePion(X,Y,perso);
	}
//Permet de choisir :
//D’attaquer
//D’utiliser un objet (boutique à implementer)
//De se deplacer
//Utilisation de switch pour les cas
//Utilisation de PA
//Boucle while tant que le perso a des PA
    public static void Tour(Personnage persoA, Personnage persoB, Jeu tabledejeu, int compteur){
		int fight=1;
		System.out.print(tabledejeu.AffichePlateau());
		System.out.println(persoA.nom +" c'est a� toi !");
		while (persoA.pa>0){
		System.out.println(persoA.AffichePerso());
		System.out.println("Que choisis-tu de faire ? ");
		int[] mouvement;
			if(fight!=0 && persoA.pa>=2){
				System.out.println("1= Utiliser un objet \t 2=Me deplacer \t 3=Ne rien faire\t 4=Combattre");
				Scanner n = new Scanner(System.in); 
				final int numero = n.nextInt();
				switch(numero){

					case 1 :
						System.out.println("1 = Force \t 2 = Acheter Objet  \t 3 = Objet 3"); // /!\methodes manquantes
						Scanner b = new Scanner(System.in); 
						final int numeroter = b.nextInt();
						
						persoA.play.choixAction(numero, numeroter, persoA, persoB, compteur);
						
						break;
					case 2 :
						mouvement = Mouvement(persoA,tabledejeu);
						if(mouvement[2]!=0){
							Move(persoA,tabledejeu,mouvement[0],mouvement[1]);
							persoA.pa--;
							System.out.print(tabledejeu.AffichePlateau());
							break;
						}else{
							System.out.println("Action Impossible");
							break;
						}						
					case 3 :
						persoA.pa=0;
					case 4 :
						System.out.println("1 = Epee \t 2 = Arc \t 3 = Sort"); // /!\methodes manquantes
						Scanner a = new Scanner(System.in); 
						final int numerobis = a.nextInt();
						persoA.play.choixAction(numero, numerobis, persoA, persoB, compteur); //numero= categorie d'action, numerobis= sous-categorie.
						break;						
				}
			}else{
				System.out.println("1=Utiliser un objet \t 2=me deplacer\t 3=Ne rien faire");
				Scanner n = new Scanner(System.in); 
				final int numero = n.nextInt();
				switch(numero){
					case 1 :
						System.out.println("1 = Force \t 2 = Objet 2 \t 3 = Objet 3"); // /!\methodes manquantes
						Scanner b = new Scanner(System.in); 
						final int numeroter = b.nextInt();
						persoA.play.choixAction(numero, numeroter, persoA, persoB, compteur);
						break;
					case 2 :
						mouvement = Mouvement(persoA,tabledejeu);
						if(mouvement[2]!=0){
							Move(persoA,tabledejeu,mouvement[0],mouvement[1]);
							persoA.pa--;
							System.out.print(tabledejeu.AffichePlateau());
							break;
						}else{
							System.out.println("Action Impossible");
							break;
						}
					case 3 :
						persoA.pa=0;
				}
			}
		}
		persoA.pa=3;
		for(int i=0;i<50;i++){
			System.out.println();	
		}	
	}
//Permet de commander les mouvements du personnage sur le plateau
//Utilisation de switch
//Numeros arranges mais on sait pas trop comment ça fonctionne ptdr
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
			switch(numero){
				case 1 :
					if(perso.position[0]!=0){
						if(tabledejeu.Plateau[perso.position[0]-1][perso.position[1]]==0){
							mouvement[0]=-1;
							mouvement[2]=1;
						}
					}
					break;
				case 2 :
					if(perso.position[0]!=tabledejeu.Plateau.length-1){
						if(tabledejeu.Plateau[perso.position[0]+1][perso.position[1]]==0){	
							mouvement[0]=1;
							mouvement[2]=1;
						}
					}					
					break;
				case 3 :
					if(perso.position[1]!=0){
						if(tabledejeu.Plateau[perso.position[0]][perso.position[1]-1]==0){
							mouvement[1]=-1;
							mouvement[2]=1;
						}
					}
					break;
				case 4 :
					if(perso.position[1]!=tabledejeu.Plateau[0].length-1){
						if(tabledejeu.Plateau[perso.position[0]][perso.position[1]+1]==0){
							mouvement[1]=1;
							mouvement[2]=1;
						}
					}
					break;						
			}
			return mouvement;
	}
//methode pour savoir si l'un des 2 joueur est mort
    public static boolean Fini (Personnage perso1, Personnage perso2) { 
        boolean mort=false;
        if (perso1.pv<=0||perso2.pv<=0){
            mort=true;
        }
        return mort;
    }	
//Fin de partie, affiche le gagnant	
    public static void Gagnant(int compteur,Personnage perso1, Personnage perso2){
        System.out.println("La partie est terminee.");
        if (compteur%2==0){
            perso1.po=perso1.po+100;
            System.out.println(perso1.nom+" a gagne ! Tu reçois 100 pièces d'or");
            
        }else{
            System.out.println(perso2.nom+" a gagne ! Tu reçois 100 pièces d'or");
            perso2.po=perso2.po+100;
        }
    }

}
