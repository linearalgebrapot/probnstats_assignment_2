import java.util.Random;

public class TransformedDistribution extends Distribution {
	public TransformedDistribution(Distribution distribution, double a, double b, double variance) {
		super(distribution.getNumberOfTrial());
		double[] trial = distribution.getTrial();
		for (int i=0; i<getNumberOfTrial(); i++) {
			setTrial(i, a * trial[i] + b + randomNormalDistribution(0, variance));
		}
		setPointArray();
	}
	
	private double randomNormalDistribution(double mean, double variance) {
		double x = new Random().nextGaussian();
		return Math.sqrt(variance) * x + mean;
	}
}
