package Affichage;
import java.awt.Graphics;
import java.util.TimerTask;
import Run.AePlayWave;

public class Animation1 extends Thread{
	
	String File1;
	String File2;
	Graphics g;
	final int i= 0;
	final int j= 0;
	
	public Animation1 (String Filea, String Fileb, Graphics G, int i, int j) {
		this.File1 = Filea;
		this.File2 = Fileb;
		this.g=G;
		//this.i=i;
		//this.j=j;
	}

	ShowImage disp1 = new ShowImage("GuerrierB1.png", g,  i,  j);
	ShowImage disp2 = new ShowImage("GuerrierB2.png", g,  i,  j);
	public void run(){
		//while(true){
			disp1.start();
			System.out.println(File1);
    		/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}*/
    		disp2.start();
			System.out.println(File2);	
    		/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}*/
    	//}
	}
}

