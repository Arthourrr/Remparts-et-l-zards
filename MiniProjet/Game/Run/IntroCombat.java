package Run;
import java.util.TimerTask;
import Run.AePlayWave;
// MUSIQUE
public class IntroCombat extends TimerTask{
	

	AePlayWave Combat1 = new AePlayWave("C:\\Users\\antoi\\git\\SuperjeuKitue\\MiniProje\\Audio\\Boss_Battle_Intro01.wav");
	public void run() {
		
		Combat1.run();
	}

}

