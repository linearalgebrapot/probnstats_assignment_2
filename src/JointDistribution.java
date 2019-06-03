import java.util.Arrays;

public class JointDistribution {
	private Point[] trial; // result of every trial(every random variables)
	private Point3D[] point3DArray; // result of x(random variable 1), y(random variable 2), and z(probability)
	private Distribution distribution1, distribution2;
	
	public JointDistribution(Distribution distribution1, Distribution distribution2) {
		if (distribution1.getNumberOfTrial() == distribution2.getNumberOfTrial()) {
			this.distribution1 = new Distribution(distribution1);
			this.distribution2 = new Distribution(distribution2);
			int numberOfTrial = distribution1.getNumberOfTrial();
			double trial1[] = distribution1.getTrial();
			double trial2[] = distribution2.getTrial();
			
			trial = new Point[numberOfTrial];
			for (int i=0; i<numberOfTrial; i++) {
				trial[i] = new Point(trial1[i], trial2[i]);
			}
			
			setPoint3DArray();
		}
		else System.out.println("trial length is different");
	}
	
	private void setPoint3DArray() {
		// sort trial
		Point[] sortedTrial = new Point[trial.length];
		for (int i=0; i<sortedTrial.length; i++) {
			sortedTrial[i] = new Point(trial[i]);
		}
		Arrays.sort(sortedTrial);
		
		// get number of unique (x, y)
		int numberOfUniqueXY = 1;
		double previousX = sortedTrial[0].getX();
		double previousY = sortedTrial[0].getY();
		for (int i=1; i<sortedTrial.length; i++) {
			if (previousX != sortedTrial[i].getX() || previousY != sortedTrial[i].getY()) numberOfUniqueXY++;
			previousX = sortedTrial[i].getX();
			previousY = sortedTrial[i].getY();
		}
		
		// initialize point3DArray
		point3DArray = new Point3D[numberOfUniqueXY];
		for (int i=0; i<point3DArray.length; i++) {
			point3DArray[i] = new Point3D();
		}
		
		// set point3DArray ((x, y) is unique (x, y), z is frequency)
		point3DArray[0].setX(sortedTrial[0].getX());
		point3DArray[0].setY(sortedTrial[0].getY());
		point3DArray[0].setZ(1);
		int point3DArrayIndex = 0;
		for (int i=1; i<sortedTrial.length; i++) {
			if(point3DArray[point3DArrayIndex].getX() == sortedTrial[i].getX() && point3DArray[point3DArrayIndex].getY() == sortedTrial[i].getY()) {
				point3DArray[point3DArrayIndex].setZ(point3DArray[point3DArrayIndex].getZ()+1);
			}
			else {
				point3DArrayIndex++;
				point3DArray[point3DArrayIndex].setX(sortedTrial[i].getX());
				point3DArray[point3DArrayIndex].setY(sortedTrial[i].getY());
				point3DArray[point3DArrayIndex].setZ(1);
			}
		}
		
		// change z (from frequency to probability)
		for (int i=0; i<point3DArray.length; i++) {
			point3DArray[i].setZ(point3DArray[i].getZ() / sortedTrial.length);
		}
	}
	
