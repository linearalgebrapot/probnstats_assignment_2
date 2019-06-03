public class Main {

	public static void main(String[] args) {
		
		System.out.println("---- Distribution Test ----");
		
		
		/* Uniform Distribution */
		UniformDistribution uniformDistribution = new UniformDistribution(100000, 100);
		TransformedDistribution uniformTransformedDistribution = new TransformedDistribution(uniformDistribution, 1, 0, 5*5);
		JointDistribution uniformJointDistribution = new JointDistribution(uniformDistribution, uniformTransformedDistribution);
		
		// 1. Compare original distribution to marginal distribution
//		uniformDistribution.showDistributionData();
//		uniformJointDistribution.showMarginalDistribution1();
//		uniformTransformedDistribution.showDistributionData();
//		uniformJointDistribution.showMarginalDistribution2();
		
		// 2. Get joint distribution (to get graph of x and y)
//		uniformJointDistribution.showTrial();
		
		// 3. Get correlation coefficient
//		uniformJointDistribution.showJointDistributionData();
		
		
		
		/* Poisson Distribution */
		PoissonDistribution poissonDistribution = new PoissonDistribution(100000, 100, 12);
		TransformedDistribution poissonTransformedDistribution = new TransformedDistribution(poissonDistribution, 1, 0, 5*5);
		JointDistribution poissonJointDistribution = new JointDistribution(poissonDistribution, poissonTransformedDistribution);

		// 1. Compare original distribution to marginal distribution
//		poissonDistribution.showDistributionData();
//		poissonJointDistribution.showMarginalDistribution1();
//		poissonTransformedDistribution.showDistributionData();
//		poissonJointDistribution.showMarginalDistribution2();
		
		// 2. Get joint distribution (to get graph of x and y)
//		poissonJointDistribution.showTrial();
		
		// 3. Get correlation coefficient
//		poissonJointDistribution.showJointDistributionData();
		
		
		/* Normal Distribution */
		NormalDistribution normalDistribution = new NormalDistribution(100000, 3, 1);
		TransformedDistribution normalTransformedDistribution = new TransformedDistribution(normalDistribution, 1, 0, 5*5);
		JointDistribution normalJointDistribution = new JointDistribution(normalDistribution, normalTransformedDistribution);
		
		// 1. Compare original distribution to marginal distribution
//		normalDistribution.showDistributionData();
//		normalJointDistribution.showMarginalDistribution1();
//		normalTransformedDistribution.showDistributionData();
//		normalJointDistribution.showMarginalDistribution2();
		
		// 2. Get joint distribution (to get graph of x and y)
//		normalJointDistribution.showTrial();
		
		// 3. Get correlation coefficient
//		normalJointDistribution.showJointDistributionData();
		
	}

}
