import java.util.Random;

public class BinomialDistribution extends Distribution {
	public BinomialDistribution(int numberOfTrial, int numberOfBernoulliTrial, double probability) {
		super(numberOfTrial);
		for (int i=0; i<numberOfTrial; i++) {
			int x = 0;
			for (int j=0; j<numberOfBernoulliTrial; j++) {
				int randomNumber = new Random().nextInt(1000);
				if (randomNumber < probability * 1000) x++;
			}
			setTrial(i, x);
		}
		setPointArray();
	}
}