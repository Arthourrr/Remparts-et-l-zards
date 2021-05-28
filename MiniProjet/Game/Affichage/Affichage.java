package Affichage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import World.Jeu;
/**
 * Gestionnaire d'affichage pour le jeu de la vie.
 * @author Brice Chardin, modifiee par Jean-Francois TREGOUET
 */
public class Affichage extends JFrame {

	//BufferedImage img1 = new BufferedImage(50,50, BufferedImage.TYPE_INT_RGB);


	private static Affichage world = null;
	private PanneauGrille pg;
	private static String det;
	private static String modeJeu;

	private Affichage(int[][] monde, int maRes) {
		super("Remparts et Lézards");
		pg = new PanneauGrille(monde, maRes);
		setContentPane(pg);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Surcharge de la methode afficherMonde qui permet de laisser le
	 * programme choisir la resolution la plus appropriee a la taille
	 * de l'ecran.
	 * @param monde le monde à afficher
	 */
	public static void afficherMonde(int[][] monde, int a, String carte) {
		afficherMonde(monde,calcRes(monde), a, carte);
	}

	/**
	 * Affiche un monde.
	 * @param monde le monde à afficher
	 * @param res longueur d'un coté de cellule (en nombre de pixel)
	 */
	public static void afficherMonde(int[][] monde, int maRes, int a, String carte) {
		if (world==null) {
			world = new Affichage(monde,maRes);
		}
		world.pg.monde = monde;
		world.repaint();
		det= ""+a;
		modeJeu = carte;
	}

	/**
	 * Calcul la resolution la plus appropriee a la taille du monde de
	 * facon a ce que la fenetre occupe 80% de la hauteur ou de la
	 * largeur de la zone utile de l'ecran
	 * de l'ecran.
	 * @param monde le monde à afficher
	 */
	private static int calcRes(int[][] monde) {
		final double p = .8; // pourcentage de la zone utile a occuper
		int resC;
		Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds(); // Taille zone utile
		resC = Math.min((int)(bounds.height*p)/monde.length,(int)(bounds.width*p)/monde[0].length);
		resC = Math.max(1,resC); // valeur planche de 1
		resC= 100;
		return resC;
	}

	static class PanneauGrille extends JPanel {
		private int res;
		private BufferedImage worldImage;
		public int[][] monde;
		public PanneauGrille(int[][] monde, int maRes) {
			res = maRes;
			worldImage = new BufferedImage(res*monde[0].length,res*monde.length,BufferedImage.TYPE_INT_RGB);
			// System.out.println(new Dimension(res*monde[0].length,res*monde.length));
			setPreferredSize(new Dimension(res*monde[0].length,res*monde.length));
		}
		private void dessineMonde(Graphics g) {
			int nbL = monde.length;
			int nbC = monde[0].length;
			//System.out.println(res);
			AfficheImage(System.getProperty("user.dir") +"\\Graphics\\Plateau."+modeJeu+".png", g, 1783, 1783, 165*5, 165*5, 0, 0, 0, 0);

			for (int i = 0; i < nbL; i++)
				for (int j = 0; j < nbC; j++) {
					switch (monde[i][j]) {
					case (-1):
						AfficheEntite("Guerrier.B"+det+".png", g, i, j);
					break;
					case (-2):
						AfficheEntite("Guerrier.R"+det+".png", g, i, j);
					break;
					case (-3):
						AfficheEntite("Obstacle.Buisson"+".png", g, i, j);
					break;
					case (-4):
						AfficheEntite("Obstacle.Rocher"+".png", g, i, j);
					break;
					case (-5):
						AfficheEntite("Obstacle.Fissures.png", g, i, j);
					break;
					case (-6):
						AfficheEntite("Obstacle.Trou.png", g, i, j);
					break;
					}
					if (monde[i][j]>0 && monde[i][j]<100) {
						AfficheEntite("Pièces"+det+".png", g, i, j);
					}
				}      
			/* // couleur de fond
            g.setColor(Color.WHITE);
            g.fillRect(0,0,res*nbC,res*nbL);
            // cellules
            for (int i = 0; i < nbL; i++)
                for (int j = 0; j < nbC; j++)
                    if (monde[i][j]==-1) {
                    	g.setColor(Color.BLUE);
                        g.fillRect(res*j,res*i,res,res);
                    } else {
                    	if (monde[i][j]==-2) {
                    		g.setColor(Color.RED);
                    		g.fillRect(res*j, res*i, res, res);
                    	} else {
                        	if (monde[i][j]>0 && monde[i][j]<100) {
                        		g.setColor(Color.YELLOW);
                        		g.fillRect(res*j, res*i, res, res);
                        	}
                    	}
                    }*/  
		}


		public void paint(Graphics g) {
			Graphics gw = worldImage.getGraphics();
			dessineMonde(gw);
			g.drawImage(worldImage,0,0,null);
		}
		public static void AfficheEntite (String fileName, Graphics g, int i, int j) {
			AfficheImage(System.getProperty("user.dir") +"\\Graphics\\" +fileName, g, 1783, 1783, i*100+600, j*96+600, j*96+20, i*96+20, 0, 0); 
		}
		public static void AfficheImage(String filepath, Graphics g, int nbC, int nbL, int h, int w, int x1, int y1, int x2, int y2 ) {

			File img = new File (filepath);
			if (!img.exists()) { 
				System.err.println("Image file not found: " + img.getName());
				return;
			}

			try {
				Image sprite = ImageIO.read(img);
				//int h = sprite.getHeight(rootPane);
				//int w = sprite.getWidth(rootPane);
				//h = (int)(0.*h);
				//w = (int)(0.8*w);
				g.drawImage(sprite, x1, y1, w, h, x2, y2, nbC, nbL, new ImageObserver() { 
					//ordre params: x.tlcorner, y.tlcorner, largeur, hauteur, x.brcorner, y.brcorner

					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						System.out.println("Image redimmensionnee");					return false;
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		/*public void AfficheImage(String filepath, Graphics g, int nbC, int nbL, int x1, int y1, int x2, int y2 ) {//surcharge avec dimensions auto

       	 File img = new File (filepath);
            if (!img.exists()) { 
                System.err.println("Image file not found: " + getName());
                return;
            }

            try {
            	Image sprite = ImageIO.read(img);
            	int h = sprite.getHeight(rootPane);
            	int w = sprite.getWidth(rootPane);
            	g.drawImage(sprite, 0, 0, w, h, 0, 0, res*nbC, res*nbL, new ImageObserver() { 
            		//ordre params: x.tlcorner, y.tlcorner, largeur, hauteur, x.brcorner, y.brcorner

    				@Override
    				public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
    					System.out.println("Image redimmensionnee");					return false;
    				}
    			});
            } catch (IOException e) {
            	e.printStackTrace();
            } 
       }*/
	}
	public static void pause(long lag) {
		try {
			Thread.sleep(lag);
		} catch (InterruptedException e) {
		}
	}
}       

