import java.util.Random;

public class NormalDistribution extends Distribution {
	public NormalDistribution(int numberOfTrial, double mean, double variance) {
		super(numberOfTrial);
		for (int i=0; i<numberOfTrial; i++) {
			double x = new Random().nextGaussian();
			x = Math.sqrt(variance) * x + mean;
			setTrial(i, x);
		}
		setPointArray();
	}
}