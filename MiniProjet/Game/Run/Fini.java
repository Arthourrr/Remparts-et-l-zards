package Run;

import Champion.Personnage;

public class Fini extends Thread{
	Personnage p1;
	Personnage p2;
	int[][][]plateau;	//int tmp;
	public Fini (Personnage p1, Personnage p2, int[][][]plateau){
		this.p1=p1;
		this.p2=p2;
		this.plateau = plateau;
	}
	@Override
	public void run() {
		for (int i=0; i< plateau.length; i++) {
			for (int j=0; j< plateau[0].length; j++) {
				if (plateau[i][j][0]==-6 && plateau[i][j][2]==-1) {
					p1.setPv(0);
					System.out.println("Vous êtes tombé dans la lave!");
				}else if (plateau[i][j][0]==-6 && plateau[i][j][2]==-2) {
					p2.setPv(0);
					System.out.println("Vous êtes tombé dans la lave!");
				}
			}
		}
		if(p1.getPv()<=0 || p2.getPv()<=0) {
			Run.DeroulementJeu.Gagnant(0, p1, p2);
			System.exit(MAX_PRIORITY);
		} else
			//System.out.println(tmp);
			//tmp++;
			try {
				Fini.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.run();
	}
}
