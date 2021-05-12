package Run;
import java.util.TimerTask;

public class PlayCombat extends TimerTask{
	

	AePlayWave Combat2 = new AePlayWave(System.getProperty("user.dir") + "\\Audio\\Boss_Battle_Loop01.wav");
	public void run() {
		
		Combat2.run();
	}

}

