package Run;
import java.util.Scanner;


public class Update extends Thread {
	public int val=3000;


	public void run(){
		Scanner stop = new Scanner(System.in);
		//while(true) {
			int tmp = stop.nextInt();
			if (tmp==0) {
			this.val = 0;
			//}
		}
	}


}
