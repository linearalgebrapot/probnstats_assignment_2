import java.util.Random;

public class UniformDistribution extends Distribution {
	public UniformDistribution(int numberOfTrial, int numberOfInterval) {
		super(numberOfTrial);
		for (int i=0; i<numberOfTrial; i++) {
			int randomNumber = new Random().nextInt(numberOfInterval);
			setTrial(i, randomNumber);
		}
		setPointArray();
	}
	
	public UniformDistribution(int numberOfTrial, int numberOfInterval, double from, double to) {
		super(numberOfTrial);
		for (int i=0; i<numberOfTrial; i++) {
			double randomNumber = new Random().nextInt(numberOfInterval);
			randomNumber = randomNumber * (to - from) / numberOfInterval  + from;
			setTrial(i, randomNumber);
		}
		setPointArray();
	}
}