public class Main {

	public static void main(String[] args) {
		
		System.out.println("---- Distribution Test ----");
		/* uncomment below to print results */
		
		
		/* Uniform Distribution */
		UniformDistribution uniformDistribution = new UniformDistribution(100000, 100);
		TransformedDistribution uniformTransformedDistribution = new TransformedDistribution(uniformDistribution, 1, 0, 5*5);
		JointDistribution uniformJointDistribution = new JointDistribution(uniformDistribution, uniformTransformedDistribution);
		
//		uniformDistribution.showDistributionData();
//		uniformTransformedDistribution.showDistributionData();
//		uniformJointDistribution.showJointDistributionData();
		
//		uniformJointDistribution.showTrial();
		
		
		/* Poisson Distribution */
		PoissonDistribution poissonDistribution = new PoissonDistribution(100000, 100, 12);
		TransformedDistribution poissonTransformedDistribution = new TransformedDistribution(poissonDistribution, 1, 0, 5*5);
		JointDistribution poissonJointDistribution = new JointDistribution(poissonDistribution, poissonTransformedDistribution);

//		poissonDistribution.showDistributionData();
//		poissonTransformedDistribution.showDistributionData();
//		poissonJointDistribution.showJointDistributionData();
		
//		poissonJointDistribution.showTrial();
		
		
		/* Normal Distribution */
		NormalDistribution normalDistribution = new NormalDistribution(100000, 0, 1);
		TransformedDistribution normalTransformedDistribution = new TransformedDistribution(normalDistribution, 1, 0, 5*5);
		JointDistribution normalJointDistribution = new JointDistribution(normalDistribution, normalTransformedDistribution);
		
//		normalDistribution.showDistributionData();
//		normalTransformedDistribution.showDistributionData();
//		normalJointDistribution.showJointDistributionData();
		
//		normalJointDistribution.showTrial();
		
		
		/* Binomial Distribution */
		BinomialDistribution binomialDistribution = new BinomialDistribution(100000, 5, 0.7);
		TransformedDistribution binomialTransformedDistribution = new TransformedDistribution(binomialDistribution, 1, 0, 5*5);
		JointDistribution binomialJointDistribution = new JointDistribution(binomialDistribution, binomialTransformedDistribution);
		
//		binomialDistribution.showDistributionData();
//		binomialTransformedDistribution.showDistributionData();
//		binomialJointDistribution.showJointDistributionData();
		
//		binomialJointDistribution.showTrial();
		
	}

}
