package Programme2;
import java.util.Scanner;
public class Actions{	

	
	
	public Actions() {
		
	}
	
	
	public void choixAction (int a, int b, Personnage p1, Personnage p2, int count) { 
		//if(a==4){a=1;}
		//if(a==1){a=2;}
		switch(a){
			case 4 :	
			switch(b) {
			case 1:
				p1.play.melee(p1,p2);
				break;
			case 2 :
				p1.play.arc(p1,p2);
				break;
			case 3 :
				System.out.println("test1");
				p1.play.sort(p1, p2, count);
				System.out.println("test2");
				break; 
			}
			break;
		case 1 :
			switch(b) {
			case 1: 
				p1.play.trainForce(p1);
			case 2:
	            System.out.println("1 = Arc du feu de Dieu \t 2 = Armure des tenebres  \t 3 = epee legendaire \t 4= Potion de soin");
	            Scanner d = new Scanner(System.in); 
	            final int c = d.nextInt();
			    p1.play.acheter(p1, c);
			}
			break;	
		}
	}
	
	public void melee(Personnage p1, Personnage p2) {
		if (p1.distance(p2)<2&& p1.pa>=2) { //Conditions de distance et PA
			p1.pa=p1.pa-2;
			int degats= (int)(2*Math.random()*p1.force); // Degats aleatoires, proportionnels a la force
			if (degats<7) { //En dessous de 5, l'attaque echoue et les degats se retournent vers l'attaquant.
				p1.pv=p1.pv-degats;
				System.out.println("L'attaque echoue. Vous perdez "+ degats+" points de vie.");
			}else {
				int tmp= degats;
				if (degats>0.5*p2.resistance) {
					degats= (int)(degats-0.5*p2.resistance);
				}else {
					degats=0;
					}
				double critique= Math.random();
				if(critique<(p1.dexterite/100)) { //Maxi 20% de chances de faire un coup critique, depend de la dexterite
					degats = degats + tmp;
					p2.pv=(int)(p2.pv-degats);
					System.out.println("Coup critique! Vous infligez "+ degats+" degats a l'adversaire.");
					}
				else {p2.pv=(int)(p2.pv-degats);}//La resistance absorbe une partie des degats.
				System.out.println("L'attaque a reussi. Vous infligez "+ degats+" degats a l'adversaire.");
			}
		}
	}
	
	
	public void arc(Personnage p1, Personnage p2) {
		if (p1.pa>=2) {
			p1.pa= p1.pa-2; // PA consommes
			double coefdist= Math.exp(-(Math.pow(p1.distance(p2)-4,2)/2)); //dagats max pour une distance de 4, repartitionn gaussienne
			int degats= (int)(2*Math.random()*p1.agilite*coefdist);		// Degats aleatoires, proportionnels a l'agilite
			int tmp= degats;
			if (degats>0.5*p2.resistance) {
				degats= (int)(degats-0.5*p2.resistance);
			}else {
				degats=0;
				}
			double critique= Math.random();
			
			if(critique<(p1.dexterite/100)) {
				degats= degats+tmp;
				p2.pv=(int)(p2.pv-degats);
				System.out.println("Coup critique! Vous infligez "+ degats+" degats a l'adversaire.");
				}
			else {
				p2.pv=(int)(p2.pv-degats);
				System.out.println("L'attaque a reussi. Vous infligez "+ degats+" degats a l'adversaire.");
				}
		}
	}
	public void sort (Personnage p1, Personnage p2, int compteur) {
		if(p1.pa>=2) {
			p1.pa=p1.pa-2;
			int duree;
			int degats= (int)(Math.random()*p1.dexterite);
			if (degats>p2.resistance) {
				degats= (int)(degats-0.5*p2.resistance);
			}else {
				degats=0;
				}
			if(p1.sagesse<10) {
				duree=1;
			}else if(p1.sagesse<14) {
				duree=2;
			}else if(p1.sagesse<17){
				duree=3;
			}else {
				duree=4;
			}
			int nbtours= compteur;
			System.out.println("L'ennemi est ensorcelé! ");
			while (compteur < nbtours+duree) {
				p2.pv=(int)(p2.pv-degats);
			}
		}
	}
	public void trainForce (Personnage p1) {
		if(p1.pa>=1) {
			p1.force++;
			p1.pa=p1.pa-2;
			System.out.println("Votre travail acharne et votre abnegation portent leurs fruits. Vous gagnez +1 de force!");
			System.out.println(p1.AfficheStats());
		}
	}	
public void acheter (Personnage p1, int a) {
        switch (a) {
        case (1):
            if (p1.stuff.arc.quantite<1) {
            p1.stuff.arc.quantite ++;
            p1.po=p1.stuff.arc.prix;
            p1.pa--;
            }
        case(2):
            p1.stuff.armure.quantite++;
            p1.po= p1.po - p1.stuff.armure.prix;
            p1.pa--;
        case(3):
            if (p1.stuff.epee.quantite<1) {
            p1.stuff.epee.quantite++;
            p1.po= p1.po - p1.stuff.epee.prix;
            p1.pa--;
            }
        case(4):
            p1.stuff.potion.quantite++;
            p1.po= p1.po - p1.stuff.potion.prix;
            p1.pa--;
        }
    }
    public void utiliser (Personnage p1, int a) {
        switch (a) {
        case(1):
            if(p1.stuff.potion.quantite>0) {
            p1.stuff.potion.quantite--;
            p1.stuff.potion.use(p1);
            }
        }
    }
	/*Jeu TableDeJeu = new Jeu(); // renvoie Ã  une methode de deplacement pour y acceder depuis perso.play
	public static void Move (Personnage p1, Jeu TableDeJeu, int X, int Y){
		p1.MajPosition(X,Y);
		TableDeJeu.DeplacePion(X,Y,perso);
	}*/
}
