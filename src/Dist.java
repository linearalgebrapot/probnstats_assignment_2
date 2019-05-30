public class Dist {
	public Point[] pointSet;
	public int domain;
	
	public Dist(int domain) {
		this.domain = domain;
		pointSet = new Point[domain];
		
		for(int i=0;i<pointSet.length;i++)
			pointSet[i] = new Point();
		
		//simulateDist2();
	}
	
	public Dist(Dist d) {
		//System.out.println("ok11");
		this.domain = d.domain;
		//System.out.println("ok22");
		this.pointSet = new Point[domain];
		//System.out.println("ok33");
		for(int i=0;i<pointSet.length;i++)
			pointSet[i] = new Point(d.pointSet[i]);
		//System.out.println("ok44");
	}
	
	public double getMean() {
		double mean = 0;
		
		for(int i=0;i<pointSet.length;i++) {
			mean =  mean + (pointSet[i].value*pointSet[i].y);
		}
		
		return mean;
	}
	
	public double getFirstMoment() {
		double mean = 0;
		
		for(int i=0;i<pointSet.length;i++) {
			mean =  mean + pointSet[i].value*pointSet[i].y;
		}
		
		return mean;
	}
	
	public double getSecondMoment() {
		double average = 0;
		
		for(int i=0;i<pointSet.length;i++) {
			average = average + pointSet[i].value*pointSet[i].value*pointSet[i].y;
		}
		
		return average;
	}
	
	public double getVariance() {
		return getSecondMoment() - getFirstMoment() * getFirstMoment();
	}
	
	//public double get
	
	
	public static double getCorrelationCoefficient(Dist d1, Dist d2) {
		double coCo = 0;
		Dist d1d2 = new Dist(d1.domain*d2.domain);
		
		for(int j=0;j<d2.pointSet.length;j++) {
			for(int i=0;i<d1.pointSet.length;i++) {
				d1d2.pointSet[d2.domain*j+i].value = d2.pointSet[j].value * d1.pointSet[i].value;
				d1d2.pointSet[d2.domain*j+i].y = d2.pointSet[j].y * d1.pointSet[i].y; //여기 이상함. 이게 성립하려면 둘이 독립이여야 함
			}
		}
		
		coCo = (d1d2.getMean() - d1.getMean() * d2.getMean()) / (Math.sqrt(d1.getVariance()) * Math.sqrt(d2.getVariance()));
		
		return coCo;
	}
	
	public void showData() {
		System.out.println("Show data : ");
//		for(int i=0;i<pointSet.length;i++) 
//			System.out.println("(" + pointSet[i].x + ", " + pointSet[i].y + ") : " + pointSet[i].value);
		
		System.out.println("Domain : 0 <= x <= " + (domain-1));
		System.out.println("Mean : " + getMean());
		System.out.println("Variance : " + getVariance());	
	}
	
	public void simulate() {}
}
