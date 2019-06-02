import java.util.Random;

public class PoissonDistribution extends Distribution{		
	public PoissonDistribution(int numberOfTrial, int numberOfInterval, double lambda) {
		super(numberOfTrial);
		for (int i=0; i<numberOfTrial; i++) {
			int x = 0;
			for (int j=0; j<numberOfInterval; j++) {
				int randomNumber = new Random().nextInt(numberOfInterval);
				if (randomNumber < lambda) x++;
			}
			setTrial(i, x);
		}
		setPointArray();
	}
}
