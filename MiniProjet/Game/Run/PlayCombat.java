package Run;
import java.util.TimerTask;
import Run.AePlayWave;
//MUSIQUE
public class PlayCombat extends TimerTask{
	

	AePlayWave Combat2 = new AePlayWave("C:\\Users\\antoi\\git\\SuperjeuKitue\\MiniProjet\\Audio\\Boss_Battle_Loop01.wav");
	public void run() {
		
		Combat2.run();
	}

}

