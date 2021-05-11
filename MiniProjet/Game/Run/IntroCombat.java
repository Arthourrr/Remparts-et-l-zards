package Run;
import java.util.TimerTask;
import Run.AePlayWave;

public class IntroCombat extends TimerTask{
	

	AePlayWave Combat1 = new AePlayWave("A:\\Documents\\INSA\\20-21\\Info\\Projet1\\MiniProjet\\Audio\\Boss_Battle_Intro01.wav");
	public void run() {
		
		Combat1.run();
	}

}

