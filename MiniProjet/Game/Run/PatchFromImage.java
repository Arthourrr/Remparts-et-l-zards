package Run;
public class PatchFromImage {
	// Random example v01.0
	    public static void main(String[] args) {
	        PatchFromImage motif = new PatchFromImage(1500, 1000);
	        motif.generate();
	        motif.show();        // affichage taille réelle
	        motif.show(600,400); // affichage redimensionné
	        motif.save("genPatch.jpg");
	    }



	    private int nbCols;
	    private int nbRows;
	    private int[][] arrayR;
	    private int[][] arrayG;
	    private int[][] arrayB;
	    private ImageToolbox tools;
	    private int side;

	    public PatchFromImage(int nbCols, int nbRows){
	        // Image size : nbRows x nbCols
	        this.nbCols = nbCols;
	        this.nbRows = nbRows;
	                
	        this.arrayR = new int[nbRows][nbCols];
	        this.arrayG = new int[nbRows][nbCols];
	        this.arrayB = new int[nbRows][nbCols];

	        this.tools = new ImageToolbox();

	        side = 40; // side length
	    }


	    public void generate(){
	        int backgroundR = 250;
	        int backgroundG = 150;
	        int backgroundB = 150;
	        
	        int[][][] image = tools.readImagetoRGBarrays("krokmou.png");
	        
	        int nbRowsPatch = image[0].length;
	        int nbColsPatch = image[0][1].length;
	       
	        System.out.println("Patch size: " + nbRowsPatch + " x " + nbColsPatch);
	        
	        for(int i = 0; i < nbRows; i++){ // loop over rows
	            for(int j = 0; j < nbCols; j++){ // loop over columns
	            
	                arrayR[i][j] =  image[0][i % nbRowsPatch][j % nbColsPatch];
	                arrayG[i][j] =  image[1][i % nbRowsPatch][j % nbColsPatch];
	                arrayB[i][j] =  image[2][i % nbRowsPatch][j % nbColsPatch];
	                
	            }
	        }
	    }



	    // Visualization in a window, without rescaling.
	    public void show(){
	        tools.visuRGBarrays("genPatch", arrayR, arrayG, arrayB);
	    } 
	           
	    // Visualization in a window, with rescaling to fit the new window size.
	    public void show(int w, int h){
	        tools.visuRGBarrays("genPatch", arrayR, arrayG, arrayB, w, h);
	    }
	                        
	    // Save image in JPEG file
	    public void save(String name){
	        tools.writeRGBarrays(name, arrayR, arrayG, arrayB);
	    }
	}