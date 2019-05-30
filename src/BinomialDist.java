
public class BinomialDist extends Dist{
	double prob;
	
	public BinomialDist(int n, double p) {
		super(n);
		this.prob = p;
		
		for(int i=0;i<pointSet.length;i++)
			pointSet[i] = new Point();
	}

	public void simulateBinomialDist() {
		for(int i=0;i<domain;i++) {
			pointSet[i].x = i;
			pointSet[i].y = ProbAndStat.combination(domain, i) * Math.pow(prob, i) * Math.pow(1-prob, domain-i);
		}
	}

}
