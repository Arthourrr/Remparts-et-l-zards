package Champion;
import java.util.Scanner;
import java.util.Random;
import Run.AePlayWave;
import Run.DeroulementJeu;
public class Actions{	
	public Actions() {

	}
	//Interface entre le choix d’actions de DeroulementJeu et les lanceurs d’actions de cet objet. Permet de mettre en application ces actions.
	public void choixAction (int a, int b, Personnage p1, Personnage p2, int count, int[][][]carte) { 

		switch(a){
		case 4 :	
			Attaque(b,p1,p2, carte);
			break;
		case 1 :
			switch(b) {
			case 1: 
				p1.getPlay().trainForce(p1);
				break; 
			case 2:
				DeroulementJeu.Display("Bienvenue au marche. Voici les articles disponibles:");
				DeroulementJeu.Display("1 = Arc du feu de Dieu ("+p1.getStuff().arc.prix +"po) \t 2 = Armure des tenebres ("+p1.getStuff().armure.prix +"po) \t 3 = Epee Kipik ("+p1.getStuff().epee.prix +"po)");
				DeroulementJeu.Display("4= Potion de soin ("+p1.getStuff().potionSoin.prix +"po) \t 5= Amulette ("+p1.getStuff().amulette.prix +"po) \t 6= Bisou magique ("+p1.getStuff().bisoumagique.prix +"po)");
				DeroulementJeu.Display("7 = Potion de Mana ("+p1.getStuff().potionMana.prix +"po)");
				DeroulementJeu.Display("Vous possedez "+p1.getPo()+" pieces d'or.");
				Scanner d = new Scanner(System.in); 
				final int c = d.nextInt();
				if(c>0 && c<8) {
				p1.getPlay().acheter(p1, c);
				DeroulementJeu.Display("Objet achete. Allez voir l'inventaire!");
				}
				break;

			case 3 :
				if(p1.getStuff().potionMana.quantite==0 && p1.getStuff().potionSoin.quantite==0 && p1.getStuff().armure.quantite==0 && p1.getStuff().epee.quantite==0 && p1.getStuff().bisoumagique.quantite==0 && p1.getStuff().amulette.quantite==0 && p1.getStuff().arc.quantite==0) {
					DeroulementJeu.Display("Vous ne possedez aucun objet. Rendez vous au marche pour vous en procurer.");
				} else {
					DeroulementJeu.Display("Vous disposez des objets suivants. Lequel souhaitez vous utiliser?");
					String contenu = new String();
					contenu = (p1.getStuff().amulette.quantite>0)? contenu+ "- 1: Amulette enchantee" : contenu;
					contenu = (p1.getStuff().potionSoin.quantite>0)? contenu+ "- 2: Potion de soin" : contenu;
					contenu = (p1.getStuff().bisoumagique.quantite>0)? contenu+ "- 3: Bisou magique" : contenu; 
					contenu = (p1.getStuff().potionMana.quantite>0)? contenu+ "- 4: Potion de mana" : contenu;
					DeroulementJeu.Display(contenu);
					Scanner e = new Scanner(System.in); 
					final int choix = e.nextInt();
					p1.getPlay().utiliser(p1, choix);
					break;
				}
			}
		}
	}
	//Ameliore la force du personnage
	public void trainForce (Personnage p1) {
		if(p1.getPa()>=1) {
			p1.setForce(p1.getForce() + 1);
			p1.setPa(p1.getPa()-2);
			DeroulementJeu.Display("Vos efforts acharnes portent leurs fruits. Vous gagnez +1 de force!");
		}
	}
	//selon un choix fait dans choixAction, permet d’ajouter
	//un objet de la classe objet dans l’inventaire du
	//personnage courant
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
	//Permet d’utiliser un objet consommable dans son
	//inventaire (potions, bisoumagique, amulette)
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
				AePlayWave wololo = new AePlayWave(System.getProperty("user.dir") + "\\Audio\\Wololo_01.wav");
				wololo.start();
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
				p1.getEvo()[0]=0;
				p1.getEvo()[1]=0;
				DeroulementJeu.Display("Les sortileges ont ete leves.");
				break;
			}
		}
	}
	// NOUVELLE MANIERE DE FAIRE DES DEGATS /!\ /!\ /!\
	//generateur de degats :
	// Prend en compte la chance des personnages. Si l'attaque echoue, la chance de l'attaquant augmente pour le prochain combat, et inversement si elle reussit
	// Si l'attaque reussit, les degats sont la force +- un random entre 0 et 10, avec une augmentation si le critique est active en fonction d'un random
	// Le critique est active en fonction de la chance des personnages
	// Si l'attaque echoue, l'ennemi inflige des degats random entre 0 et 10
	// N est l'indicateur a prendre en compte selon le type d'attaque (force, sagesse, agilite)	
	public int degats (int N1, int N2, Personnage Joueur, Personnage Adversaire) {
		int DiffChance =  Joueur.getchance() - Adversaire.getchance();
		int Diff =(int) ((N1-N2)*100/30 + DiffChance + (50*Math.random()-25)); //entre -250 et 250, la diffchance a moyen d'etre entre 60 et -60, force -30 et 30, random -25 et 25
		double Res2 = (int)(Adversaire.getResistance())/30; //entre 0 et 1
		int Dex = (int)(Joueur.getDexterite())*100/30; // entre -100 et 100
		int degats;

		int CCrit = (int) Math.random()*100;
		boolean Crit;
		if(CCrit<(Dex + DiffChance)/2){
			Crit = true;
		}else {
			Crit = false;
		}

		Random Lucky = new Random();
		if(Diff>0) {
			Joueur.setchance((int)(Joueur.getchance()-Math.random()*20));
			if(Lucky.nextBoolean()) {
				degats = (int)(N1 + Math.random()*10);
				degats = (int)(degats - degats*(Res2/100));
			}else {
				degats = (int)(N1 - Math.random()*10);
				degats = (int)(degats - degats*(Res2));
			}
			if(Crit) {
				degats = (int)(degats+degats*(CCrit/100));
			}
			degats = (int) (degats*0.5);
		}else if(Diff<0) {
			Joueur.setchance((int)(Joueur.getchance()+Math.random()*20));
			degats = - (int)(Math.random()*10);
		}else{
			degats = 0;
		}
		return degats;
	}

	public int ArcDegatsChange (int degats, Personnage p1, Personnage p2) {
		double coefdist= Math.exp(-(Math.pow(p1.distance(p2)-3,2)/p1.getStuff().arc.portee));
		degats = (int) (degats*coefdist);
		return degats;
	}



	public void AppliqueAttaque (int Degats, Personnage Joueur, Personnage Adversaire) {
		if(Degats<0) {
			Joueur.setPv(Joueur.getPv()+Degats);
		}else {
			Adversaire.setPv(Adversaire.getPv()-Degats);
		}
	}

	public void sort2 (Personnage p1, Personnage p2) {
		DeroulementJeu.Display("1= Boule de feu ; 2= Degenerescence");
		Scanner d = new Scanner(System.in); 
		final int c = d.nextInt();	
		switch(c) {
		case 1 :
			int degatInflige;
			degatInflige = (int)(1.2*degats(p1.getSagesse(),p2.getSagesse(),p1,p2));
			AppliqueAttaque(degatInflige,p1,p2);

			if(degatInflige==0) {
				DeroulementJeu.Display("Votre sort a echoue. L'incantation n'etait pas parfait et vous pestez contre votre memoire defaillante.");
				DeroulementJeu.Display("Vos barrieres psychiques vous ont cependant protege, au prix de quelque peu de mana.");
			}else if(degatInflige<0) {
				DeroulementJeu.Display("Vous lancez votre boule de feu, qui s'avance et... revient vers vous... ");
				DeroulementJeu.Display("VOus cheveux sentent le roussi, vous l'avez echappe belle. De petites brulures vous font perdre "+degatInflige+"PV");
			}else {
				DeroulementJeu.Display("Vous invoquez le feu et votre adversaire voit les enfers se dechainer sur lui, lui infligeant "+degatInflige+"PV");
			}
			p1.setPa(p1.getPa()-2);
			p1.setMana(p1.getMana()-15);
			break;
		case 2 :
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
				DeroulementJeu.Display("L'ennemi est ensorcele! Vous lui infligez "+degats+ " degats pendant "+ duree+ " tours.");
				int[] effet = {-degats, duree};
				p2.setEvo(effet);
			}
			break;
		}
	}



	public void Attaque (int N, Personnage p1, Personnage p2, int[][][]carte) {
		int degatInflige;
		switch(N) {
		case 1:
			AePlayWave sword = new AePlayWave(System.getProperty("user.dir") + "\\Audio\\Sword.wav");
			if(p1.distance(p2)<2&& p1.getPa()>=2) {
				sword.start();
				degatInflige = degats(p1.getForce(),p2.getForce(),p1,p2);
				AppliqueAttaque(degatInflige,p1,p2);
				if(degatInflige==0) {
					DeroulementJeu.Display("Vous n'avez pu saisir une ouverture dans la defense de votre adversaire.");
					DeroulementJeu.Display("Mais heureusement, vous ne lui avez pas laisse le temps de vous attaquer !");
				}else if(degatInflige<0) {
					DeroulementJeu.Display("L'attaque a echoue... l'adversaire vous a touche \net vous perdez "+degatInflige+"PV");
				}else {
					DeroulementJeu.Display("Vous sortez victorieux de cette passe d'armes ! \nVotre adversaire a subi des blessures, et perd "+degatInflige+"PV");
				}
				p1.setPa(p1.getPa()-2);
				break;
			}else {
				DeroulementJeu.Display("Bien essaye petit malin, attaquer a distance avec une epee,\n quelle idee ! Tu perds tes points d'actions si c'est comme ça !");
				p1.setPa(0);
				break;
			}
		case 2:
			AePlayWave bow = new AePlayWave(System.getProperty("user.dir") + "\\Audio\\Bow.wav");
			if(p1.getPa()>=2 && !p1.isObstacle(p2, carte)) {
				//System.out.println(p1.isObstacle(p2, carte));
				bow.start();
				degatInflige = ArcDegatsChange(degats(p1.getAgilite(),p2.getAgilite(),p1,p2),p1,p2);
				if(degatInflige==0) {
					DeroulementJeu.Display("Vous avez rate votre coup de peu ! La prochaine sera la bonne !");
				}else if(degatInflige<0) {
					DeroulementJeu.Display("Votre fleche est partie au loin, vous pestez contre le vent en vous preparant a encaisser le prochain assaut ennemi");
				}else {
					AppliqueAttaque(degatInflige,p1,p2);
					DeroulementJeu.Display("Votre fleche a atteint son but. Continuez comme ça et votre adversaire deviendra un veritable herisson !");
					DeroulementJeu.Display("Votre adversaire a perdu"+degatInflige+"PV");
				}
				p1.setPa(p1.getPa()-2);
			}else if (p1.getPa()>=2 && p1.isObstacle(p2, carte)) {
				DeroulementJeu.Display("Votre adversaire est a couvert, vous ne pouvez pas l'atteindre.");
			}
			break;				
		case 3:
			sort2(p1,p2);
			break;
		}
	}
}
