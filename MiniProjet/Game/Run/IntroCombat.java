package Run;
import java.util.TimerTask;
//classe de lancement de la musique 2
public class IntroCombat extends TimerTask{
	AePlayWave Combat1 = new AePlayWave(System.getProperty("user.dir") + "\\Audio\\Boss_Battle_Intro01.wav");
	public void run() {
		
		Combat1.run();
	}

}

