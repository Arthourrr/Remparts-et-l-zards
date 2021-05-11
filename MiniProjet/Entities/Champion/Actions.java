package Champion;
import java.util.Scanner;
public class Actions{	

	public Actions() {
		
	}
	
	
	public void choixAction (int a, int b, Personnage p1, Personnage p2, int count) { 
		
		switch(a){
		case 4 :	
			switch(b) {
			case 1:
				p1.getPlay().melee(p1,p2);
				break;
			case 2 :
				p1.getPlay().arc(p1,p2);
				break;
			case 3 :
				p1.getPlay().sort(p1, p2);
				break;
			}
			break;
		case 1 :
			switch(b) {
			case 1: 
				p1.getPlay().trainForce(p1);
				break;
			case 2:
				System.out.println("Bienvenue au marché. Voici les articles disponibles:");
	            System.out.println("1 = Arc du feu de Dieu ("+p1.getStuff().arc.prix +"po) \t 2 = Armure des tenebres ("+p1.getStuff().armure.prix +"po) \t 3 = Epee Kipik ("+p1.getStuff().epee.prix +"po)\t 4= Potion de soin ("+p1.getStuff().potionSoin.prix +"po) \t 5= Amulette ("+p1.getStuff().amulette.prix +"po) \t 6= Bisoumagique ("+p1.getStuff().bisoumagique.prix +"po) \t 7 = Potion de Mana ("+p1.getStuff().potionMana.prix +"po)");
	            System.out.println("Vous possédez "+p1.getPo()+" pièces d'or.");
	            Scanner d = new Scanner(System.in); 
	            final int c = d.nextInt();
			    p1.getPlay().acheter(p1, c);
			break;
			
			case 3 :
				if(p1.getStuff().potionMana.quantite==0 && p1.getStuff().potionSoin.quantite==0 && p1.getStuff().armure.quantite==0 && p1.getStuff().epee.quantite==0 && p1.getStuff().bisoumagique.quantite==0 && p1.getStuff().amulette.quantite==0 && p1.getStuff().arc.quantite==0) {
		    		System.out.println("Vous ne possédez aucun objet. Rendez vous au marché pour vous en procurer.");
				} else {
				System.out.println("Vous disposez des objets suivants. Lequel souhaitez vous utiliser?");
				String contenu = new String();
				contenu = (p1.getStuff().amulette.quantite>0)? contenu+ "- 1: Amulette enchantée" : contenu;
				contenu = (p1.getStuff().potionSoin.quantite>0)? contenu+ "- 2: Potion de soin" : contenu;
				contenu = (p1.getStuff().bisoumagique.quantite>0)? contenu+ "- 3: Bisou magique" : contenu; 
				contenu = (p1.getStuff().potionMana.quantite>0)? contenu+ "- 4: Potion de mana" : contenu;
	            System.out.println(contenu);
				Scanner e = new Scanner(System.in); 
	            final int choix = e.nextInt();
				p1.getPlay().utiliser(p1, choix);
				}
			}
		}
	}
	