	public void showMarginalDistribution1() {
		// get number of unique x
		int numberOfUniqueX = 1;
		double previousX = point3DArray[0].getX();
		for (int i=1; i<point3DArray.length; i++) {
			if (previousX != point3DArray[i].getX()) numberOfUniqueX++;
			previousX = point3DArray[i].getX();
		}
		
		// initialize marginalDistribution1
		Point[] marginalDistribution1 = new Point[numberOfUniqueX];
		for (int i=0; i<marginalDistribution1.length; i++) {
			marginalDistribution1[i] = new Point();
		}
		
		// set marginalDistribution1 (x is unique x, y is frequency)
		marginalDistribution1[0].setX(point3DArray[0].getX());
		marginalDistribution1[0].setY(1);
		int marginalDistribution1Index = 0;
		for (int i=1; i<point3DArray.length; i++) {
			if (marginalDistribution1[marginalDistribution1Index].getX() == point3DArray[i].getX()) marginalDistribution1[marginalDistribution1Index].setY(marginalDistribution1[marginalDistribution1Index].getY()+1);
			else {
				marginalDistribution1Index++;
				marginalDistribution1[marginalDistribution1Index].setX(point3DArray[i].getX());
				marginalDistribution1[marginalDistribution1Index].setY(1);
			}
		}
		
		// change y (from frequency to probability)
		for (int i=0; i<marginalDistribution1.length; i++) {
			marginalDistribution1[i].setY(marginalDistribution1[i].getY() / point3DArray.length);
		}
		
		// show marginalDistribution1
		System.out.println("RV, probability: ");
		for (int i=0; i<marginalDistribution1.length; i++) {
			System.out.println(marginalDistribution1[i].getX() + " " + marginalDistribution1[i].getY());
		}
	}
	
	public void showMarginalDistribution2() {
		// get number of unique x
		int numberOfUniqueX = 1;
		double previousX = point3DArray[0].getY();
		for (int i=1; i<point3DArray.length; i++) {
			if (previousX != point3DArray[i].getY()) numberOfUniqueX++;
			previousX = point3DArray[i].getY();
		}
		
		// initialize marginalDistribution2
		Point[] marginalDistribution2 = new Point[numberOfUniqueX];
		for (int i=0; i<marginalDistribution2.length; i++) {
			marginalDistribution2[i] = new Point();
		}
		
		// set marginalDistribution2 (x is unique x, y is frequency)
		marginalDistribution2[0].setX(point3DArray[0].getY());
		marginalDistribution2[0].setY(1);
		int marginalDistribution2Index = 0;
		for (int i=1; i<point3DArray.length; i++) {
			if (marginalDistribution2[marginalDistribution2Index].getX() == point3DArray[i].getY()) marginalDistribution2[marginalDistribution2Index].setY(marginalDistribution2[marginalDistribution2Index].getY()+1);
			else {
				marginalDistribution2Index++;
				marginalDistribution2[marginalDistribution2Index].setX(point3DArray[i].getY());
				marginalDistribution2[marginalDistribution2Index].setY(1);
			}
		}
		
		// change y (from frequency to probability)
		for (int i=0; i<marginalDistribution2.length; i++) {
			marginalDistribution2[i].setY(marginalDistribution2[i].getY() / point3DArray.length);
		}
		
		// show marginalDistribution2
		System.out.println("RV, probability: ");
		for (int i=0; i<marginalDistribution2.length; i++) {
			System.out.println(marginalDistribution2[i].getX() + " " + marginalDistribution2[i].getY());
		}
	}
	
	public double getMean() { // get E[XY]
		double mean = 0;
		for (int i=0; i<point3DArray.length; i++) {
			mean += point3DArray[i].getX() * point3DArray[i].getY() * point3DArray[i].getZ();
		}
		return mean;
	}
	
	public double getCovariance() {
		double covariance = getMean() - distribution1.getMean() * distribution2.getMean();
		return covariance;
	}
	
	public double getCorrelationCoefficient() {
		double correlationCoefficient = getCovariance() / (Math.sqrt(distribution1.getVariance()) * Math.sqrt(distribution2.getVariance()));
		return correlationCoefficient;
	}
	
	public void showTrial() {
		System.out.println("trial :");
		for (int i=0; i<trial.length; i++) {
			System.out.println(trial[i].getX() + " " + trial[i].getY());
		}
	}
	
	public void showJointDistributionData() {
		System.out.println("RV1, RV2, probability :");
		for (int i=0; i<point3DArray.length; i++) {
			System.out.println(point3DArray[i].getX() + " " + point3DArray[i].getY() + " " + point3DArray[i].getZ());
		}
		System.out.println("mean : " + getMean());
		System.out.println("covariance : " + getCovariance());
		System.out.println("correlation coefficient : " + getCorrelationCoefficient());
	}
}
