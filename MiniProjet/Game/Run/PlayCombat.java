package Run;
import java.util.TimerTask;
import Run.AePlayWave;

public class PlayCombat extends TimerTask{
	

	AePlayWave Combat2 = new AePlayWave("A:\\Documents\\INSA\\20-21\\Info\\Projet1\\MiniProjet\\Audio\\Boss_Battle_Loop01.wav");
	public void run() {
		
		Combat2.run();
	}

}