	public void melee(Personnage p1, Personnage p2) {
		if (p1.distance(p2)<2&& p1.getPa()>=2) { //Conditions de distance et PA
			p1.setPa(p1.getPa()-2);
			int degats= (int)(2*Math.random()*p1.getForce()); // Degats aleatoires, proportionnels a la force
			if (degats<7) { //En dessous de 5, l'attaque echoue et les degats se retournent vers l'attaquant.
				p1.setPv(p1.getPv()-degats);
				System.out.println("L'attaque echoue. Vous perdez "+ degats+" points de vie.");
			}else {
				int tmp= degats;
				if (degats>0.5*p2.getResistance()) {
					degats= (int)(degats-0.5*p2.getResistance());
				}else {
					degats=0;
					}
				double critique= Math.random();
				if(critique<(p1.getDexterite()/100)) { //Maxi 20% de chances de faire un coup critique, depend de la dexterite
					degats = degats + tmp;
					p2.setPv((int)(p2.getPv()-degats));
					System.out.println("Coup critique! Vous infligez "+ degats+" degats a l'adversaire.");
					}
				else {p2.setPv((int)(p2.getPv()-degats));}//La resistance absorbe une partie des degats.
				System.out.println("L'attaque a reussi. Vous infligez "+ degats+" degats a l'adversaire.");
			}
		}else {
			System.out.println("Bien essayé petit malin... Vous ne pouvez pas attaquer à distance avec une épée!");
		}
	}
	
	
	public void arc(Personnage p1, Personnage p2) {
		if (p1.getPa()>=2) {
			p1.setPa(p1.getPa()-2); // PA consommes
			double coefdist= Math.exp(-(Math.pow(p1.distance(p2)-3,2)/p1.getStuff().arc.portee)); //dagats max pour une distance de 4, repartitionn gaussienne
			int degats= (int)(2*Math.random()*p1.getAgilite()*coefdist);		// Degats aleatoires, proportionnels a l'agilite
			int tmp= degats;
			if (degats>0.5*p2.getResistance()) {
				degats= (int)(degats-0.5*p2.getResistance());
			}else {
				degats=0;
				}
			double critique= Math.random();
			
			if(critique<(p1.getDexterite()/100)) {
				degats= degats+tmp;
				p2.setPv((int)(p2.getPv()-degats));
				System.out.println("Coup critique! Vous infligez "+ degats+" degats a l'adversaire.");
				}
			else {
				p2.setPv((int)(p2.getPv()-degats));
				System.out.println("L'attaque a reussi. Vous infligez "+ degats+" degats a l'adversaire.");
				}
		}
	}
	public void sort (Personnage p1, Personnage p2) {
		if(p1.getPa()>=2 && p1.getMana()>=20) {
			p1.setPa(p1.getPa()-2);
			p1.setMana(p1.getMana()-20);
			int duree;
			int degats= (int)(1.5*Math.random()*p1.getDexterite());
			if (degats>(0.5*p2.getResistance())) {
				degats= (int)(degats-0.5*p2.getResistance());
			}else {
				degats=1;
				}
			if(p1.getSagesse()<10) {
				duree=1;
			}else if(p1.getSagesse()<14) {
				duree=2;
			}else if(p1.getSagesse()<17){
				duree=3;
			}else {
				duree=4;
			}
			System.out.println("L'ennemi est ensorcelé! Vous lui infligez "+degats+ " degats pendant "+ duree+ " tours.");
			int[] effet = {-degats, duree};
			p2.setEvo(effet);
		}
	}
	public void trainForce (Personnage p1) {
		if(p1.getPa()>=1) {
			p1.setForce(p1.getForce() + 1);
			p1.setPa(p1.getPa()-2);
			System.out.println("Vos efforts acharnés portent leurs fruits. Vous gagnez +1 de force!");
			System.out.println(p1.AfficheStats());
		}
	}	
	public void acheter (Personnage p1, int a) {
        switch (a) {
        case (1):
            if (p1.getStuff().arc.dispo && p1.getPo()>p1.getStuff().arc.prix) {
            p1.getStuff().arc.quantite ++;
            p1.setPo(p1.getPo()-p1.getStuff().arc.prix);
            p1.setPa(p1.getPa() - 1);
            p1.getStuff().arc.portee= 3;
            p1.setAgilite(p1.getAgilite()+3);
            p1.getStuff().arc.dispo= false;
            break;
            }
        case(2):
        	if (p1.getStuff().armure.dispo && p1.getPo()>p1.getStuff().armure.prix) {
            p1.getStuff().armure.quantite++;
            p1.setPo(p1.getPo() - p1.getStuff().armure.prix);
            p1.setPa(p1.getPa() - 1);
            p1.getStuff().armure.augmenteresistance(p1);
        	p1.getStuff().armure.dispo= false;
        	break;
        	}
        case(3):
            if (p1.getStuff().epee.dispo && p1.getPo()>p1.getStuff().epee.prix) {
            p1.getStuff().epee.quantite++;
            p1.setPo(p1.getPo() - p1.getStuff().epee.prix);
            p1.setPa(p1.getPa() - 1);
            p1.getStuff().epee.use(p1);
            p1.getStuff().epee.dispo=false;
            break;
            }
        case(4):
        	if(p1.getStuff().potionSoin.dispo && p1.getPo()>p1.getStuff().potionSoin.prix) {
            p1.getStuff().potionSoin.quantite++;
            p1.setPo(p1.getPo() - p1.getStuff().potionSoin.prix);
            p1.setPa(p1.getPa() - 1);
            break;
        	}
        case(6):
        	if(p1.getStuff().bisoumagique.dispo && p1.getPo()>p1.getStuff().bisoumagique.prix) {
        	p1.getStuff().bisoumagique.quantite++;
        	p1.setPo(p1.getPo() - p1.getStuff().bisoumagique.prix);
        	p1.setPa(p1.getPa() - 1);
        	break;
        	}
        case (5):
        	if(p1.getStuff().amulette.dispo && p1.getPo()>p1.getStuff().amulette.prix){
        		p1.getStuff().amulette.quantite++;
        		p1.setPo(p1.getPo() - p1.getStuff().amulette.prix);
            	p1.setPa(p1.getPa() - 1);
        	break;
           	}
        case (7):
        	if(p1.getStuff().potionMana.dispo && p1.getPo()>p1.getStuff().potionMana.prix) {
                p1.getStuff().potionMana.quantite++;
                p1.setPo(p1.getPo() - p1.getStuff().potionMana.prix);
                p1.setPa(p1.getPa() - 1);
                break;
            	}        	
        }
    }
    public void utiliser (Personnage p1, int a) {
        switch (a) {
        case(2):
            if(p1.getStuff().potionSoin.quantite>0) {
            p1.getStuff().potionSoin.use(p1);
            break;
            }
        case 3:
        	 if(p1.getStuff().bisoumagique.quantite>0) {
             p1.setPv(p1.getPv()+p1.getStuff().bisoumagique.soin);
             p1.getStuff().bisoumagique.quantite--;
             break;
            }
        case(4):
            if(p1.getStuff().potionMana.quantite>0) {
            p1.getStuff().potionMana.use(p1);
            break;
            }        	 
        case 1:
        	if(p1.getStuff().amulette.quantite>0) {
        		p1.getStuff().amulette.quantite--;
        		int[] tmp = {0, 0};
        		p1.setEvo(tmp);
        		System.out.println("Les sortilèges ont été levés.");
        	}
        }
    }
	/*Jeu TableDeJeu = new Jeu(); // renvoie Ã  une methode de deplacement pour y acceder depuis perso.play
	public static void Move (Personnage p1, Jeu TableDeJeu, int X, int Y){
		p1.MajPosition(X,Y);
		TableDeJeu.DeplacePion(X,Y,perso);
	}*/
}
